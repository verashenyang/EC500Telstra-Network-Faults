{\rtf1\ansi\ansicpg936\cocoartf1404\cocoasubrtf460
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;}
\paperw11900\paperh16840\margl1440\margr1440\vieww18280\viewh13440\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs32 \cf0 -----------------------------------------
\fs36 \

\fs32 --- MATLAB/OCTAVE interface of LIBSVM ---
\fs36 \

\fs32 -----------------------------------------
\fs36 \

\fs32  
\fs36 \

\fs32 Table of Contents
\fs36 \

\fs32 =================
\fs36 \

\fs32  
\fs36 \

\fs32 - Introduction
\fs36 \

\fs32 - Installation
\fs36 \

\fs32 - Usage
\fs36 \

\fs32 - Returned Model Structure
\fs36 \

\fs32 - Other Utilities
\fs36 \

\fs32 - Examples
\fs36 \

\fs32  
\fs36 \

\fs32 Introduction
\fs36 \

\fs32 ============
\fs36 \

\fs32  
\fs36 \

\fs32 This tool provides a simple interface to LIBSVM, a library for support vector
\fs36 \

\fs32 machines. It is very easy to use as
\fs36 \

\fs32 the usage and the way of specifying parameters are the same as that of LIBSVM.
\fs36 \

\fs32  
\fs36 \

\fs32 Installation
\fs36 \

\fs32 ============
\fs36 \

\fs32  
\fs36 \

\fs32 On Windows systems, pre-built binary files are already in the 
\fs36 \

\fs32 directory '..\\windows', so no need to conduct installation. Now we 
\fs36 \

\fs32 provide binary files only for 64bit MATLAB on Windows. If you would 
\fs36 \

\fs32 like to re-build the package, please rely on the following steps.
\fs36 \

\fs32  
\fs36 \

\fs32 We recommend using make.m on both MATLAB and OCTAVE. Just type 'make'
\fs36 \

\fs32 to build 'libsvmread.mex', 'libsvmwrite.mex', 'svmtrain.mex', and
\fs36 \

\fs32 'svmpredict.mex'.
\fs36 \

\fs32  
\fs36 \

\fs32 On MATLAB or Octave:
\fs36 \

\fs32  
\fs36 \

\fs32         >> make
\fs36 \

\fs32  
\fs36 \

\fs32 If make.m does not work on MATLAB (especially for Windows), try 'mex
\fs36 \

\fs32 -setup' to choose a suitable compiler for mex. Make sure your compiler
\fs36 \

\fs32 is accessible and workable. Then type 'make' to start the
\fs36 \

\fs32 installation.
\fs36 \

\fs32  
\fs36 \

\fs32 Example:
\fs36 \

\fs32  
\fs36 \

\fs32     matlab>> mex -setup
\fs36 \

\fs32     (ps: MATLAB will show the following messages to setup default compiler.)
\fs36 \

\fs32     Please choose your compiler for building external interface (MEX) files:
\fs36 \

\fs32     Would you like mex to locate installed compilers [y]/n? y
\fs36 \

\fs32     Select a compiler:
\fs36 \

\fs32     [1] Microsoft Visual C/C++ version 7.1 in C:\\Program Files\\Microsoft Visual Studio
\fs36 \

\fs32     [0] None
\fs36 \

\fs32     Compiler: 1
\fs36 \

\fs32     Please verify your choices:
\fs36 \

\fs32     Compiler: Microsoft Visual C/C++ 7.1
\fs36 \

\fs32     Location: C:\\Program Files\\Microsoft Visual Studio
\fs36 \

\fs32     Are these correct?([y]/n): y
\fs36 \

\fs32  
\fs36 \

\fs32     matlab>> make
\fs36 \

\fs32  
\fs36 \

\fs32 On Unix systems, if neither make.m nor 'mex -setup' works, please use
\fs36 \

\fs32 Makefile and type 'make' in a command window. Note that we assume 
\fs36 \

