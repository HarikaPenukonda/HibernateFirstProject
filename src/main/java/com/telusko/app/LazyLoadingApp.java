package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class LazyLoadingApp {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class)
				.configure().buildSessionFactory();
		
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			Student student = session.getReference(Student.class, 101);
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getAge());
		
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
			sessionFactory.close();
		}

	}

}
