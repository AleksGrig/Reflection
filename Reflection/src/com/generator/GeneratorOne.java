package com.generator;

public class GeneratorOne implements PasswordGenerator {

	@Override
	@Generator
	public String generate() {
		return "Password One";
	}

}
