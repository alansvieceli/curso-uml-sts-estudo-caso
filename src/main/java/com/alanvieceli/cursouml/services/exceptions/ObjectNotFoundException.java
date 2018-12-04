package com.alanvieceli.cursouml.services.exceptions;

public class ObjectNotFoundException extends  RuntimeException{

	private static final long serialVersionUID = 4173996539778180556L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
