package edu.hibernate.hql.namedNativeQueries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestNamedNativeQueries {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();		
		session.beginTransaction();
		
//		for(int i=1;i<=10;i++) {
//			Employee emp = new Employee();
//			emp.setEmpName("emp "+i);
//			session.save(emp);
//		}
		
		String empId = "5";
		Query query = session.getNamedQuery("Employee.byId");
		query.setInteger("id", Integer.parseInt(empId));       /*For named parameter*/
//		query.setInteger(0, Integer.parseInt(empId));          /* For positional parameter*/
		List<Employee> list = (List<Employee>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(Employee emp:list){
			System.out.println(emp.getEmpId());
			System.out.println(emp.getEmpName());
		}
	}

}
