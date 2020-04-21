package com.example.rest;

public class StudentNotFoundException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;

	
	public StudentNotFoundException() {
		super();
	}

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StudentNotFoundException [message=" + message + "]";
	}
	
	
	
}
