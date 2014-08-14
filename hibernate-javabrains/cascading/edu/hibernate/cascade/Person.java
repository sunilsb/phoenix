package edu.hibernate.cascade;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personId;
	private String personName;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Person_Mobile_Details", joinColumns=@JoinColumn(name="p_id"),inverseJoinColumns=@JoinColumn(name="m_id"))
	private Collection<Mobile> mobList = new ArrayList<Mobile>();
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
	public Collection<Mobile> getMobList() {
		return mobList;
	}
	public void setMobList(Collection<Mobile> mobList) {
		this.mobList = mobList;
	}
	
	
}
