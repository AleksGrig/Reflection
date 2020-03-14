package com.generator;

public class GeneratorTwo implements PasswordGenerator {

	@Override
	@Generator
	public String generate() {
		return "Password Two";
	}

}
