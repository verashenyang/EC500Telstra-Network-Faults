package rf;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * Random Forest
 * 
 */
public class RandomForest {
	
	public static String pathname="/Users/xiaofan/Documents/workspaceluna/random forest/test_result.txt";
	
	/** the number of threads to use when generating the forest */
	private static final int NUM_THREADS=Runtime.getRuntime().availableProcessors();
	/** the number of categorical responses of the data (the classes, the "Y" values) - set this before beginning the forest creation */
	public static int C;
	/** the number of attributes in the data - set this before beginning the forest creation */
	public static int M;
	/** Of the M total attributes, the random forest computation requires a subset of them
	 * to be used and picked via random selection. "Ms" is the number of attributes in this
	 * subset. The formula used to generate Ms was recommended on Breiman's website.
	 */
	public static int Ms;
	/** the collection of the forest's decision trees */
	private ArrayList<DTree> trees;
	/** the starting time when timing random forest creation */
	private long time_o;
	/** the number of trees in this random tree */
	private int numTrees;
	/** For progress bar display for the creation of this random forest, this is the amount to update by when one tree is completed */
	private double update;
	/** For progress bar display for the creation of this random forest, this records the total progress */
	private double progress;
	/** this is an array whose indices represent the forest-wide importance for that given attribute */
	private int[] importances;
	/** This maps from a data record to an array that records the classifications by the trees where it was a "left out" record (the indices are the class and the values are the counts) */
	private HashMap<int[],int[]> estimateOOB;
	/** This holds all of the predictions of trees in a Forest */
	private ArrayList<ArrayList<Integer>> Prediction;
	/** the total forest-wide error */
	private double error;
	/** the thread pool that controls the generation of the decision trees */
	private ExecutorService treePool;
	/** the original training data matrix that will be used to generate the random forest classifier */
	private ArrayList<int[]> data;
	/** the data on which produced random forest will be tested*/
	private ArrayList<int[]> testdata;
	/**
	 * Initializes a Random forest creation
	 * 
	 * @param numTrees			the number of trees in the forest
	 * @param data				the training data used to generate the forest
	 * @param buildProgress		records the progress of the random forest creation
	 */
	public RandomForest(int numTrees, ArrayList<int[]> data, ArrayList<int[]> t_data ){
		this.numTrees=numTrees;
		this.data=data;
		this.testdata=t_data;
		trees=new ArrayList<DTree>(numTrees);
		update=100/((double)numTrees);
		progress=0;
		StartTimer();
		System.out.println("creating "+numTrees+" trees in a random Forest. . . ");
		System.out.println("total data size is "+data.size());
		System.out.println("number of attributes "+(data.get(0).length-1));
		System.out.println("number of selected attributes "+((int)Math.round(Math.log(data.get(0).length-1)/Math.log(2)+1)));
		estimateOOB=new HashMap<int[],int[]>(data.size());
		Prediction = new ArrayList<ArrayList<Integer>>();
	}
	/**
	 * Begins the random forest creation
	 * @throws IOException 
	 */
	public void Start() throws IOException {
		System.out.println("Number of threads started : "+NUM_THREADS);
		System.out.print("Running...");
		treePool=Executors.newFixedThreadPool(NUM_THREADS);
		for (int t=0;t<numTrees;t++){
			treePool.execute(new CreateTree(data,this,t+1));
			System.out.print(".");
		}treePool.shutdown();
		try {	         
			treePool.awaitTermination(Long.MAX_VALUE,TimeUnit.SECONDS); //effectively infinity
	    } catch (InterruptedException ignored){
	    	System.out.println("interrupted exception in Random Forests");
	    } 
		System.out.println("");
		System.out.println("Finished tree construction");
		TestForest(trees,testdata);
	    System.out.println("Done in "+TimeElapsed(time_o));
	}
	public void writefile(ArrayList<Integer> pred) throws IOException{
		
		File writeName=new File(pathname);
		writeName.createNewFile();
		BufferedWriter out=new BufferedWriter(new FileWriter(writeName));
		for(int i=0;i<pred.size();i++){
			out.write(pred.get(i)+"\r\n");
		}		
		out.flush();
		out.close();
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	private void TestForest(ArrayList<DTree> collec_tree,ArrayList<int[]> test_data ) throws IOException {
		int correstness = 0 ;int k=0;
		ArrayList<Integer> ActualValues = new ArrayList<Integer>();
		ArrayList<Integer> pred=new ArrayList<Integer>();
		for(int[] rec:test_data){
			ActualValues.add(rec[rec.length-1]);
		}int treee=1;
		for(DTree dt:collec_tree){
			dt.CalculateClasses(test_data,treee);
			Prediction.add(dt.predictions);
		}
		for(int i = 0;i<test_data.size();i++){
			ArrayList<Integer> Val = new ArrayList<Integer>();
			for(int j =0;j<collec_tree.size();j++){
				Val.add(Prediction.get(j).get(i));
			}
			pred.add(ModeOf(Val)-1);
			if(pred.get(i) == ActualValues.get(i)-1){
				correstness=correstness+1;
			}
		}
		writefile(pred);
		System.out.println("Accuracy of Forest is : "+(100*correstness/test_data.size())+"%");
	}
	private int ModeOf(ArrayList<Integer> treePredict) {
		// TODO Auto-generated method stub
		int count0 = 0,count1 = 0,count2 = 0;
		for(int i=0; i<treePredict.size();i++){			
			if(treePredict.get(i)==1){
						count0++;
			}			
			if(treePredict.get(i)==2){
						count1++;
			}
			if(treePredict.get(i)==3){
						count2++;
			}
		}
		if(count2 >= treePredict.size()*0.13){
			return 3;
		}
		else if(count1 >= treePredict.size()*0.427){
			return 2;
		}
		else{
			return 1;
		}
		
	}
	/**
	 * This calculates the forest-wide error rate. For each "left out" 
	 * data record, if the class with the maximum count is equal to its actual
	 * class, then increment the number of correct. One minus the number correct 
	 * over the total number is the error rate.
	 */
	private void CalcErrorRate(){
		double N=0;
		int correct=0;
		for (int[] record:estimateOOB.keySet()){
			N++;
			int[] map=estimateOOB.get(record);
			int Class=FindMaxIndex(map);
			if (Class == DTree.GetClass(record))
				correct++;
		}
		error=1-correct/N;
		System.out.println("correctly mapped "+correct);
		System.out.println("Forest error rate % is: "+(error*100));		
	}
	/**
	 * Update the error map by recording a class prediction 
	 * for a given data record
	 * 
	 * @param record	the data record classified
	 * @param Class		the class
	 */
	public void UpdateOOBEstimate(int[] record,int Class){
		if (estimateOOB.get(record) == null){
			int[] map=new int[C];
			estimateOOB.put(record,map);
		}
		else {
			int[] map=estimateOOB.get(record);
			map[Class-1]++;
		}
	}
	/**
	 * This calculates the forest-wide importance levels for all attributes.
	 *
	 */
	private void CalcImportances() {
		importances=new int[M];
		for (DTree tree:trees){
			for (int i=0;i<M;i++)
				importances[i]+=tree.getImportanceLevel(i);
		}
		for (int i=0;i<M;i++)
			importances[i]/=numTrees;

	}
	/** Start the timer when beginning forest creation */
	private void StartTimer(){
		time_o=System.currentTimeMillis();
	}
	/**
	 * This class houses the machinery to generate one decision tree in a thread pool environment.
	 * @author kapelner
	 *
	 */
	private class CreateTree implements Runnable{
		/** the training data to generate the decision tree (same for all trees) */
		private ArrayList<int[]> data;
		/** the current forest */
		private RandomForest forest;
		/** the Tree number */
		private int treenum;
		/**
		 * A default, dummy constructor
		 */
		public CreateTree(ArrayList<int[]> data,RandomForest forest,int num){
			this.data=data;
			this.forest=forest;
			this.treenum=num;
		}
		/**
		 * Creates the decision tree
		 */
		public void run() {
			trees.add(new DTree(data,forest,treenum));
			progress+=update;
		}		
	}
	
	
	/**
	 * Evaluates an incoming data record.
	 * It first allows all the decision trees to classify the record,
	 * then it returns the majority vote
	 * 
	 * @param record		the data record to be classified
	 */
	public int Evaluate(int[] record){
		int[] counts=new int[C];
		for (int t=0;t<numTrees;t++){
			int Class=(trees.get(t)).Evaluate(record);
			counts[Class]++;
		}
		return FindMaxIndex(counts);
	}
	/**
	 * Given an array, return the index that houses the maximum value
	 * 
	 * @param arr	the array to be investigated
	 * @return		the index of the greatest value in the array
	 */
	public static int FindMaxIndex(int[] arr){
		int index=0;
		int max=Integer.MIN_VALUE;
		for (int i=0;i<arr.length;i++){
			if (arr[i] > max){
				max=arr[i];
				index=i;
			}				
		}
		return index;
	}


	/**
	 * Attempt to abort random forest creation
	 */
	public void Stop() {
		treePool.shutdownNow();
	}
	
	/**
	 * Given a certain time that's elapsed, return a string
	 * representation of that time in hr,min,s
	 * 
	 * @param timeinms	the beginning time in milliseconds
	 * @return			the hr,min,s formatted string representation of the time
	 */
	private static String TimeElapsed(long timeinms){
		int s=(int)(System.currentTimeMillis()-timeinms)/1000;
		int h=(int)Math.floor(s/((double)3600));
		s-=(h*3600);
		int m=(int)Math.floor(s/((double)60));
		s-=(m*60);
		return ""+h+"hr "+m+"m "+s+"s";
	}
}
