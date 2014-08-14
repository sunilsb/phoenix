package edu.hibernate.cache.queryCache.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hibernate.cache.queryCache.Employee;

public class TestQueryCache {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Employee employee where employee.empId = 4");
		query.setCacheable(true);
//		List<Employee> employee = (List<Employee>) query.list();
		
		List<Employee> employees = (List<Employee>)query.list();
		for(Employee emp : employees) {
			System.out.println(emp.getEmpId()+"::"+emp.getEmpName());
		}
//		for(int i=1; i<=20;i++) {
//			Employee emp = new Employee();
//			emp.setEmpName("emp"+i);
//			session.save(emp);
//		}
		session.getTransaction().commit();
		session.close();
		
		Session session2 = factory.openSession();
		session2.beginTransaction();
		Query query2 = session2.createQuery("from Employee employee where employee.empId = 4");
		query2.setCacheable(true);
		employees = (List<Employee>) query2.list();
		
		for(Employee emp : employees) {
			System.out.println(emp.getEmpId()+"::"+emp.getEmpName());
		}
		
		session2.getTransaction().commit();
		session2.close();
		System.exit(0);
	}

}
