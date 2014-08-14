package edu.hibernate.manytmany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personId;
	private String personName;
	@ManyToMany
	@JoinTable(name="person_vechile",joinColumns=@JoinColumn(name="personId"),inverseJoinColumns=@JoinColumn(name="vechileId"))
	private Collection<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	
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
	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
}
