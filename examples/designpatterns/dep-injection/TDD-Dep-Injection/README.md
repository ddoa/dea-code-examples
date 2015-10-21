Sample app for showing the _Dependency Injection_ principle. The source code is the result of an attempt to use TDD to show the problem of the singleton pattern and high coupling in general. Just one dependency for unittesting, also use this project to show what `mvn checkstyle:checkstyle`, `mvn cobertura:cobertura` and `mvn javadoc:javadoc` can do.

You can reproduce this source code using the following steps:

1) Write a test for the DatabaseManager _class_

2) Implement the DatabaseManager _class_

3) Build the Project class

4) Write a test for the PersonRepository class

5) Build the PersonRepository class

6) Create a dependency between the PersonRepository and DatabaseManager in the save method

7) Rename the DatabaseManager _class_ to AlmostWorkingDatabaseManager

8) Extract the DatabaseManager _interface_ out of the AlmostWorkingDatabaseManager

9) Fix the testcases due to refactoring

10) Build the PersonApp class to show that it actually works, optionally introduce the DatabaseManagerFactory to decouple some more, but take a good look at the comments in the header of this class!
