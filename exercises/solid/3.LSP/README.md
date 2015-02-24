This project contains an implementation of a small drawing application with two packages:
* nl.oose.dea.drawing.withoutlsp contains classes and test cases without the LSP principle applied
* nl.oose.dea.drawing.withlsp contains some classes and test cases that guide you to apply the LSP

First read the sourcecode without LSP and run the test cases (comment the testcases with LSP applied to compile and run these testcases).
Second, read the test cases with LSP and (re)create the correct classes and interfaces so the unit tests all pass.

* Break the is-a relationship between Rectangle and Square
* Introduce a superclass for both shapes, called .... Shape :)
* Move the area-calculation to the right spot
* When all the unit tests pass, add a new Shape called Triangle and adjust the third test case so it also calculates the area for a Triangle