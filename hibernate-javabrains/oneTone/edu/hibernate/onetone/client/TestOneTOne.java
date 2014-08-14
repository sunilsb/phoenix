package edu.hibernate.onetone.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.onetone.Person;
import edu.hibernate.onetone.Vehicle;

public final class TestOneTOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person ram = new Person();
		ram.setPersonName("RAM");
		
		Person shyam = new Person();
		shyam.setPersonName("SHYAM");
		
		Vehicle car = new Vehicle();
		car.setVehicleName("XUV-500");
		
		Vehicle jeep = new Vehicle();
		jeep.setVehicleName("Mahindra-Armada");
		
		ram.setVehicle(jeep);
		jeep.setPerson(ram);
		
		shyam.setVehicle(car);
		car.setPerson(shyam);
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(ram);
		session.save(shyam);
		session.save(jeep);
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}

}
