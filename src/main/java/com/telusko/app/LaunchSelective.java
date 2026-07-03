package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Employee;

public class LaunchSelective {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure()
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Employee employee = new Employee(1001,"Micheal Scott","Management","scranton");
			session.persist(employee);
			flag = true;
			
		}catch (HibernateException e) {
			System.out.println(e);
		}catch(Exception e) {
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
