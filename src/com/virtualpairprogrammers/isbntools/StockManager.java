package com.virtualpairprogrammers.isbntools;

public class StockManager {

	private ExternalISBNDataService service;
	
	//I need to pass the implementation of the service when I'm gonna use
	//any method of the service, otherwise I'm gonna get a null pointer exception
	//when I call the getLocatorCode method in the tests or any other piece of code
	public void setService(ExternalISBNDataService service) {
		this.service = service;
	}

	public String getLocatorCode(String isbn) {
		Book book = service.lookup(isbn);
		StringBuilder locator = new StringBuilder();
		locator.append(isbn.substring(isbn.length() - 4));
		locator.append(book.getAuthor().substring(0, 1));
		locator.append(book.getTitle().split(" ").length);
		
		return locator.toString();
	}

}
