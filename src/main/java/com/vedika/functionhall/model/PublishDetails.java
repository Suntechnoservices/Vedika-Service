package com.vedika.functionhall.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PublishListing")

public class PublishDetails {
	private int ownerId;
	private String corelationId;
	private Location location;
	private FunctionHall details;
	private BankDetails paymentDetails;
	private ResponseObject security;
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public BankDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(BankDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public ResponseObject getSecurity() {
		return security;
	}
	public void setSecurity(ResponseObject security) {
		this.security = security;
	}

	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getCorelationId() {
		return corelationId;
	}
	public void setCorelationId(String corelationId) {
		this.corelationId = corelationId;
	}

	public FunctionHall getDetails() {
		return details;
	}
	public void setDetails(FunctionHall details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "PublishDetails [ownerId=" + ownerId + ", corelationId=" + corelationId + ", location=" + location
				+ ", details=" + details + ", paymentDetails=" + paymentDetails + ", security=" + security + "]";
	}
	


}
