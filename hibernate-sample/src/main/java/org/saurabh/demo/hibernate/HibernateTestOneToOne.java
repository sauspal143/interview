package org.saurabh.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.saurabh.demo.hibernate.dto.UserDetailsOneToOne;
import org.saurabh.demo.hibernate.dto.Vehicle;

/**
 * 
 * Sample Hibernate call
 *
 */
public class HibernateTestOneToOne {

	public static void main(String[] args) {
		UserDetailsOneToOne user = new UserDetailsOneToOne("First User");
		Vehicle vehicle = new Vehicle("First User Vehicle");
		user.setVehicle(vehicle);
		UserDetailsOneToOne user2 = new UserDetailsOneToOne("Second User");
		Vehicle vehicle2 = new Vehicle("Second User Vehicle");
		user2.setVehicle(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle); // This step is need if we have 2 individual entities like UserDetailsOneToOne and Vehicle
		session.save(user2);
		session.save(vehicle2);
		session.getTransaction().commit();
		
		session.close();
		System.out.println("DONE CREATION");
	}

}
