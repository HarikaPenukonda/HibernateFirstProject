package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;



public class LaunchStandardApp {

	public static void main(String[] args) {
		
		Configuration configuration = null;
		
		SessionFactory sessionFactory = null;
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		configuration = new Configuration();
		
		configuration.configure();
		
		sessionFactory = configuration.buildSessionFactory();
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
		
		Student student = new Student(102, "Raj Koothrapalli", 21, "koothrapallir@gmail.com");
		
		try {
			
			transaction = session.beginTransaction();
			session.persist(student);
			flag = true;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if(flag == true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}
		
		
		
		
		

	}

}
