package edu.hibernate.cascade.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.cascade.Mobile;
import edu.hibernate.cascade.Person;

public final class TestCascade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person sunil = new Person();
		sunil.setPersonName("Sunil");
		
		Mobile mob1 = new Mobile();
		Mobile mob2 = new Mobile();
		mob1.setMobName("Samsung");
		mob2.setMobName("Sony");
		
		sunil.getMobList().add(mob1);
		sunil.getMobList().add(mob2);
		mob1.setPerson(sunil);
		mob2.setPerson(sunil);
		
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.persist(sunil);
		session.getTransaction().commit();
		session.close();
	}

}
