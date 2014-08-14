package edu.hibernate.onetmany.mappedby;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Watch {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int watchId;
	private String watchName;
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getWatchId() {
		return watchId;
	}
	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}
	public String getWatchName() {
		return watchName;
	}
	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}
	
}
