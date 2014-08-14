package edu.hibernate.crud.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.crud.Employee;

public class TestCrud {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		for(int i=0; i<10;i++) {
			Employee emp = new Employee();
			emp.setEmpName("emp"+i);
			session.save(emp);
		}
		
		Employee emp = (Employee)session.get(Employee.class, 6);
		System.out.println("Emp ID : "+emp.getEmpId() + " \nEmpName : "+emp.getEmpName());
//		emp.setEmpName("updated Employee");
//		session.delete(emp);
		session.getTransaction().commit();
		session.close();
	}

}
