# EC500Telstra-Network-Faults
--------
Website
---------
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
---------
Random Forests：

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
