package edu.hibernate.singletable.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4wheel")
public class FourWheeler extends Vehicle {

	private String streeingWheel;

	public String getStreeingWheel() {
		return streeingWheel;
	}

	public void setStreeingWheel(String streeingWheel) {
		this.streeingWheel = streeingWheel;
	}
	
}
