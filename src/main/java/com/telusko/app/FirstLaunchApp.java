package com.telusko.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class FirstLaunchApp {

	public static void main(String[] args) {
		
		// step 1 - configuration object
		Configuration configuration = new Configuration();
		
		// step 2 - configure hibernate.cfg.xml file to the configuration object
		configuration.configure();
		
		// step 3 - Create session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		// step 4 - create a new session
		Session session = sessionFactory.openSession();
		
		// step 5 - Begin the transaction within session (non-select statements)
		Transaction transaction = session.beginTransaction();
		
		// step 6 - Create student object
		Student student = new Student(101,"Sheldon Cooper",19,"coopers@gmail.com");
		
		// step 7 - Perform operation - create
		// If you're using Hibernate 6.x, the save() method has been removed from the main API.
		session.persist(student);
		
		// Step 8 - performing transaction operation
		transaction.commit();
		
		// step 9 - closing the session
		session.close();
		
		
	}

}