\fs32 your MATLAB is installed in '/usr/local/matlab'. If not, please change 
\fs36 \

\fs32 MATLABDIR in Makefile.
\fs36 \

\fs32  
\fs36 \

\fs32 Example:
\fs36 \

\fs32         linux> make
\fs36 \

\fs32  
\fs36 \

\fs32 To use octave, type 'make octave':
\fs36 \

\fs32  
\fs36 \

\fs32 Example:
\fs36 \

\fs32     linux> make octave
\fs36 \

\fs32  
\fs36 \

\fs32 For a list of supported/compatible compilers for MATLAB, please check
\fs36 \

\fs32 the following page:
\fs36 \

\fs32  
\fs36 \

\fs32 http://www.mathworks.com/support/compilers/current_release/
\fs36 \

\fs32  
\fs36 \

\fs32 Usage
\fs36 \

\fs32 =====
\fs36 \

\fs32  
\fs36 \

\fs32 matlab> model = svmtrain(training_label_vector, training_instance_matrix [, 'libsvm_options']);
\fs36 \

\fs32  
\fs36 \

\fs32         -training_label_vector:
\fs36 \

\fs32             An m by 1 vector of training labels (type must be double).
\fs36 \

\fs32         -training_instance_matrix:
\fs36 \

\fs32             An m by n matrix of m training instances with n features.
\fs36 \

\fs32             It can be dense or sparse (type must be double).
\fs36 \

\fs32         -libsvm_options:
\fs36 \

\fs32             A string of training options in the same format as that of LIBSVM.
\fs36 \

\fs32  
\fs36 \

\fs32 matlab> [predicted_label, accuracy, decision_values/prob_estimates] = svmpredict(testing_label_vector, testing_instance_matrix, model [, 'libsvm_options']);
\fs36 \

\fs32 matlab> [predicted_label] = svmpredict(testing_label_vector, testing_instance_matrix, model [, 'libsvm_options']);
\fs36 \

\fs32  
\fs36 \

\fs32         -testing_label_vector:
\fs36 \

\fs32             An m by 1 vector of prediction labels. If labels of test
\fs36 \

\fs32             data are unknown, simply use any random values. (type must be double)
\fs36 \

\fs32         -testing_instance_matrix:
\fs36 \

\fs32             An m by n matrix of m testing instances with n features.
\fs36 \

\fs32             It can be dense or sparse. (type must be double)
\fs36 \

\fs32         -model:
\fs36 \

\fs32             The output of svmtrain.
\fs36 \

\fs32         -libsvm_options:
\fs36 \

\fs32             A string of testing options in the same format as that of LIBSVM.
\fs36 \

\fs32  
\fs36 \

\fs32 Returned Model Structure
\fs36 \

\fs32 ========================
\fs36 \

\fs32  
\fs36 \

\fs32 The 'svmtrain' function returns a model which can be used for future
\fs36 \

\fs32 prediction.  It is a structure and is organized as [Parameters, nr_class,
\fs36 \

\fs32 totalSV, rho, Label, ProbA, ProbB, nSV, sv_coef, SVs]:
\fs36 \

\fs32  
\fs36 \

\fs32         -Parameters: parameters
\fs36 \

\fs32         -nr_class: number of classes; = 2 for regression/one-class svm
\fs36 \

\fs32         -totalSV: total #SV
\fs36 \

\fs32         -rho: -b of the decision function(s) wx+b
\fs36 \

\fs32         -Label: label of each class; empty for regression/one-class SVM
\fs36 \

\fs32         -sv_indices: values in [1,...,num_traning_data] to indicate SVs in the training set
\fs36 \

\fs32         -ProbA: pairwise probability information; empty if -b 0 or in one-class SVM
\fs36 \

\fs32         -ProbB: pairwise probability information; empty if -b 0 or in one-class SVM
\fs36 \

\fs32         -nSV: number of SVs for each class; empty for regression/one-class SVM
\fs36 \

