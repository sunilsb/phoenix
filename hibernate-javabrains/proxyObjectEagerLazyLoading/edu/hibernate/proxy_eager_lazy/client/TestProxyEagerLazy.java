package edu.hibernate.proxy_eager_lazy.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.proxy_eager_lazy.UserDetails;


public final class TestProxyEagerLazy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails sunil = new UserDetails();
//		sunil.setUserName("Sunil Singh Bohra");
		
		UserDetails kama = new UserDetails();
//		kama.setUserName("Kamalesh Pandey");
		
//		Address add1 = new Address();
//		add1.setCity("Champawat");
//		add1.setStreet("Tanakpur Road");
//		add1.setPin(262523);
//		
//		Address add2 = new Address();
//		add2.setCity("Pithauragarh");
//		add2.setStreet("Sajjan Hostel");
//		add2.setPin(262524);
//		
//		Address add3 = new Address();
//		add3.setCity("Nainatal");
//		add3.setStreet("Malli Tal");
//		add3.setPin(267875);
//		
//		Address add4 = new Address();
//		add4.setCity("Dwarahat");
//		add4.setStreet("KEC");
//		add4.setPin(262531);
//		
//		sunil.getAddress().add(add1);
//		sunil.getAddress().add(add2);
//		sunil.getAddress().add(add3);
//		sunil.getAddress().add(add4);
//		
//		Address kamaAdd1 = new Address();
//		kamaAdd1.setCity("Lohaghat");
//		kamaAdd1.setStreet("Main market");
//		kamaAdd1.setPin(262524);
//		
//		Address kamaAdd2 = new Address();
//		kamaAdd2.setCity("Pithauragarh");
//		kamaAdd2.setStreet("Cinema Line");
//		kamaAdd2.setPin(262525);
//		
//		Address kamaAdd3 = new Address();
//		kamaAdd3.setCity("Dwarahat");
//		kamaAdd3.setStreet("KEC");
//		kamaAdd3.setPin(267875);		
//		
//		kama.getAddress().add(kamaAdd1);
//		kama.getAddress().add(kamaAdd2);
//		kama.getAddress().add(kamaAdd3);
		
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
//		session.save(sunil);
//		session.save(kama);
//		session.getTransaction().commit();
//		session.close();
		sunil = null;
		session = factory.openSession();
		sunil = (UserDetails) session.get(UserDetails.class, 2);
//		session.close();
		System.out.println(sunil.getAddress().size());
	}

}
