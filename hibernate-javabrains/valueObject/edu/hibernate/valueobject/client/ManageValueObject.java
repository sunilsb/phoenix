package edu.hibernate.valueobject.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.valueobject.Address;
import edu.hibernate.valueobject.UserDetails;

public class ManageValueObject {

	public static void main(String[] args) {
		
		UserDetails user1 = new UserDetails();
		Address address1 = new Address();
		address1.setStreet("Marathahalli");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPin("560037");
		
		Address address2 = new Address();
		address2.setStreet("S G Palya");
		address2.setCity("Bangalore");
		address2.setState("Karnataka");
		address2.setPin("560019");
		
		Address address3 = new Address();
		address3.setStreet("BTM");
		address3.setCity("Bangalore");
		address3.setState("Karnataka");
		address3.setPin("560036");
		
		user1.setUserName("User1");
		user1.getAddresses().add(address1);
		user1.getAddresses().add(address2);
		user1.getAddresses().add(address3);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.getTransaction().commit();
		session.close();
	}

}
