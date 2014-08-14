package edu.hibernate.onetmany.mappedby.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.onetmany.mappedby.Owner;
import edu.hibernate.onetmany.mappedby.Watch;

public final class TestOneToManyMappedBy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Owner sunil = new Owner();
		sunil.setOwnerName("Sunil Singh Bohra");
		
		Watch sunilWatch1 = new Watch();
		sunilWatch1.setWatchName("G-Shock RiseMan");
		sunil.getWatches().add(sunilWatch1);
		sunilWatch1.setOwner(sunil);
		
		Watch sunilWatch2 = new Watch();
		sunilWatch2.setWatchName("Q & Q");
		sunil.getWatches().add(sunilWatch2);
		sunilWatch2.setOwner(sunil);
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(sunil);
		session.save(sunilWatch1);
		session.save(sunilWatch2);
		session.getTransaction().commit();
		session.close();
	}

}
