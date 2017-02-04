Exercise REST and JAX-RS
=========================
Resources
-------------
The following resources are convenient during the exercise:

* DEA Slides: Java EE Domain Layer 
* Chapter 4 and 14 from Patterns of Enterprise Application Architecture (Fowler)
* IntelliJ (or Eclipse) and [TomEE](http://tomee.apache.org/download/tomee-7.0.1.html)
* Chrome with the [PostMan REST Client-plugin](https://www.getpostman.com/)
* Need more theory about REST, JSON JAX-RS? Visit these resources for more background information:
	* http://code.tutsplus.com/tutorials/a-beginners-guide-to-http-and-rest--net-16340
	* http://docs.oracle.com/javaee/6/tutorial/doc/giepu.html
	* http://www.restapitutorial.com/index.html
	* http://www.slideshare.net/rmaclean/json-and-rest
* Need more practical background and do you have a PluralSight account? 
	* http://www.pluralsight.com/courses/restful-services-java-using-jersey 
 
In this exercise you'll learn:
------------------------------
*  how to deal with different mediatypes like text/pain and application/json
*  how to build a REST resource using different HTTP verbs like GET, POST and DELETE 

Steps
-----
1. Download [TomEE](http://tomee.apache.org/download/tomee-7.0.1.html "TomEE"). Unzip this file in a directory of choice (there are known issues with paths containing spaces, you're safe when you unzip this file in the root of your C-disk (Windows), Applications Folder (Mac) or /opt folder (Linux). Make sure the directory you extract TomEE to is world-readable, if you don't you might need to run IntelliJ with Administrator privileges.
2. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven") and [TomEE](http://tomee.apache.org/download/tomee-7.0.1.html "TomEE"). 
3. Add a new REST Resource: create a class <code>ItemResource</code> and register "/items" as the default path (@Path). Add a method <code>String getTextItems()</code> that:

	* returns a hardcoded String "bread, butter".  
	* matches a GET request
	* produces plain text (@Produces)

5. Build the project using your IDE or Maven (mvn package). Before your can run your application in TomEE you need to attach TomEE to IntelliJ/Eclipse. Watch the [Screencast](https://vimeo.com/141192171 "Screencast") to learn how to use Tomcat or TomEE in IntellJ. There's also a [Screencast](https://www.youtube.com/watch?v=h-yKgQtpbco "available") to learn how to use Tomcat in Eclipse. 
6. Now run the application with TomEE. Visit [http://localhost:8080/items](http://localhost:8080/items) with the PostMan plugin. 
7. Add a new method to the <code>ItemResource</code> called <code>String getJsonItems()</code> that:

	* returns a hardcoded JSON String "[\"bread\", \"butter\"]"
	* matches a GET request
	* produces JSON

8. Build the project and run it with TomEE. 
Visit [http://localhost:8080/items](http://localhost:8080/items) with the PostMan plugin. You see plain text output, don't you? Change the HTTP-header Accept to application/json and try again.

9. TomEE has a built-in ability to map objects to JSON using Jackson. Change the signature of the <code>getJsonItems</code> method so it returns a List of items. Implement the method just to return the item-list, without manually converting them to JSON. 
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
