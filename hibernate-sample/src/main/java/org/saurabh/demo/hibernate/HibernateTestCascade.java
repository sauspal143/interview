package org.saurabh.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.saurabh.demo.hibernate.dto.UserDetailsCascade;
import org.saurabh.demo.hibernate.dto.VehicleCascade;

/**
 * 
 * Sample Hibernate call
 *
 */
public class HibernateTestCascade {

	public static void main(String[] args) {
		UserDetailsCascade user = new UserDetailsCascade("First User");
		VehicleCascade vehicle = new VehicleCascade("Car");
		VehicleCascade vehicle2 = new VehicleCascade("Jeep");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		// session.save(user);
		//session.save(vehicle); 
		//session.save(vehicle2);
		session.getTransaction().commit();
		
		session.close();
		System.out.println("DONE CREATION");
	}

}
