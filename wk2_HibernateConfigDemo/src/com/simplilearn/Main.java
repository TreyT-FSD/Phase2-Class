package com.simplilearn;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		
		Session session;
		try {
			
			
			session = sessionFactory.openSession();
			System.out.println(session);
			
			
			Employee emp1 = new Employee(10,"jack", 55000);
			
			Transaction tx = session.beginTransaction();
			
			session.save(emp1);
			
			tx.commit();
			
			session.close();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
	}
}
