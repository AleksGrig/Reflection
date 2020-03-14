package com.generator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PasswordGeneratorFactory {

	public static PasswordGenerator getPasswordGenerator() throws Exception {
		String generatorName = getGenerator();
		Class<?> generator = Class.forName(generatorName);
		PasswordGenerator passwordGenerator = (PasswordGenerator) generator.getDeclaredConstructor().newInstance();
		return passwordGenerator;
	}

	private static String getGenerator() throws IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("generators.properties"));
		return properties.getProperty("generator");
	}
}
