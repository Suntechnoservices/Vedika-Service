package com.vedika.functionhall.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PublishListing")

public class PublishDetails {
	private int ownerId;
	private String correlationid;
	private Location location;
	private FunctionHall details;
	private AccountDetails paymentDetails;
	private Security security;
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public AccountDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(AccountDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public Security getSecurity() {
		return security;
	}
	public void setSecurity(Security security) {
		this.security = security;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getCorrelationid() {
		return correlationid;
	}
	public void setCorrelationid(String correlationid) {
		this.correlationid = correlationid;
	}

	public FunctionHall getDetails() {
		return details;
	}
	public void setDetails(FunctionHall details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "PublishDetails [ownerId=" + ownerId + ", correlationid=" + correlationid + ", location=" + location
				+ ", details=" + details + ", paymentDetails=" + paymentDetails + ", security=" + security + "]";
	}
	
}
