package com.example.demo.rest;

public class AccountNotFoundException extends Throwable {
	private static final long serialVersionUID = 1L;

	String message;

	public AccountNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AccountNotFoundException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "InstuctorNotFoundException [message=" + message + "]";
	}

	

}
