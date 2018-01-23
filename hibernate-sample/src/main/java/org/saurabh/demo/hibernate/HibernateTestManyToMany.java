package org.saurabh.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.saurabh.demo.hibernate.dto.UserDetailsManyToMany;
import org.saurabh.demo.hibernate.dto.VehicleManyToMany;

/**
 * 
 * Sample Hibernate call
 *
 */
public class HibernateTestManyToMany {

	public static void main(String[] args) {
		UserDetailsManyToMany user = new UserDetailsManyToMany("First User");
		VehicleManyToMany vehicle = new VehicleManyToMany("Car");
		VehicleManyToMany vehicle2 = new VehicleManyToMany("Jeep");
		
		vehicle.getUserList().add(user);
		vehicle2.getUserList().add(user);
		
		user.getVehicles().add(vehicle);
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
