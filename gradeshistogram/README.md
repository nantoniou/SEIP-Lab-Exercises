# Grades Histogram (1st exercise) 

A Java application that reads a file with students’ grades and generates its histogram, using [JFreeChart](https://mvnrepository.com/artifact/org.jfree/jfreechart)

## Setup

Clone the repository and navigate to the project's main folder (SEIP-Lab-Exercises). Open the command line and enter `mvn package`; this should create the executable jar file.

Note: this application was tested with Java version 1.8 and maven version 3.6.0. Should you come across any errors with different versions, please contact the development team.

## Execution
Once built, go to the target folder and run the jar-with-dependencies jar, from the command line, including an argument that dictates the location of the file that contains the grades.
For example `java -jar gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar grades.txt`
