Exercise DIP and Guice
=========================
Resources
-------------
The following resources are convenient during the exercise:

* DEA Slides: Dependency Injection Guiced Up
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account by mailing @rodmidde:
	* http://www.pluralsight.com/courses/java-testing-introduction (Dependencies)
	* http://www.pluralsight.com/courses/inversion-of-control (Inversion of Control, Dependency Injection)
	
In this exercise you'll learn:
------------------------------
* how to use the @javax.inject.Inject annotation
* how to create bindings in a Guice module
* how to use simple factories to create instances of classes with specific parameters/values
* how to create instances of classes with dependencies on classes or interfaces

Steps
-----
1. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven").

2. Before applying DI with Guice check that Guice is added to our pom.xml:

	```xml
	<dependency>
	  <groupId>com.google.inject</groupId>
	  <artifactId>guice</artifactId>
	  <version>4.0</version>
	</dependency>
	``` 
	
3. Run the unit tests and check if they pass (they're supposed to).

4. Find out which classes need the ```@Inject``` annotation and add the annotations. TIP: Check which classes depend on interfaces like MailClient, NotificationService, etc.

5. Create a new class ```OrderModule``` that extends ```AbstractModule```. Add bindings for dependencies e.g. on interfaces. Classes like ```Cart``` are special, we provided a Guice Provider ```CartProvider``` for that, so bind ```Cart``` to the provider class ```CartProvider```

6. Create a Guice injector in the ```main``` method of ```OrderService``` and call ```getInstance(...)``` to get an instance of ```OnlineOrder```, ```POSCashOrder``` or ```POSCreditOrder```.

7. Run the main method to see if the DI-process works. Also run the unit tests to check if they pass (they're still supposed to).

Done
----
You can checkout the branch exercise-results for a working project and review possible differences.
