package edu.hibernate.hql.namedNativeQueries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
//@NamedNativeQuery(name="Employee.byId",query="select * from employee where empid = ?",resultClass=Employee.class) /* For positional parameter*/
@NamedNativeQuery(name="Employee.byId",query="select * from employee where empid = :id",resultClass=Employee.class) /* For Named Parameter*/
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	private String empName;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
}
