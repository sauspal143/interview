package org.saurabh.demo.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.saurabh.demo.hibernate.dto.Address;
import org.saurabh.demo.hibernate.dto.UserDetails;

/**
 * 
 * Sample Hibernate call
 *
 */
public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails("First User",new Address("Mowry","Fremont","CA","94538"),new Address("Harrison","Oakland","CA","94612"),"First Hobbies");
		user.setJoinedDate(new Date());
		user.setDescription("This would be a CLOB object");
		
		UserDetails user2 = new UserDetails("Second User",new Address("Mowry2","Fremont","CA","94538"),new Address("Harrison2","Oakland","CA","94612"),"Second Hobbies");
		user2.setJoinedDate(new Date());
		user2.setDescription("This would be a CLOB object for Second");
		
		//UserDetails user = new UserDetails(2,"Second User");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		System.out.println("DONE CREATION");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails userFetched = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("Fetched User Id -> " + userFetched.getUserId() + " - User Name -> " + userFetched.getUserName());
		session.close();
		System.out.println("DONE FETCH");
	}

}
