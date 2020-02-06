package com.virtualpairprogrammers.isbntools;

public interface ExternalISBNDataService {
	//This is the method that is gonna be implemented by the external component
	public Book lookup(String isbn); 
}
