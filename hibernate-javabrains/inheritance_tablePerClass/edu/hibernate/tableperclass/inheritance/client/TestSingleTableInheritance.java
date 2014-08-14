package edu.hibernate.tableperclass.inheritance.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.tableperclass.inheritance.FourWheeler;
import edu.hibernate.tableperclass.inheritance.TwoWheeler;
import edu.hibernate.tableperclass.inheritance.Vehicle;

public final class TestSingleTableInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("My Vehicle");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Yamaha FZ");
		bike.setStreeingHandle("Yamaha Bike Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("BMW");
		car.setSteeringWheel("BMW Streeing Wheel");
		
		
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
