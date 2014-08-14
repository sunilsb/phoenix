package edu.hibernate.singletable.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="2wheel")
public class TwoWheeler extends Vehicle {

	private String streengHandle;

	public String getStreengHandle() {
		return streengHandle;
	}

	public void setStreengHandle(String streengHandle) {
		this.streengHandle = streengHandle;
	}
	
}
