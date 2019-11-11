package com.viva.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FeeInformation {
	
		@Id
		@Column(name="contactNumber",length=15)
		private String contactNumber;
		
		@Column(name="creationDate")
		private Date creationDate = new Date();
		
		@Column(name="feeAmount")
		private double feeAmount;
		
		public FeeInformation() {
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public double getFeeAmount() {
			return feeAmount;
		}

		public void setFeeAmount(double feeAmount) {
			this.feeAmount = feeAmount;
		}

		public FeeInformation(String contactNumber, Date creationDate, double feeAmount) {
			super();
			this.contactNumber = contactNumber;
			this.creationDate = creationDate;
			this.feeAmount = feeAmount;
		}

		@Override
		public String toString() {
			return "FeeInformation [contactNumber=" + contactNumber + ", creationDate=" + creationDate + ", feeAmount="
					+ feeAmount + "]";
		}		
}
