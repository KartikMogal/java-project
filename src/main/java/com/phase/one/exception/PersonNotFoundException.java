package com.phase.one.exception;

public class PersonNotFoundException extends RuntimeException {
	public PersonNotFoundException(String msg) {
		super(msg);
	}
}
