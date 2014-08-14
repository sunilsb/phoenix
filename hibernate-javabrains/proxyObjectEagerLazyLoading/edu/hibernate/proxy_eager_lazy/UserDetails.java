package edu.hibernate.proxy_eager_lazy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USERDETAILS")
public class UserDetails {

	private int userId;
	private String userName;
	private Collection<Address> address = new ArrayList<Address>();
	
	@ElementCollection
	@JoinTable (name="USERADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
	public Collection<Address> getAddress() {
		return address;
	}
	public void setAddress(Collection<Address> address) {
		this.address = address;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="User_Name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
}
