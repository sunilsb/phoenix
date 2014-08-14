package edu.hibernate.criteriaapi.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import edu.hibernate.criteriaapi.Employee;

public class TestCriteriaApi {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
//		for(int i=0;i<10;i++) {
//			Employee emp = new Employee();
//			emp.setEmpName("Employee"+i);
//			session.save(emp);
//		}
		Criteria ctr = session.createCriteria(Employee.class);
		// if we need to add some restrictions to fetch the data....
//		ctr.add(Restrictions.like("empName", "%Employee%"));
		
		//Criteria chaining 
//		ctr.add(Restrictions.like("empName", "%Employee%")).add(Restrictions.between("empId", 1, 5));
		List<Employee> employees = (List<Employee>)ctr.list();
		session.getTransaction().commit();
		session.close();	
		for(Employee emp : employees) {
			System.out.println(emp.getEmpId()+"::"+emp.getEmpName());
		}
	}

}
