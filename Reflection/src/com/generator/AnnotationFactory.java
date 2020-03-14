package com.generator;

import java.io.FileReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class AnnotationFactory {

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

			Method[] methods = generator.getDeclaredMethods(); // receive all methods, private included
			for (Method method : methods) {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					if (annotation.toString().equals("@com.generator.Generator()")) {
						Object passwordGenerator = createObject(generator);
						method.setAccessible(true); // allow access to private methods
						return (String) method.invoke(passwordGenerator);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GeneratorOne().generate();
	}

	private static Object createObject(Class<?> clazz) throws Exception {
		Object obj = clazz.getDeclaredConstructor().newInstance();
		fillProperties(obj);
		return obj;
	}

	private static Object fillProperties(Object obj) {
		for (String property : properties.stringPropertyNames()) {
			String value = properties.getProperty(property);
			// System.out.println(property + "=" + value);
			if (property.equals("algorithm")) {
				Field field;
				try {
					// field = obj.getClass().getField(property);
					field = obj.getClass().getDeclaredField(property); // private fields too
					field.setAccessible(true); // make private field accessible
					field.set(obj, value);
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException e) {
					System.out.println("Exception while init field");
				}
			}
		}
		return obj;
	}
}
