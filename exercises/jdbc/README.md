Exercise JDBC and Logging
=========================
Resources
-------------
The following resources are convenient (some are required) during the exercise:

* DEA Slides: Java EE Data Source Layer
* Chapter 10 from Patterns of Enterprise Application Architecture (Fowler)
* MySQL installed on your local machine (Windows download at https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-web-community-5.6.26.0.msi) including a MySQL client like [MySQL workbench](https://dev.mysql.com/downloads/workbench/).
* The [JDBC API Guide](http://docs.oracle.com/javase/7/docs/technotes/guides/jdbc/)
* Jenkovs [JDBC Tutorial](http://tutorials.jenkov.com/jdbc/index.html)
* Need more theoretic background? Visit one of these resources:
	* http://staff.cs.upt.ro/~ioana/arhit/2015/DataAccessPattern.ppt
	* http://blog.fedecarg.com/2009/03/12/domain-driven-design-and-data-access-strategies/
	* http://martinfowler.com/eaaCatalog/
* Need more practical background and do you have a PluralSight account? As a HAN-OOSE student you can apply for an account at [ICA Xtend](https://ica-xtend.nl/winkel/):
	* http://www.pluralsight.com/courses/mastering-java-swing-part2 (Querying Databases using JDBC etc.)
	* http://www.pluralsight.com/courses/mastering-java-swing-part2 (Bridge Pattern)

In this exercise you'll learn:
------------------------------
* how to use property files and load property files from the classpath
* how to use the JDBC API to connect to relational databases
* how to add the MySQL JDBC driver to a Maven Project
* how to execute simple SQL statements and process resultsets
* how to implement the Data Access Object pattern using JDBC
* how to apply proper handling of exceptions using Java Logger.

Steps
-----
1. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven")

2. Before we actually going to connect to the database start with creating a property file called <code>database.properties</code> and put the file in src/main/resources. Add properties and values for:
	* driver, e.g. com.mysql.jdbc.Driver
	* connectionstring, e.g. jdbc:mysql://localhost/items?user=YOUR_USERNAME_HERE&password=YOUR_PASSWORD

	Make sure this user exists and has enough [privileges](https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql "privileges") for the specific database

3. Create a new class <code>DatabaseProperties</code> in a package <code>oose.dea.datasource.util</code>that loads the property file and exposes the four properties using get-methods. Create a new class <code>JdbcApp</code> with a main-method to test the <code>DatabaseProperties</code> class

4. Before we can use access database we:
	* need a vendor specific (MySQL) database driver
	* need to create a database

	Create an empty database and make sure the configured user has appropriate privileges.

5. Add the database driver to the dependencies of your pom.xml:

  ```xml
	<dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.34</version>
   </dependency>
   ```

6. Create a new class <code>ItemDao</code> with a method called <code>List<Item> findAll()</code>. Place the new class in the package <code>oose.dea.datasource</code>. Implement the findAll-method using the <code>DatabaseProperties</code> class.

	TIPS:
	* Use <code>Class.forName</code> on the databasedriver to load the driver
	* <code>DriverManager.getConnection()</code> creates a Connection
	* Connection are able to create Statements: <code>connection.prepareStatement("SELECT * FROM items").executeQuery();</code>
	* Executing a query lead to a <code>ResultSet</code>
	* You can loop through ResultSets using <code>next()</code>

	Call the <code>findAll()</code> method from your main-method and display the results.

7. Until now, you might have caught exceptions like this:
	```java
	  try
	  {
	      connection.prepareStatement("...").execute();
	      connection.close();
	  } catch (SQLException e) {
	      e.printStackTrace();
	  }
	 ```

As you may know printing the stacktrace uses <code>System.out</code> which may be redirected. That's why code quality tools like [Sonar](http://www.sonarqube.org) advice developers to use a Logger instead.

	Create a (one) logger in your class and use <code>logger.log()</code> (or <code>logger.warning()</code>, <code>logger.severe()</code>, etc.) instead.

8. Implement the rest of the DAO-methods (create, insert, update and delete) using PreparedStatements. You might need [Transactions](http://www.mkyong.com/jdbc/jdbc-transaction-example/) for the latter three.

Done
----
You can checkout the branch exercise-results for a working project and review possible differences. In this branch you'll also find an example of how to unit test your ItemDao using H2 in memory database. 
