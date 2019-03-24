# Source Code Metrics Calculator (2nd exercise) 

A Java application that analyzes a Java source code file and calculates code level metrics; namely the lines of code, the number of classes and the number of methods, which then writes to a csv file named `metrics.csv`

## Setup

Clone the repository and navigate to the project's main folder (SEIP-Lab-Exercises). Open the command line and enter `mvn package`; this should create the executable jar file, in the folder `MetricsCalculator` and then `target`.

Note: this application was tested with Java version 1.8 and maven version 3.6.0. Should you come across any errors with different versions, please contact the development team.

## Execution
Once built, go to the target folder and run the jar, from the command line, including an argument that dictates the location of the file that contains the source code and an argument for the type of string analysis you want to be used (either `string` for string comparison, or `regex` for comparison using regular expressions)
For example `java -jar MetricsCalculator-0.0.1-SNAPSHOT.jar sourceCode.java regex`
