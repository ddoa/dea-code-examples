Exercise REST and JAX-RS
=========================
Resources
-------------
The following resources are convenient during the exercise:

* DEA Slides: Java EE Domain Layer 
* Chapter 4 and 14 from Patterns of Enterprise Application Architecture (Fowler)
* Chrome with the PostMan REST Client-plugin
 
In this exercise you'll learn:
------------------------------
*  how to deal with different mediatypes like text/pain and application/json
*  how to use Jersey and Jackson for mapping POJOs to and from JSON
*  how to build a REST resource using different HTTP verbs like GET, POST and DELETE 

Steps
-----
1. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven") and [Tomcat8](http://tomcat.apache.org/ "Tomcat8"). 

2.  Add a new Jersey configuration called <code>RestConfig</code>. Make your it extends <code>ResourceConfig</code> and let is look for REST resources in the package <code>oose.dea.services.rest</code>. Let this configuration match the application path "/rest".

3. Add a new REST Resource: create a class <code>ItemResource</code> and register "/items" as the default path. Add a method <code>String getTextItems()</code> that:

	* returns a hardcoded String "bread, butter".  
	* matches a GET request
	* produces plain text

4. Build the project and run it using Tomcat. 
Visit [http://localhost:8080/rest/items](http://localhost:8080/rest/items) with the PostMan plugin. 

5. Add a new method to the <code>ItemResource</code> called <code>String getJsonItems()</code> that:

	* returns a hardcoded JSON String "{ "bread", "butter" }"
	* matches a GET request
	* produces JSON

6. Build the project and run it using Tomcat. 
Visit [http://localhost:8080/rest/items](http://localhost:8080/rest/items) with the PostMan plugin. You see plain text output, don't you? Change the HTTP-header Accept to application/json and try again.

7. Add an attribute *items* of type <code>List\<Item></code> to <code>ItemResource</code> and fill this list with two or more instances of type <code>Item</code>. Adjust the method <code>getTextItems</code> to loop through the item-list and return a text-based representation. Rebuild the project and test the application again. Does it still work?

8. Now change the method <code>getJsonItems</code> to return a JSON-representation of the item-list. Use Jackson's ObjectMapper to do the trick: 

	<pre>
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(items);
	</pre>

	Rebuild the project and test the application again.

9. Hey, we're using Jersey! It has a built in ability to map objects to JSON using Jackson. Change the signature of the <code>getJsonItems</code> method so it returns a List of items. Implement the method just to return the item-list, without manually converting them to JSON. Wait, before rebuilding your project you have to modify the <code>RestConfig</code>:

	<pre>
	property("jersey.config.server.provider.packages", "com.fasterxml.jackson.jaxrs.json;service");
	</pre>
	
	Now rebuild your application and test the application again.
	
10. Add a method <code>Item getJsonItem(String sku)</code> to find a certain item using its sku. Of course it has to return JSON. TIP: You might need annotations liks <code>@Path</code> and <code>@PathParam</code>. 

11. To close this exercise, add void methods to:
	* add a new Item (TIP: Use <code>@Consumes</code> instead of <code>@Produces</code>)
	* delete an existing Item 

    Notice that however the methods are void methods, there is in fact a HTTP Response: 204 (NO CONTENT).

12. When you don't see any effect of adding or deleting items consider making the <code>ItemResource</code> <code>@javax.inject.Singleton</code>, which ensures only one instance of the REST resource instead of creating a new instance every request.
    
Done 
----
You can checkout the branch exercise-results for a working project and review possible differences. 