\fs32         -sv_coef: coefficients for SVs in decision functions
\fs36 \

\fs32         -SVs: support vectors
\fs36 \

\fs32  
\fs36 \

\fs32 If you do not use the option '-b 1', ProbA and ProbB are empty
\fs36 \

\fs32 matrices. If the '-v' option is specified, cross validation is
\fs36 \

\fs32 conducted and the returned model is just a scalar: cross-validation
\fs36 \

\fs32 accuracy for classification and mean-squared error for regression.
\fs36 \

\fs32  
\fs36 \

\fs32 More details about this model can be found in LIBSVM FAQ
\fs36 \

\fs32 (http://www.csie.ntu.edu.tw/~cjlin/libsvm/faq.html) and LIBSVM
\fs36 \

\fs32 implementation document
\fs36 \

\fs32 (http://www.csie.ntu.edu.tw/~cjlin/papers/libsvm.pdf).
\fs36 \

\fs32  
\fs36 \

\fs32 Result of Prediction
\fs36 \

\fs32 ====================
\fs36 \

\fs32  
\fs36 \

\fs32 The function 'svmpredict' has three outputs. The first one,
\fs36 \

\fs32 predictd_label, is a vector of predicted labels. The second output,
\fs36 \

\fs32 accuracy, is a vector including accuracy (for classification), mean
\fs36 \

\fs32 squared error, and squared correlation coefficient (for regression).
\fs36 \

\fs32 The third is a matrix containing decision values or probability
\fs36 \

\fs32 estimates (if '-b 1' is specified). If k is the number of classes
\fs36 \

\fs32 in training data, for decision values, each row includes results of 
\fs36 \

\fs32 predicting k(k-1)/2 binary-class SVMs. For classification, k = 1 is a
\fs36 \

\fs32 special case. Decision value +1 is returned for each testing instance,
\fs36 \

\fs32 instead of an empty vector. For probabilities, each row contains k values
\fs36 \

\fs32 indicating the probability that the testing instance is in each class.
\fs36 \

\fs32 Note that the order of classes here is the same as 'Label' field
\fs36 \

\fs32 in the model structure.
\fs36 \

\fs32  
\fs36 \

\fs32 Other Utilities
\fs36 \

\fs32 ===============
\fs36 \

\fs32  
\fs36 \

\fs32 A matlab function libsvmread reads files in LIBSVM format: 
\fs36 \

\fs32  
\fs36 \

\fs32 [label_vector, instance_matrix] = libsvmread('data.txt'); 
\fs36 \

\fs32  
\fs36 \

\fs32 Two outputs are labels and instances, which can then be used as inputs
\fs36 \

\fs32 of svmtrain or svmpredict. 
\fs36 \

\fs32  
\fs36 \

\fs32 A matlab function libsvmwrite writes Matlab matrix to a file in LIBSVM format:
\fs36 \

\fs32  
\fs36 \

\fs32 libsvmwrite('data.txt', label_vector, instance_matrix)
\fs36 \

\fs32  
\fs36 \

\fs32 The instance_matrix must be a sparse matrix. (type must be double)
\fs36 \

\fs32 For 32bit and 64bit MATLAB on Windows, pre-built binary files are ready 
\fs36 \

\fs32 in the directory `..\\windows', but in future releases, we will only 
\fs36 \

\fs32 include 64bit MATLAB binary files.
\fs36 \

\fs32  
\fs36 \

\fs32 These codes are prepared by Rong-En Fan and Kai-Wei Chang from National
\fs36 \

\fs32 Taiwan University.
\fs36 \

\fs32  
\fs36 \

\fs32 Examples
\fs36 \

\fs32 ========
\fs36 \

\fs32  
\fs36 \

\fs32 Train and test on the provided data heart_scale:
\fs36 \

\fs32  
\fs36 \

\fs32 matlab> [heart_scale_label, heart_scale_inst] = libsvmread('../heart_scale');
\fs36 \

\fs32 matlab> model = svmtrain(heart_scale_label, heart_scale_inst, '-c 1 -g 0.07');
\fs36 \

\fs32 matlab> [predict_label, accuracy, dec_values] = svmpredict(heart_scale_label, heart_scale_inst, model); % test the training data
\fs36 \

\fs32  
\fs36 \

\fs32 For probability estimates, you need '-b 1' for training and testing:
\fs36 \

\fs32  
\fs36 \

\fs32 matlab> [heart_scale_label, heart_scale_inst] = libsvmread('../heart_scale');
\fs36 \

\fs32 matlab> model = svmtrain(heart_scale_label, heart_scale_inst, '-c 1 -g 0.07 -b 1');
\fs36 \

\fs32 matlab> [heart_scale_label, heart_scale_inst] = libsvmread('../heart_scale');
\fs36 \

\fs32 matlab> [predict_label, accuracy, prob_estimates] = svmpredict(heart_scale_label, heart_scale_inst, model, '-b 1');
\fs36 \

\fs32  
\fs36 \

\fs32 To use precomputed kernel, you must include sample serial number as
\fs36 \

\fs32 the first column of the training and testing data (assume your kernel
\fs36 \

\fs32 matrix is K, # of instances is n):
\fs36 \

\fs32  
\fs36 \

\fs32 matlab> K1 = [(1:n)', K]; % include sample serial number as first column
\fs36 \

\fs32 matlab> model = svmtrain(label_vector, K1, '-t 4');
\fs36 \

\fs32 matlab> [predict_label, accuracy, dec_values] = svmpredict(label_vector, K1, model); % test the training data
\fs36 \

\fs32  
\fs36 \

\fs32 We give the following detailed example by splitting heart_scale into
\fs36 \

\fs32 150 training and 120 testing data.  Constructing a linear kernel
\fs36 \

\fs32 matrix and then using the precomputed kernel gives exactly the same
\fs36 \

\fs32 testing error as using the LIBSVM built-in linear kernel.
\fs36 \

\fs32  
\fs36 \

\fs32 matlab> [heart_scale_label, heart_scale_inst] = libsvmread('../heart_scale');
\fs36 \

\fs32 matlab>
\fs36 \

\fs32 matlab> % Split Data
\fs36 \

\fs32 matlab> train_data = heart_scale_inst(1:150,:);
\fs36 \

\fs32 matlab> train_label = heart_scale_label(1:150,:);
\fs36 \

\fs32 matlab> test_data = heart_scale_inst(151:270,:);
\fs36 \

\fs32 matlab> test_label = heart_scale_label(151:270,:);
\fs36 \

\fs32 matlab>
\fs36 \

\fs32 matlab> % Linear Kernel
\fs36 \

\fs32 matlab> model_linear = svmtrain(train_label, train_data, '-t 0');
\fs36 \

\fs32 matlab> [predict_label_L, accuracy_L, dec_values_L] = svmpredict(test_label, test_data, model_linear);
\fs36 \

\fs32 matlab>
\fs36 \

\fs32 matlab> % Precomputed Kernel
\fs36 \

\fs32 matlab> model_precomputed = svmtrain(train_label, [(1:150)', train_data*train_data'], '-t 4');
\fs36 \

\fs32 matlab> [predict_label_P, accuracy_P, dec_values_P] = svmpredict(test_label, [(1:120)', test_data*train_data'], model_precomputed);
\fs36 \

\fs32 matlab>
\fs36 \

\fs32 matlab> accuracy_L % Display the accuracy using linear kernel
\fs36 \

\fs32 matlab> accuracy_P % Display the accuracy using precomputed kernel
\fs36 \

\fs32  
\fs36 \

\fs32 Note that for testing, you can put anything in the
\fs36 \

\fs32 testing_label_vector.  For more details of precomputed kernels, please
\fs36 \

\fs32 read the section ``Precomputed Kernels'' in the README of the LIBSVM
\fs36 \

\fs32 package.
\fs36 \

\fs32  
\fs36 \
}