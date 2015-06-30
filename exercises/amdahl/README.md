Steps
-----
* Run mvn clean test to see that all tests pass.
* Run with coverage in your favourite IDE (native support for that in IntelliJ) and see that the coverage is 100%
* Run mvn clean test org.pitest:pitest-maven:mutationCoverage and open up the html-file in target/pit-reports/{date}. 
You'll notice that we used a simple Maven plugin called pi-test that tries to modify our sourcecode to see if test cases still pass 
(when they do, the tests do not match the sourcecode!). This is called [mutation testing](https://www.youtube.com/watch?v=aLAcvMI2VBI).