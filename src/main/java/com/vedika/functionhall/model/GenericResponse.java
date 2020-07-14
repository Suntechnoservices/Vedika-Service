package com.vedika.functionhall.model;

public class GenericResponse<T> {

	private String userId;
	private T data;
	private String message;

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "GenericResponse [ data=" + data + ", message=" + message + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}



}