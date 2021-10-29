package com.revature.exception;

public class UserExistException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	public UserExistException() {
		super("User already exists");
	}

}
