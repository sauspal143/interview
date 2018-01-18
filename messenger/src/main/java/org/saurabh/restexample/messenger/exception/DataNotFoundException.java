package org.saurabh.restexample.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7298021282029353136L;
	
	public DataNotFoundException(String message) {
		super(message);
	}
}
