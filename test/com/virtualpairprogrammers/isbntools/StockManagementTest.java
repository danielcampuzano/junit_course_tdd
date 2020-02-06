package com.virtualpairprogrammers.isbntools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockManagementTest {

	@Test
	void testCaGetACorrectLocatorCode() {
		
		//I create my own implementation of the external webservice
		//Because I'm not expecting to test it
		ExternalISBNDataService testService = new ExternalISBNDataService() {
			
			@Override
			public Book lookup(String isbn) {
				return new Book("J, Steinberg", isbn, "Of Mice And Men");
			}
		};
		
		//I set to the service my own implementation
		//of the external component
		StockManager stockManager = new StockManager();
		stockManager.setService(testService);
		
		String isbn = "0140177396";
		String locatorCode = stockManager.getLocatorCode(isbn);
		assertEquals("7396J4", locatorCode);
	}

}
