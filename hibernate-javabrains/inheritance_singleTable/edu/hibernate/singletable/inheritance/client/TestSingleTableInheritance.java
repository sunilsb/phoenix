package edu.hibernate.singletable.inheritance.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.singletable.inheritance.FourWheeler;
import edu.hibernate.singletable.inheritance.TwoWheeler;
import edu.hibernate.singletable.inheritance.Vehicle;

public final class TestSingleTableInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("My Vehicle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Mercedeze");
		car.setStreeingWheel("Benz Streening Wheel");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Honda Shine");
		bike.setStreengHandle("Bike Handle Bar");
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(car);
		session.save(bike);
		session.getTransaction().commit();
		session.close();
	}

}
