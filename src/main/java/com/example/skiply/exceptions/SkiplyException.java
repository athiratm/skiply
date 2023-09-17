package com.example.skiply.exceptions;

public class SkiplyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	String message;

	public SkiplyException(String msg) {
		message = msg;
		
	}

	public String toString() {
		return ("SkiplyException Occurred: " + message);
	}
}
