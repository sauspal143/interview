package org.saurabh.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.saurabh.demo.hibernate.dto.UserDetails;

/**
 * 
 * Sample Hibernate call
 *
 */
public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails(1,"First User");
		//UserDetails user = new UserDetails(2,"Second User");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

}
