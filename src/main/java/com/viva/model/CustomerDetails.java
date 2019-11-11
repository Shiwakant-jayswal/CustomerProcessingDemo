package com.viva.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CustomerDetails {
	
	@Id
	@Column(name="contactNumber",length=15)
	private String contactNumber;
	@Column(name="firstName", nullable=false, length=25)
	private String firstName;
	@Column(name="middleName",length=25)
	private String middleName;
	@Column(name="lastName",length=25)
	private String lastName;
	@Column(name="address", nullable=false,length=100)
	private String address;
	@Column(name="city", nullable=false,length=50)
	private String city;
	@Column(name="customerStatus")
	private boolean customerStatus = true;
	@Column(name="creationDate")
	private Date creationDate = new Date();
	
	public CustomerDetails() {
	}
	
	public CustomerDetails(String firstName, String middleName, String lastName, String contactNumber,
			String address, String city, boolean customerStatus, Date creationDate) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.city = city;
		this.customerStatus = customerStatus;
		this.creationDate = creationDate;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(boolean customerStatus) {
		this.customerStatus = customerStatus;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "CustomerDetails [firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", contactNumber=" + contactNumber + ", address=" + address + ", city=" + city
				+ ", customerStatus=" + customerStatus + ", creationDate=" + creationDate + "]";
	}
}
