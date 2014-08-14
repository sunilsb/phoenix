package edu.hibernate.proxy_eager_lazy;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String city;
	private Long pin;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPin() {
		return pin;
	}
	public void setPin(long i) {
		this.pin = i;
	}
}
