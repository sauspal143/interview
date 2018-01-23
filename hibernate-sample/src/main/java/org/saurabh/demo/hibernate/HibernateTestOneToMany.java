package org.saurabh.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.saurabh.demo.hibernate.dto.UserDetailsOneToMany;
import org.saurabh.demo.hibernate.dto.Vehicle;

/**
 * 
 * Sample Hibernate call
 *
 */
public class HibernateTestOneToMany {

	public static void main(String[] args) {
		UserDetailsOneToMany user = new UserDetailsOneToMany("First User");
		Vehicle vehicle = new Vehicle("Car");
		user.getVehicles().add(vehicle);
		Vehicle vehicle2 = new Vehicle("Jeep");
		user.getVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle); // This step is need if we have 2 individual entities like UserDetailsOneToOne and Vehicle
		session.save(vehicle2);
		session.getTransaction().commit();
		
		session.close();
		System.out.println("DONE CREATION");
	}

}
