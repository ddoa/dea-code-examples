Exercise CDI in Java EE
=========================
Resources
-------------
The following resources are convenient during the exercise:

* DEA Slides: DIP Revisited
* DEA Slides: Java EE - Presentation Layer
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account by mailing @rodmidde:
	* http://www.pluralsight.com/courses/java-testing-introduction (Dependencies)
	* http://www.pluralsight.com/courses/inversion-of-control (Inversion of Control, Dependency Injection)
	* http://www.pluralsight.com/courses/context-dependency-injection-1-1 (Understanding Context and Dependency Injection)

In this exercise you'll learn:
------------------------------
* how to add DI to a Servlet using CDI
* how to add DI to a REST Resource 

Steps
-----
1. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven") and [TomEE Plus 7.0.1](http://tomee.apache.org/download/tomee-7.0.1.html).

2. Build the project and run it using TomEE. Visit [REST Service](http://localhost:8080/items) to test the REST Service. Visit [Servlet](http://localhost:8080/viewItems) to test the Servlet.

3. You'll find both the Servlet and REST resource working like a charm but it's too bad they both are tightly coupled to their dependencies like the ItemService and ItemDAO. Create a new folder structure in src/main: resources/META-INF and add a file called beans.xml with the following contents

    ```xml
    <beans xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/beans_1_0.xsd">
    </beans>
    ```

4. First we start with CDI'ing the Servlet, we deal with the REST resource later. 

5. Change all tight coupled dependencies for the ViewItems Servlet, ItemService and ItemDAO to interfaces annotated with ```@Inject```. Rebuild the app, run TomEE and visit [Servlet](http://localhost:8080/viewItems) to test the Servlet.

6. To use CDI in combination with Jersey is just as easy. Change all tight coupled dependencies for the REST Resource to interfaces annotated with ```@Inject```. Rebuild the app, run Tomcat and visit [Servlet](http://localhost:8080/rest/items) to test the REST Resource.

Done
----
You can checkout the branch exercise-results for a working project and review possible differences.
