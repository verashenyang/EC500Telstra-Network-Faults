# EC500Telstra-Network-Faults
--------
Website
=================
1.Home Page
---------
![alt text](/src/images/mdsource/Information about Telstra.jpg "1")
In this part, we give some basic information about Australian biggest Telecom company-Telstra. Also, we connect our homepage with Telstra’s official website to make our page look more formal.

![alt text](/src/images/mdsource/Our services.jpg "1")
In this part, we have some introduction about the services we are providing on our webpage.

![alt text](/src/images/mdsource/Latest news.jpg "1")
In this part, we provide some latest happenings about Telstra to make the customers know some important news.

2.About Page
---------
![alt text](/src/images/mdsource/Allocation of the job.jpg "2")
In this part, it is about the allocation about our work, which tells that the whole project is divided into two parts: front-end and back-end. 

![alt text](/src/images/mdsource/Specific information about the work.jpg "2")
In this part, we give some concrete information about the division of our job: the concentration of the front-end and the back-end. The front-end focuses on the development of the webpage and the back-end focuses on the development of the algorithm.

![alt text](/src/images/mdsource/Images.jpg "2")
In this part, we have the five images of our team members. We do this to make make people learn more about our web and make the webpage appear more interesting.

3.Prediction
---------
![alt text](/src/images/mdsource/Algorithm.jpg "3")
In this part, we give the information about the algorithm that we apply: SVM and Random Forests. As a matter of fact, SVM can provide us with the accuracy about 68% and Random Forests can offer us the accuracy about 70% which is slightly better.

![alt text](/src/images/mdsource/Recent Process.jpg "3")
In this part, we show the recent process of our work and the recent accomplishment on the blackboard to make the job enclosed.


4.Product
---------

![alt text](/src/images/mdsource/Whole function.jpg "4")
In this part, we mainly have three parts of function: search by fault severity, search id, search by location. When we submit the number we input, all the results will come out. After that, we can clear the map and start searching again.

![alt text](/src/images/mdsource/Search by Fault Severity.jpg "4")
In this part, we can search by fault severity. Determine the fault severity and press the submit button, all id and the related fault severity will come out. We can press the Hide result button, the results will be hidden.   

![alt text](/src/images/mdsource/Search by id.jpg "4")
In this part, we can search by id from 1 to 18552, then the location and the fault severity will appear. Also, the red mark with the location and fault severity will appear on the map.  

![alt text](/src/images/mdsource/Search by location.jpg "4")
In this part, we can search by location from 1 to 1126, we will get the value of id and the fault severity. Also, the red mark with id and fault severity will appear on the map. 

![alt text](/src/images/mdsource/Result.jpg "4")
In this part, it is the marking result that is on the map. The left mark represents location and the right mark represents location as well as fault severity. 

![alt text](/src/images/mdsource/Error.jpg "4")
In this part, if we input the value that exceeds the range, we will not be able to get the right result. The system will tell that no record exists for our search.

5.Events Page
---------
![alt text](/src/images/mdsource/A few words about our webpage.jpg "5")
In this part, we basically introduce the function and basic information about the content of every webpage.

![alt text](/src/images/mdsource/Experience.jpg "5")
In this part, we talk about the experience we have gone through during the whole project, including the techs we apply., the difficulties we met with and the results we get.

Agorithms
=================
Random Forests：
---------
1.Why using Random Forests?
---------
Random Forests are easy to use, the only 2 parameters are the number of trees to be used and the number of variables (m) to be randomly selected from the available set of variables.


2.How to grow Random Forest
---------
If the number of cases in the training set is N, sample N cases at random with replacement, from the original data. This sample will be the training set for the growing tree.
If there are M input variables, m=sqrt(M) variables are selected at random out of the M and the best split is used to split the node. Each tree is grown to its large extent possible, no pruning.


3.How to predict using Random Forest?
---------
After Random Forest is built, each test data run through all decision trees, and the results are computed. We choose the class with maximum number to be the final prediction result.

4.How to use Random Forest?
---------
1. Download the Random Forest folder. 
2. Change the path of traindata and testdata in MainRun.java to your own path in computer. (few lines from the top)
3. Change the path of pathname of results in RandomForest.java to your own path in computer.(few lines from the top)
4. Run the MainRun.java file in Java or Java IDE(such as Eclipse). 
5. The result will be output as test_result.txt file in wherever you put it(by changing the pathname in step3).

SVM：
=================
Libsvm is a simple, easy-to-use, and efficient software for SVM
classification and regression. It solves C-SVM classification, nu-SVM
classification, one-class-SVM, epsilon-SVM regression, and nu-SVM
regression. It also provides an automatic model selection tool for
C-SVM classification. This document explains the use of libsvm.

Quick Start
---------

You can only to run this package under Windows system, using cmd. If you want to duplicate our result, go to the SVM package, run predict.exe file with training data to build the model. And then try the testing data and get the result.  

Data Format
---------
If you want to try your own data sets, you have to adjust the format of data.

The format of training and testing data file is:

    label index1 :value1 index2:value2 ...


Each line contains an instance and is ended by a '\n' character.  For classification, <label> is an integer indicating the class label (multi-class is supported). For regression, <label> is the target value which can be any real number. For one-class SVM, it's not used so can be any number.  The pair <index>:<value> gives a feature (attribute) value: <index> is an integer starting from 1 and <value> is a real number. The only exception is the precomputed kernel, where <index> starts from 0; see the section of precomputed kernels. Indices must be in ASCENDING order. Labels in the testing file are only used
to calculate accuracy or errors. If they are unknown, just fill the first column with any numbers.


