package edu.hibernate.secondlevel.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class TestSecondLevelCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee emp1 = new Employee();
//		emp1.setEmpCompany("Ericsson");
//		emp1.setEmpDesignation("SSI");
//		emp1.setEmpLocation("Bangalore");
//		emp1.setEmpName("Sunil");
//		
		Employee emp2 = new Employee();
//		emp2.setEmpCompany("Volvo IT");
//		emp2.setEmpDesignation("Senior Test Engg");
//		emp2.setEmpLocation("Bangalore");
//		emp2.setEmpName("Rahul");
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session1 = factory.openSession();
		session1.beginTransaction();
		emp1 = (Employee) session1.get(Employee.class, 1);
		System.out.println(emp1.getEmpName());
//		session1.save(emp1);		
//		session1.save(emp2);
		session1.getTransaction().commit();
		session1.flush();
		session1.close();
		
		Session session2 = factory.openSession();
		session2.beginTransaction();
		emp2 = (Employee) session2.get(Employee.class, 2);
		System.out.println(emp2.getEmpName());
		session2.getTransaction().commit();
		session2.close();
	}

}
