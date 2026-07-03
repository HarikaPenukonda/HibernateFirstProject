------------------------------------------------------------
Error #001
------------------------------------------------------------

Date:
03-Jul-2026

Topic: Hibernate Configuration

Error Message: Could not load requested class: com.mysql.jdbc.Driver

Cause: Used the old MySQL JDBC driver class.

Solution:
Changed: com.mysql.jdbc.Driver --> To: com.mysql.cj.jdbc.Driver

Learning: MySQL Connector/J 8.x and later uses com.mysql.cj.jdbc.Driver.

Status: ✅ Resolved

------------------------------------------------------------
Error #002
------------------------------------------------------------

Topic: Hibernate Session

Error Message: The method save(Student) is undefined for type Session

Cause: Using Hibernate 6, where save() is removed.

Solution:
Used: session.persist(student);

Learning: Hibernate 6 recommends persist() instead of save().

Status: ✅ Resolved

------------------------------------------------------------
Error #003
------------------------------------------------------------

Date: 03-Jul-2026

Topic: Hibernate JDBC Driver

Error Message: Exception in thread "main" org.hibernate.service.spi.ServiceException: Unable to create requested service[org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Unable to load class [com.mysql.cj.jdbc.Driver]

Cause: Hibernate is trying to load the MySQL JDBC driver, but the driver class is not available in the project's classpath.

Possible Causes:
1. The MySQL Connector/J dependency is missing from pom.xml.
2. Maven dependencies have not been downloaded or updated.
3. The driver class name is incorrect.
4. The project is not recognized as a Maven project.

Solution:
1. Add the MySQL Connector/J dependency to pom.xml.

   <dependency>
       <groupId>com.mysql</groupId>
       <artifactId>mysql-connector-j</artifactId>
       <version>9.3.0</version>
   </dependency>

2. Right-click the project → Maven → Update Project.

3. Verify that the following property exists in hibernate.cfg.xml:

   <property name="hibernate.connection.driver_class">
       com.mysql.cj.jdbc.Driver
   </property>

4. Clean and rebuild the project.

Learning:
Hibernate does not contain the MySQL JDBC driver. The JDBC driver is a separate library that must be included as a project dependency. Without it, Hibernate cannot establish a connection to the database.

Interview Insight:
Hibernate communicates with the database through JDBC. If the JDBC driver is missing, Hibernate cannot create the JdbcEnvironment, and application startup fails.

Status: ✅ Resolved