For classification, if training data are in only one class (i.e., all labels are the same), then `svm-train' issues a warning message:
`Warning: training data in only one class. See README for details,'
which means the training data is very unbalanced. The label in the training data is directly returned when testing.

There are some other useful programs in this package.

    svm-scale:
This is a tool for scaling input data file.

    svm-toy:
    
This is a simple graphical interface which shows how SVM separate data in a plane. You can click in the window to draw data points. Use "change" button to choose class 1, 2 or 3 (i.e., up to three classes are supported), "load" button to load data from a file, "save" button to save data to a file, "run" button to obtain an SVM model, and "clear" button to clear the window.
    
You can enter options in the bottom of the window, the syntax of options is the same as `svm-train'.
    
Note that "load" and "save" consider dense data format both in classification and the regression cases. For classification,each data point has one label (the color) that must be 1, 2,or 3 and two attributes (x-axis and y-axis values) in[0,1). For regression, each data point has one target value (y-axis) and one attribute (x-axis values) in [0, 1).
    
Type `make' in respective directories to build them.
    
You need Qt library to build the Qt version.
(available from http://www.trolltech.com)
    
You need GTK+ library to build the GTK version.
(available from http://www.gtk.org)
    
The pre-built Windows binaries are in the `windows' directory. We use Visual C++ on a 32-bit machine, so the maximal cache size is 2GB.
=======
	This is a tool for scaling input data file.

svm-toy:

This is a simple graphical interface which shows how SVM separate data in a plane. You can click in the window to draw data points. Use "change" button to choose class 1, 2 or 3 (i.e., up to three classes are supported), "load" button to load data from a file, "save" button to save data to a file, "run" button to obtain an SVM model, and "clear" button to clear the window.

You can enter options in the bottom of the window, the syntax of options is the same as `svm-train'.

Note that "load" and "save" consider dense data format both in classification and the regression cases. For classification,
each data point has one label (the color) that must be 1, 2,or 3 and two attributes (x-axis and y-axis values) in [0,1). For regression, each data point has one target value (y-axis) and one attribute (x-axis values) in [0, 1).

Type `make' in respective directories to build them.

You need Qt library to build the Qt version.
(available from http://www.trolltech.com)

You need GTK+ library to build the GTK version.
(available from http://www.gtk.org)
	
The pre-built Windows binaries are in the `windows'directory. We use Visual C++ on a 32-bit machine, so the maximal cache size is 2GB.

'svm-train' Usage
------------

Usage: svm-train [options] training_set_file [model_file]</br>
options:
-s svm_type : set type of SVM (default 0)</br>

	0 -- C-SVC		(multi-class classification)</br>
	1 -- nu-SVC		(multi-class classification)</br>
	2 -- one-class SVM	</br>
	3 -- epsilon-SVR	(regression)</br>
	4 -- nu-SVR		(regression)</br>
-t kernel_type : set type of kernel function (default 2)</br>

	0 -- linear: u'*v</br>
	1 -- polynomial: (gamma*u'*v + coef0)^degree</br>
	2 -- radial basis function: exp(-gamma*|u-v|^2)</br>
	3 -- sigmoid: tanh(gamma*u'*v + coef0)</br>
	4 -- precomputed kernel (kernel values in training_set_file)</br>

-d degree : set degree in kernel function (default 3)</br>
-g gamma : set gamma in kernel function (default 1/num_features)</br>
-r coef0 : set coef0 in kernel function (default 0)</br>
-c cost : set the parameter C of C-SVC, epsilon-SVR, and nu-SVR (default 1)</br>
-n nu : set the parameter nu of nu-SVC, one-class SVM, and nu-SVR (default 0.5)</br>
-p epsilon : set the epsilon in loss function of epsilon-SVR (default 0.1)</br>
-m cachesize : set cache memory size in MB (default 100)</br>
-e epsilon : set tolerance of termination criterion (default 0.001)</br>
-h shrinking : whether to use the shrinking heuristics, 0 or 1 (default 1)</br>
-b probability_estimates : whether to train a SVC or SVR model for probability estimates, 0 or 1 (default 0)</br>
-wi weight : set the parameter C of class i to weight*C, for C-SVC (default 1)</br>
-v n: n-fold cross validation mode</br>
-q : quiet mode (no outputs)</br>


The k in the -g option means the number of attributes in the input data.</br>

option -v randomly splits the data into n parts and calculates cross</br>
validation accuracy/mean squared error on them.</br>

See libsvm FAQ for the meaning of outputs.</br>

'svm-predict' Usage
------------

Usage: svm-predict [options] test_file model_file output_file</br>
options:</br>
-b probability_estimates: whether to predict probability estimates, 0 or 1 (default 0); for one-class SVM only 0 is supported

model_file is the model file generated by svm-train.</br>
test_file is the test data you want to predict.</br>
svm-predict will produce output in the output_file.

'svm-scale' Usage
------------

Usage: svm-scale [options] data_filename</br>
options:</br>
-l lower : x scaling lower limit (default -1)</br>
-u upper : x scaling upper limit (default +1)</br>
-y y_lower y_upper : y scaling limits (default: no y scaling)</br>
-s save_filename : save scaling parameters to save_filename</br>
-r restore_filename : restore scaling parameters from restore_filename




