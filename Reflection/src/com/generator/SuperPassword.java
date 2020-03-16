package com.generator;

import enums.Book;

// Represents third-party class
public class SuperPassword {

	// dummy dependency for class loading tests
	// book is from JavaPractice project
	public Book book = new Book();

	@Generator
	public String createPassword() {
		return "Super password";
	}
}
