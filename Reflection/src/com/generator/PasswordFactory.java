package com.generator;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class PasswordFactory {

	private static Properties properties;
	static {
		properties = new Properties();
		try {
			properties.load(new FileReader("generators.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPassword() {
		try {
			String generatorName = properties.getProperty("generator");
			Class<?> generator = Class.forName(generatorName);
			Object passwordGenerator = generator.getDeclaredConstructor().newInstance();
			String methodName = properties.getProperty("method");
			Method method = generator.getMethod(methodName);
			return (String) method.invoke(passwordGenerator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GeneratorOne().generate();
	}
}
