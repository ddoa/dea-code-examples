Exercise Guice in Java EE
=========================
Resources
-------------
The following resources are convenient during the exercise:

* DEA Slides: Dependency Injection Guiced Up
* DEA Slides: Java EE - Presentation Layer
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account at [ICA Xtend](https://ica-xtend.nl/winkel/):
	* http://www.pluralsight.com/courses/java-testing-introduction (Dependencies)
	* http://www.pluralsight.com/courses/inversion-of-control (Inversion of Control, Dependency Injection)
	* http://www.pluralsight.com/courses/context-dependency-injection-1-1 (Understanding Context and Dependency Injection)

In this exercise you'll learn:
------------------------------
* how to add Guice dependencies to a Maven build file
* how to add DI to a Servlet using Guice and GuiceServlet
* how to add DI to a REST Resource using Guice and HK2GuiceBridge

Steps
-----
1. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven") and [Tomcat](http://tomcat.apache.org).

2. Build the project and run it using Tomcat. Visit [REST Service](http://localhost:8080/rest/items) to test the REST Service. Visit [Servlet](http://localhost:8080/viewItems) to test the Servlet.

3. You'll find both the Servlet and REST resource working like a charm but it's too bad they both are tightly coupled to their dependencies like the ItemService and ItemDAO. Add the following dependencies to your pom.xml to enable Guice, Guice Servlet and HK2GuiceBridge:

    ```xml
    <dependency>
        <groupId>org.glassfish.hk2</groupId>
        <artifactId>guice-bridge</artifactId>
        <version>2.4.0-b25</version>
    </dependency>
    <dependency>
        <groupId>com.google.inject.extensions</groupId>
        <artifactId>guice-servlet</artifactId>
        <version>${guice.version}</version>
    </dependency>
    <dependency>
        <groupId>com.google.inject</groupId>
        <artifactId>guice</artifactId>
        <version>${guice.version}</version>
    </dependency>
    ```

    Notice that a property ```<guice.version>4.0</guice.version>``` already exists.
    We recommend using these properties to keep track of versions of related dependencies.

4. First we start with Guicing up the Servlet, we deal with the REST resource later. To enable Guice for Servlets we need a WebListener and a WebFilter.
	* Create a class ```AppBinding``` that extends ```ServletModule```. Override the method ```configureServlets()``` by calling ```super.configureServlets()``` followed by:
		```java
		  serve("/viewItems").with(ItemsView.class);
      bind(ItemService.class).to(LocalItemService.class);
      bind(ItemDAO.class).to(FakeItemDAO.class);
		```
	* Create a class ```GuiceWebFilter``` that extends ```GuiceFilter``` and annotate it with ```@WebFilter("/*")```. Override the ```doFilter(...)``` method by simply calling ```super.doFilter(...)```.
	* Create a class ```GuiceServletConfig``` that extends ```GuiceServletContextListener``` and annotate it with ```@WebListener```. Override the method ```getInjector()``` by returning ```Guice.createInjector(new AppBinding())```.

5. You just added a binding to be used for dependency injection by Guice. You also added a WebFilter and WebListener to enable this specific binding.

6. Change all tight coupled dependencies for the ViewItems Servlet, ItemService and ItemDAO to interfaces annotated with ```@Inject```. Rebuild the app, run Tomcat and visit [Servlet](http://localhost:8080/viewItems) to test the Servlet.

6. To use Guice in combination with Jersey is a bit harder. Jersey comes with a proprietary DI-container called HK2, we have to bypass HK2 in favour of Guice, therefore we need a bridge. Replace the constructor of the class ```RestResourceConfig``` by
	```java
  @Inject
  public RestResourceConfig(ServiceLocator serviceLocator) {
        packages(true, "oose.dea.services.rest");
        property(JSON_SERIALIZER, JACKSON_JSON_SERIALIZER);
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(Guice.createInjector(new AppBinding()));
  }
	```

7. Change all tight coupled dependencies for the REST Resource to interfaces annotated with ```@Inject```. Rebuild the app, run Tomcat and visit [Servlet](http://localhost:8080/rest/items) to test the REST Resource.

Done
----
You can checkout the branch exercise-results for a working project and review possible differences.
