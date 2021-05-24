package com.simplilearn.wk2_HibernateMavenDemo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory sessionFactory;
	
	
    public static void main( String[] args )
    {
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		
		sessionFactory = metaData.getSessionFactoryBuilder().build();
		
		Session session;
		Transaction transaction;
		try {
			
			session = sessionFactory.openSession();
			
			System.out.println(session);
			
			Employee emp1 = new Employee("jack", 55000);
			
			transaction = session.beginTransaction();
			
			session.save(emp1);
			
			transaction.commit();
			
			session.close();
			
		} catch (HibernateException e) {
			System.out.println("Hibernate exception thrown: " + e.getMessage());
			e.printStackTrace();
		}
    }
    
    public static void insertEmployee() {
    	
    	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		
		Session session;
		Transaction transaction;
		try {
			
			session = sessionFactory.openSession();
			
			System.out.println(session);
			
			Employee emp1 = new Employee(10,"jack", 55000);
			
			transaction = session.beginTransaction();
			
			session.save(emp1);
			
			transaction.commit();
			
			session.close();
			
		} catch (HibernateException e) {
			System.out.println("Hibernate exception thrown: " + e.getMessage());
			e.printStackTrace();
		}
    	
    }
    
    public static void getAllEmployees() {
    	
    }
    
    public static void deleteEmployee() {
    	
    	
    	
    }
}
