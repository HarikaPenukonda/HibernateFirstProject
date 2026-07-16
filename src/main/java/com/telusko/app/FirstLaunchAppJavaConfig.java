package com.telusko.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class FirstLaunchAppJavaConfig {

	public static void main(String[] args) {
		
		// step 1 - configuration object
		Configuration configuration = new Configuration();
		
		// step 2 - configure hibernate.cfg.xml file to the configuration object
		// configuration.configure(); - Not needed since there is no hibernate.cfg.xml file
		
		// step 2 - add hibernate propertie
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/teluskodb");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "admin");
		configuration.setProperty(
		        "hibernate.dialect",
		        "org.hibernate.dialect.MySQLDialect");

		configuration.setProperty(
		        "hibernate.show_sql",
		        "true");

		configuration.setProperty(
		        "hibernate.format_sql",
		        "true");

		configuration.setProperty(
		        "hibernate.hbm2ddl.auto",
		        "update");
		
		// entity class
		configuration.addAnnotatedClass(Student.class);
		
		// step 3 - Create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		// step 4 - create a new session
		Session session = sessionFactory.openSession();
		
		// step 5 - Begin the transaction within session (non-select statements)
		Transaction transaction = session.beginTransaction();
		
		// step 6 - Create student object
		Student student = new Student(104,"Howard W",23,"wolowizard@gmail.com");
		
		// step 7 - Perform operation - create
		// If you're using Hibernate 6.x, the save() method has been removed from the main API.
		session.persist(student);
		
		// Step 8 - performing transaction operation
		transaction.commit();
		
		// step 9 - closing the session
		session.close();
		
		
	}

}
