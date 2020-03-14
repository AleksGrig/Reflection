package com.generator;

public class Main {

	public static void main(String[] args) {
		// PasswordGenerator generator =
		// PasswordGeneratorFactory.getPasswordGenerator();
		// System.out.println(generator.generate());

//		String password = PasswordFactory.getPassword();
//		System.out.println(password);

		String password = AnnotationFactory.getPassword();
		System.out.println("Generated password:" + password);
	}
}
