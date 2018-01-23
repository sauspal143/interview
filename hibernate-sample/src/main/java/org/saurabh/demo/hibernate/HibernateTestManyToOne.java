package org.saurabh.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.saurabh.demo.hibernate.dto.UserDetailsManyToOne;
import org.saurabh.demo.hibernate.dto.VehicleManyToOne;

/**
 * 
 * Sample Hibernate call
 *
 */
public class HibernateTestManyToOne {

	public static void main(String[] args) {
		UserDetailsManyToOne user = new UserDetailsManyToOne("First User");
		VehicleManyToOne vehicle = new VehicleManyToOne("Car");
		VehicleManyToOne vehicle2 = new VehicleManyToOne("Jeep");
		
		vehicle.setUserDetails(user);
		vehicle2.setUserDetails(user); // Comment this to test Orphan Vehicle object creation without any mapped User
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2); // Comment this to test Orphan Vehicle object creation without any mapped User
		
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
