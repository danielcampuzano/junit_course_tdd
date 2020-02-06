package com.virtualpairprogrammers.isbntools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateISBNTest {

	@Test
	public void checkValid10DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue(result, "first value");
		result = validator.checkISBN("0140177396");
		assertTrue(result, "second value");
	}
	
	@Test
	public void checkAValid13ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9788499086552");
		assertTrue(result, "first value");
		
		result = validator.checkISBN("9788439722410");
		assertTrue(result, "second value");
	}
	
	@Test
	public void tenDigitIsbnNumbersEndingInAnXAreValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void checkInvalid10DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void checkInvalid13DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9788439722414");
		assertFalse(result);
	}
	
	@Test
	public void nineDigitISBNNumbersAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();	
		assertThrows(NumberFormatException.class, 
				() -> { validator.checkISBN("140449117"); } );
	}
	
	@Test
	public void nonNumericISBNsAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		
		assertThrows(NumberFormatException.class, 
				() -> { validator.checkISBN("helloworld"); } );
		
	}
	

}
