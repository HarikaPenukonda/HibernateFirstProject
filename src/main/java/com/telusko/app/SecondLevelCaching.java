package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class SecondLevelCaching {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class)
				.configure().buildSessionFactory();
		
		Session session1 = null;
		Session session2 = null;
		
		try {
			session1 = sessionFactory.openSession();
			
			Student student1 = session1.find(Student.class, 101);
			System.out.println(student1);
			
			Student student2 = session1.find(Student.class, 101);
			System.out.println(student2); 
			
			
			session2 = sessionFactory.openSession();
			
			student1 = session2.find(Student.class, 101);
			System.out.println(student1);
			
			student2 = session2.find(Student.class, 101);
			System.out.println(student2); 
		
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			session1.close();
			session2.close();
			sessionFactory.close();
		}

	}

}
