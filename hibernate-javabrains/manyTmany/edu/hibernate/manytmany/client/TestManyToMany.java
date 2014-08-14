package edu.hibernate.manytmany.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.manytmany.Person;
import edu.hibernate.manytmany.Vehicle;

public final class TestManyToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person ram = new Person();
		ram.setPersonName("ram");
		
		Person shyam = new Person();
		shyam.setPersonName("shyam");
		
		Vehicle ramCar = new Vehicle();
		ramCar.setVehicleName("XUV-500");
		ramCar.getUserList().add(ram);
		
		Vehicle ramBike = new Vehicle();
		ramBike.setVehicleName("Karizma 225-R");
		ramBike.getUserList().add(ram);
		
		ram.getVehicleList().add(ramCar);
		ram.getVehicleList().add(ramBike);
		
		Vehicle kamaCar = new Vehicle();
		kamaCar.setVehicleName("Renault");
		kamaCar.getUserList().add(shyam);
		
		Vehicle kamaBike = new Vehicle();
		kamaBike.setVehicleName("CBR 250");
		kamaBike.getUserList().add(shyam);
		
		shyam.getVehicleList().add(kamaBike);
		shyam.getVehicleList().add(kamaCar);
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(ram);
		session.save(shyam);
		session.save(ramCar);
		session.save(ramBike);
		session.save(kamaCar);
		session.save(kamaBike);
		session.getTransaction().commit();
		session.close();
	}

}
