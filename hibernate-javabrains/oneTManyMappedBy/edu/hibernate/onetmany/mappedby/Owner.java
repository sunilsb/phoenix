package edu.hibernate.onetmany.mappedby;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ownerId;	
	private String ownerName;
	
	@OneToMany(mappedBy="owner")
	private Collection<Watch> watches = new ArrayList<Watch>();
	
	public Collection<Watch> getWatches() {
		return watches;
	}
	public void setWatches(Collection<Watch> watches) {
		this.watches = watches;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
}
