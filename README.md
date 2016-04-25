# EC500Telstra-Network-Faults
--------
Website
---------
1.Home Page
---------
![alt text](/src/images/mdsource/Information about Telstra.jpg "Yu Zhao")
In this part, we give some basic information about Australian biggest Telecom company-Telstra. Also, we connect our homepage with Telstra’s official website.

![alt text](/src/images/mdsource/Our services.jpg "Yu Zhao")
In this part, we have some introduction about our services.

![alt text](/src/images/mdsource/Latest news.jpg "Yu Zhao")
In this part, we provide some latest happenings about Telstra to make the customers know some important news.

2.About Page
---------
![alt text](/src/images/mdsource/Allocation of the job.jpg "Yu Zhao")
In this part, it is about the allocation about our work.

![alt text](/src/images/mdsource/Specific information about the work.jpg "Yu Zhao")
In this part, we give some concrete information about the division of our job: the concentration of the front-end and the back-end.

![alt text](/src/images/mdsource/Images.jpg "Yu Zhao")
In this part, we have the five images of our team members in order to make people know more about our web and make the webpage more interesting.

3.Prediction
---------
![alt text](/src/images/mdsource/Algorithm.jpg "Yu Zhao")
In this part, we give some information about the algorithm that we apply: SVM and Random Forests. As a matter of fact, SVM can provide us with the accuracy about 68% and Random Forests can offer us the accuracy about 70% which is slightly better.

![alt text](/src/images/mdsource/Recent Process.jpg "Yu Zhao")
In this part, we show the recent process of our work and the recent accomplishment.

4.Product
---------
Product:

![alt text](/src/images/mdsource/Whole function.jpg "Yu Zhao")
In this part, we mainly have three parts of function: search by fault severity, search id, search by location. And the red mark with the fault severity will appear on the map. After that, we can clear the map and start again.

![alt text](/src/images/mdsource/Search by Fault Severity.jpg "Yu Zhao")
In this part, we can search by fault severity. Press the Submit button, the results will come out. And we can press the Hide result button, the results will be hiden.   

![alt text](/src/images/mdsource/Search by id.jpg "Yu Zhao")
In this part, we can search by id, then the location and the fault severity will appear. 

![alt text](/src/images/mdsource/Search by location.jpg "Yu Zhao")
In this part, we can search by location and we can get the id and the fault severity. 

![alt text](/src/images/mdsource/Result.jpg "Yu Zhao")
In this part, it is the marking result that is on the map.

![alt text](/src/images/mdsource/Error.jpg "Yu Zhao")
In this part, if we input the number that exceeds that range, we will not be able to get the right result.

5.Events Page
---------
![alt text](/src/images/mdsource/A few words about our webpage.jpg "Yu Zhao")
In this part, we give some basic information about content of every webpage.

![alt text](/src/images/mdsource/Experience.jpg "Yu Zhao")
In this part, we talk about the experience we have gone through during the whole project.

Agorithms
---------
Random Forests：

1.Why using Random Forests?

Random Forests are easy to use, the only 2 parameters are the number of trees to be used and the number of variables (m) to be randomly selected from the available set of variables.

2.How to grow Random Forest

If the number of cases in the training set is N, sample N cases at random with replacement, from the original data. This sample will be the training set for the growing tree.
If there are M input variables, m=sqrt(M) variables are selected at random out of the M and the best split is used to split the node. Each tree is grown to its large extent possible, no pruning.

3.How to predict using Random Forest?

After Random Forest is built, each test data run through all decision trees, and the results are computed. We choose the class with maximum number to be the final prediction result.