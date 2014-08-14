package edu.hibernate.hql.namedQueries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="UserDetail.byId",query="from UserDetail where userId = ?")
@NamedNativeQuery(name="userdetail.byName",query="select * from userdetail where userName = ?", 
					resultClass=UserDetail.class)
public class UserDetail {

	private int userId;
	private String userName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	
}
