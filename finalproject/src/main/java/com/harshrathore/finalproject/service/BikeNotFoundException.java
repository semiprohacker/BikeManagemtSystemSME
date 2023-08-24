package com.harshrathore.finalproject.service;

/**

Custom exception class for BikeNotFoundException.
This exception is thrown when a Bike record is not found.
*/
public class BikeNotFoundException extends RuntimeException {
	/**
	 * Custom exception class for BikeNotFoundException.
	 * 
	 * @param message The error message for the exception.
	 */

public BikeNotFoundException(String message) {
  super(message);
}
}
