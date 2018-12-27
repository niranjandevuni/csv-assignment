package com.prokarma.csv.configuration;

public class ToDoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public ToDoException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public ToDoException() {
		super();
	}
}
