package edu.hibernate.onetmany.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.onetmany.Person;
import edu.hibernate.onetmany.Vehicle;

public final class TestOneToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person ram = new Person();
		ram.setPersonName("RAM");		
		
		Vehicle maruti = new Vehicle();
		maruti.setVehicleName("maruti-800");
		ram.getVehicles().add(maruti);
		maruti.setUser(ram);
				
		Vehicle honda = new Vehicle();
		honda.setVehicleName("Karizma R 225");
		ram.getVehicles().add(honda);
		honda.setUser(ram);
		
		Vehicle renault = new Vehicle();
		renault.setVehicleName("Duster");
		ram.getVehicles().add(renault);
		renault.setUser(ram);
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(ram);
		session.save(maruti);
		session.save(honda);
		session.save(renault);
		session.getTransaction().commit();
		session.close();		
		
	}

}
