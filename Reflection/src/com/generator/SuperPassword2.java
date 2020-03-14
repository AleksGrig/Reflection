package com.generator;

// Represents third-party class
public class SuperPassword2 {

	private String algorithm;

	@Generator
	public String createPassword() {
		return "Super password2" + " " + algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getAlgorithm() {
		return algorithm;
	}

}
