package edu.hibernate.manytmany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	@ManyToMany(mappedBy="vehicleList")
	private Collection<Person> personList = new ArrayList<Person>();
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Collection<Person> getUserList() {
		return personList;
	}
	public void setPersonList(Collection<Person> userList) {
		this.personList = userList;
	}
}
