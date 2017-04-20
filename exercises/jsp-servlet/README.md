Exercise JSP and Servlets
=========================
Resources
-------------
The following resources are convenient during the exercise:

* DEA Slides: Java EE Presentation Layer 
* Chapter 4 and 14 from Patterns of Enterprise Application Architecture (Fowler)
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account by mailing @rodmidde:
	* http://www.pluralsight.com/courses/java-web-fundamentals (including Java Server Pages)
	* http://www.pluralsight.com/courses/springmvc-intro (only the Introduction)
 
In this exercise you'll learn:
------------------------------
* how to administer welcome-files
* what the difference is between HTML and JSP pages
* how to use the JSTL tag library
* how to configure a web application using the web.xml deployment descriptor and annotations
* how JSPs, servlets and [POJOs](https://en.wikipedia.org/wiki/Plain_Old_Java_Object) can play together in MVC-roles. 

Steps
-----
1. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven") and [Tom EE Plus](http://tomee.apache.org/download-ng.html "Tom EE Plus"). 
2.  Add a simple index.html to the src/main/webapp folder. Build the project and run it using Tomcat. 
Visit [localhost:8080](http://localhost:8080/).

3.  Rename the index.html to start.html. Visit the same URL again.
 
4.  You see a HTTP 404 error, don't you? You just found out that index.html (and index.jsp) are the default pages. Modify the web.xml so the application has start.html as the welcome-page.

5.  Add a simple next.jsp page that displays the current Date. Add next.jsp to the web.xml using the *servlet* and *servlet-mapping* tags and make it accessible using the url <b>next</b>. Test the application.

6.  Create a class called <code>ViewItemsController</code> that extends HttpServlet. Implement the doGet method by writing a simple list of items, use the existing classes <code>ItemService</code> and <code>Item</code>. Make the servlet accessible using the url <b>viewItems</b>, *without* modifying the web.xml (so use an annotation). Add a link to the next.jsp page that refers to this servlet. Test the application.

7.  Create a new jsp called viewItems.jsp (*View*) and let the servlet serve as a *PageController*. The servlet is allowed to prepare the model for the view and passes the data using attributes before dispatching the request and response to the view. Test the application.

Done 
----
You can checkout the branch exercise-results for a working project and review possible differences. 
