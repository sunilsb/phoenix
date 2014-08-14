package edu.hibernate.onetmany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne
	@JoinColumn(name="person_Id")
	private Person person;
	
	public Person getUser() {
		return person;
	}
	public void setUser(Person user) {
		this.person = user;
	}
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
	
}
