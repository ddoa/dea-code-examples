Exercise REST and JAX-RS
=========================
Resources
-------------
The following resources are convenient during the exercise:

* DEA Slides: Java EE Domain Layer 
* Chapter 4 and 14 from Patterns of Enterprise Application Architecture (Fowler)
* IntelliJ (or Eclipse) and Tomcat8
* Chrome with the [PostMan REST Client-plugin](https://www.getpostman.com/)
* Need more theory about REST, JSON or Jersey? Visit these resources for more background information:
	* http://code.tutsplus.com/tutorials/a-beginners-guide-to-http-and-rest--net-16340
	* http://docs.oracle.com/javaee/6/tutorial/doc/giepu.html
	* https://jersey.java.net/
	* http://www.restapitutorial.com/index.html
	* http://www.slideshare.net/rmaclean/json-and-rest
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account by mailing @rodmidde:
	* http://www.pluralsight.com/courses/restful-services-java-using-jersey 
 
In this exercise you'll learn:
------------------------------
*  how to deal with different mediatypes like text/pain and application/json
*  how to use Jersey and Jackson for mapping POJOs to and from JSON
*  how to build a REST resource using different HTTP verbs like GET, POST and DELETE 

Steps
-----
1. Download [Tomcat8](http://apache.proserve.nl/tomcat/tomcat-8/v8.0.38/bin/apache-tomcat-8.0.38.zip "Tomcat8"). Unzip this file in a directory of choice (there are known issues with paths containing spaces, you're safe when you unzip this file in the root of your C-disk (Windows), Applications Folder (Mac) or /opt folder (Linux). Make sure the directory you extract Tomcat to is world-readable, if you don't you might need to run IntelliJ with Administrator privileges.
2. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven") and [Tomcat8](http://tomcat.apache.org/ "Tomcat8"). 
3.  Add a new Jersey configuration (a new Java class) called <code>RestConfig</code>. Make your it extends <code>ResourceConfig</code> and let it look for REST resources in the package <code>oose.dea.services.rest</code>. Let this configuration match the application path "/rest". Look at the DEA slides for more information about packaging and application paths. 
4. Add a new REST Resource: create a class <code>ItemResource</code> and register "/items" as the default path (@Path). Add a method <code>String getTextItems()</code> that:

	* returns a hardcoded String "bread, butter".  
	* matches a GET request
	* produces plain text (@Produces)

5. Build the project using your IDE or Maven (mvn package). Before your can run your application in Tomcat you need to attach Tomcat to IntelliJ/Eclipse. Watch the [Screencast](https://vimeo.com/141192171 "Screencast") to learn how to use Tomcat in IntellJ. There's also a [Screencast](https://www.youtube.com/watch?v=h-yKgQtpbco "available") to learn how to use Tomcat in Eclipse. 
6. Now run the application with Tomcat. Visit [http://localhost:8080/rest/items](http://localhost:8080/rest/items) with the PostMan plugin. 
7. Add a new method to the <code>ItemResource</code> called <code>String getJsonItems()</code> that:

	* returns a hardcoded JSON String "[\"bread\", \"butter\"]"
	* matches a GET request
	* produces JSON

8. Build the project and run it with Tomcat. 
Visit [http://localhost:8080/rest/items](http://localhost:8080/rest/items) with the PostMan plugin. You see plain text output, don't you? Change the HTTP-header Accept to application/json and try again.

9. Add an attribute *items* of type <code>List\<Item></code> to <code>ItemResource</code> and fill this list with two or more instances of type <code>Item</code>. Adjust the method <code>getTextItems</code> to loop through the item-list and return a text-based representation. Rebuild the project and test the application again. Does it still work?

10. Now change the method <code>getJsonItems</code> to return a JSON-representation of the item-list. Use Jackson's ObjectMapper to do the trick: 

	<pre>
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(items);
	</pre>

	Rebuild the project and test the application again.

11. Hey, we're using Jersey! It has a built in ability to map objects to JSON using Jackson. Change the signature of the <code>getJsonItems</code> method so it returns a List of items. Implement the method just to return the item-list, without manually converting them to JSON. Wait, before rebuilding your project you have to modify the <code>RestConfig</code>:

	<pre>
	property("jersey.config.server.provider.packages", "com.fasterxml.jackson.jaxrs.json;service");
	</pre>
	
	Now rebuild your application and test the application again.
	
12. Add a method <code>Item getJsonItem(String sku)</code> to find a certain item using its sku. Of course it has to return JSON. TIP: You might need annotations liks <code>@Path</code> and <code>@PathParam</code>. 

13. To close this exercise, add void methods to:
	* add a new Item (TIP: Use <code>@Consumes</code> instead of <code>@Produces</code>)
	* delete an existing Item 

    Notice that however the methods are void methods, there is in fact a HTTP Response: 204 (NO CONTENT).

14. When you don't see any effect of adding or deleting items consider making the <code>ItemResource</code> <code>@javax.inject.Singleton</code>, which ensures only one instance of the REST resource instead of creating a new instance every request.
    
Done 
----
You can checkout the branch exercise-results for a working project and review possible differences. 
