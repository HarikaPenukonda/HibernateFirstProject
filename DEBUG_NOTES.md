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

Error #004
------------------------------------------------------------

Hibernate Error Report

Error:

java.lang.IllegalStateException: Cache provider not started
Caused by: javax.cache.CacheException: No CachingProviders have been configured

Cause:
Hibernate 7 couldn't find a JCache provider because the Ehcache provider wasn't configured.

Solution:

Removed the old Hibernate 5 configuration:

org.hibernate.cache.ehcache.EhCacheRegionFactory

Added the JCache provider:

<property name="hibernate.javax.cache.provider">
    org.ehcache.jsr107.EhcacheCachingProvider
</property>
Used JCacheRegionFactory with Hibernate 7.

Lesson Learned:

Hibernate 5 → EhCacheRegionFactory
Hibernate 6/7 → JCacheRegionFactory + JCache provider (Ehcache 3)

Status: ✅ Resolved

------------------------------------------------------------
Error #005
------------------------------------------------------------

Date:
16-Jul-2026

Topic:
Hibernate ID Generation Strategy

Error Message:
The ID was generated as 1 instead of the expected initial value 100, even though @SequenceGenerator was configured.

Cause:
The entity was using:

@GeneratedValue(
    strategy = GenerationType.IDENTITY,
    generator = "my_seq"
)

`GenerationType.IDENTITY` uses the database's AUTO_INCREMENT mechanism and ignores the @SequenceGenerator configuration. Therefore, the `initialValue` specified in `@SequenceGenerator` was not applied.

Solution:
Changed the generation strategy to:

@GeneratedValue(
    strategy = GenerationType.AUTO,
    generator = "my_seq"
)

With `GenerationType.AUTO`, Hibernate selected an appropriate ID generation strategy for the underlying database and honored the configured generator, resulting in IDs starting from 100.

Learning:
- `GenerationType.IDENTITY` relies on the database's AUTO_INCREMENT feature and does not use `@SequenceGenerator`.
- `@SequenceGenerator` is effective only when Hibernate uses a sequence-based strategy.
- `GenerationType.AUTO` allows Hibernate to choose the most suitable strategy based on the database and configuration.

Interview Insight:
Understand the difference between ID generation strategies:

- IDENTITY → Uses database AUTO_INCREMENT.
- SEQUENCE → Uses a database sequence.
- AUTO → Hibernate chooses the appropriate strategy.
- TABLE → Uses a separate table to generate unique IDs.

Always choose the generation strategy based on the capabilities of your database.

Status:
✅ Resolved
