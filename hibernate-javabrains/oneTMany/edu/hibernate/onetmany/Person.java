package edu.hibernate.onetmany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personId;
	private String personName;
	@OneToMany(mappedBy="person")
//	@JoinTable(name="Person_Vehicles",joinColumns=@JoinColumn(name="person_id"), 
//			   inverseJoinColumns=@JoinColumn(name="vehicle_id"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}
