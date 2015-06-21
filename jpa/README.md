Exercise JPA
============
Resources
-------------
The following resources are convenient (some are required) during the exercise:

* DEA Slides: Java EE Data Source Layer revisited
* Chapter 11, 12 and 13 from Patterns of Enterprise Application Architecture (Fowler)
* MySQL installed on your local machine including a MySQL client like [MySQL workbench](https://dev.mysql.com/downloads/workbench/).

In this exercise you'll learn:
------------------------------
* how to create the persistence.xml file and to use its properties
* how to create and use the JPA entity manager
* how to use identity fields and simple properties in JPA
* how to build a simple DAO for one class using JPA

Steps
-----
1. Open the Project (pom.xml) in your IDE. The next steps will assume you've used IntelliJ, but we'll guess it still works in any IDE that supports [Maven](http://maven.apache.org/ "Maven"). Notice that this project is pretty much prepared. We gave you the client (<code>JpaMain</code>) to test the <code>ItemJpaDAO</code> and the skeleton for this class. We also prepared
 a simple POJO, called <code>Item</code>. The following steps will "JPA-fy" your code.

2. JPA is an API and we besides the JPA we need an implementation. Add the following dependencies to the pom.xml:

  ```xml
  <!-- Hibernate / JPA -->
  <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>${hibernate.version}</version>
  </dependency>
  <dependency>
      <groupId>org.hibernate.javax.persistence</groupId>
      <artifactId>hibernate-jpa-2.1-api</artifactId>
      <version>1.0.0.Final</version>
  </dependency>
  <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-entitymanager</artifactId>
      <version>${hibernate.version}</version>
  </dependency>
  <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-c3p0</artifactId>
      <version>${hibernate.version}</version>
  </dependency>
  <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-simple</artifactId>
      <version>1.6.2</version>
  </dependency>
  <dependency>
      <groupId>javassist</groupId>
      <artifactId>javassist</artifactId>
      <version>3.12.1.GA</version>
  </dependency>
  ```
  Notice that we don't include Guice in this exercise although the slides do use it in the examples. This only works when running in a container. This exercise uses a simple main method so we need an other way to get access to the <code>EntityManager</code>.

3. We can now use and configure JPA by adding a file called ```persistence.xml``` to src/main/resources/META-INF:
    ```xml
    <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
             version="2.1">
      <persistence-unit name="simpleorder" transaction-type="RESOURCE_LOCAL">
          <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

          <class>oose.dea.dataaccess.Item</class>

          <properties>
              <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/simpleorder"/>
              <property name="javax.persistence.jdbc.user" value="YOUR_USER_HERE"/>
              <property name="javax.persistence.jdbc.password" value="YOUR_PASSWORD_HERE"/>
              <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>

              <property name="hibernate.show_sql" value="true"/>
              <property name="hibernate.format_sql" value="true"/>
              <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5InnoDBDialect"/>
              <property name="hibernate.hbm2ddl.auto" value="validate"/>

              <!-- Configuring Connection Pool -->
              <property name="hibernate.c3p0.min_size" value="5"/>
              <property name="hibernate.c3p0.max_size" value="20"/>
              <property name="hibernate.c3p0.timeout" value="500"/>
              <property name="hibernate.c3p0.max_statements" value="50"/>
              <property name="hibernate.c3p0.idle_test_period" value="2000"/>
          </properties>
      </persistence-unit>
  </persistence>
    ```
Make sure the database ```simpleorder``` exists and fill in proper values for the user and password and give the user proper privileges to the database. You may reuse the database from the [JDBC exercise](https://github.com/ddoa/dea-code-examples/tree/master/jdbc), make sure it contains no tables at all.  

4. Now make the class ```Item``` a simple entity by:
  * annotating the class with ```@Entity```
  * annotating the class with ```@Table(name = "items")```
  * annotate the field ```id``` with:
  ```java
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  ```
  * overriding the ```toString()``` method so it returns a human readable representation of the class

5. Implement the constructor of ```ItemJpaDAO``` so it creates an instance of ```EntityManager```. Save it in a field called em:
  ```java
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("simpleorder");
this.em = emf.createEntityManager();
  ```

6. Implement the ```find(id)``` method by using the find-method on the EntityManager. Also implement the ```findAll``` method by creating a ```Query``` object and get the resultlist as a ```List``` of ```Item``` instances.

7. Change (only for now) the value ```hibernate.hbm2ddl.auto``` to create. Comment lines 11 - 17 in the main-method of the class ```JpaMain``` before running it. OK, we actually got nothing from the database, but if you look at the console you find something like "INFO: HHH000230: Schema export complete". We just used a hibernate specific feature to generate and execute a DDL from inspecting the ```Item``` entity. Before proceeding, change the value of ```hibernate.hbm2ddl.auto``` to validate, so we can preserve our newborn table.

8. Implement the ```add``` method of ```ItemJpaDAO``` by creating and beginning a transaction, persist the newEntity, flush the ```EntityManager``` and commit the transaction. Uncomment line 11 and 12 before running the main-method again.

9. Implement the ```update``` and ```remove``` method. Use a find on the ```EntityManager``` to find a attached entity using the id of the detached parameter and update/remove the specific item. Uncomment lines 13 - 16 of the main-method before running it again.

Done
----
You can checkout the branch exercise-results for a working project and review possible differences.
