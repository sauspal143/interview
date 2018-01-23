package org.saurabh.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.saurabh.demo.hibernate.dto.Address;
import org.saurabh.demo.hibernate.dto.UserDetailsWithCollection;

/**
 * 
 * Sample Hibernate call
 *
 */
public class HibernateTestCollection {

	public static void main(String[] args) {
		UserDetailsWithCollection user = new UserDetailsWithCollection("First User");
		user.getListOfAddress().add(new Address("Mowry","Fremont","CA","94538"));
		user.getListOfAddress().add(new Address("Harrison","Oakland","CA","94612"));
		
		UserDetailsWithCollection user2 = new UserDetailsWithCollection("Second User");
		user2.getListOfAddress().add(new Address("Mowry2","Fremont","CA","94538"));
		user2.getListOfAddress().add(new Address("Harrison2","Oakland","CA","94612"));
		
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
		UserDetailsWithCollection userFetched = (UserDetailsWithCollection) session.get(UserDetailsWithCollection.class, 1);
		System.out.println("Fetched User Id -> " + userFetched.getUserId() + " - User Name -> " + userFetched.getUserName());
		// Whenever getListOfAddress() is encountered in the code that is the time when hibernate is going to pool all the address for the User
		// The above is what is called Lazy initialization 
		// Opposite of this strategy is Eager initialization @ElementCollection (fetch=FetchType.EAGER)
		// To perform Lazy initialization hibernate uses Proxy class, fills first (ProxyUserDetails) level values of UserDetails class
		// To test proxy class just end session before calling getListOfAddress()
		session.close(); // This is enabled as @ElementCollection (fetch=FetchType.EAGER) for listOfAddress
		// Doing session.close() throws
		//  org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: org.saurabh.demo.hibernate.dto.UserDetailsWithCollection.listOfAddress, could not initialize proxy - no Session
		System.out.println("Address size for User -> " + userFetched.getListOfAddress() != null ? userFetched.getListOfAddress().size() : 0);
		// session.close();
		System.out.println("DONE FETCH");
	}

}
