package edu.hibernate.firstlevel.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class TestFirstLevelCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee emp = new Employee();
//		emp.setEmpName("Sunil");
//		emp.setEmpDesignation("SSI");
//		emp.setEmpLocation("Bangalore");
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		emp = (Employee) session.get(Employee.class, 1);
		Employee emp2 = (Employee) session.get(Employee.class, 1);
		System.out.println(emp.getEmpName());
		System.out.println(emp2.getEmpLocation());
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		emp = (Employee) session.get(Employee.class, 1);
		System.out.println(emp.getEmpLocation());
		
	}

}
