package com.revature.exception;

public class InvialdCredentials extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InvialdCredentials() {
		super("Invalid credentials");
	}

}