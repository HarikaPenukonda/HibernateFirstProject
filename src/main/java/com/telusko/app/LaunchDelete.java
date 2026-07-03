package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class LaunchDelete {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class)
				.configure().buildSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student student = new Student(103, "penny", 20, "pennygirl@gmail.com");
			session.remove(student);; // saveOrUpdate
			flag = true;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			if(flag == true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}

	}

}
