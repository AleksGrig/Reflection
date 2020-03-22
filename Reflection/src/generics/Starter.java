package generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Starter {

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("generics.GenericSimple");
		System.out.println("Class name: " + clazz.getTypeName()); // Without generics
		Method[] methods = clazz.getDeclaredMethods();
		for (var method : methods) {
			if (method.getName().equals("test")) {
				// Class<?>[] parameters = method.getParameterTypes(); // non-generics
				int count = 1;
				Type[] parameters = method.getGenericParameterTypes(); // generics
				for (var parameter : parameters) {
					// System.out.println(parameter.getCanonicalName());
					System.out.println("Parameter" + count++ + ": " + parameter);
				}
				// Class<?> returnType = method.getReturnType();
				Type returnType = method.getGenericReturnType();
				System.out.println("Return type: " + returnType);

				System.out.println();

				for (var parameter : parameters) {
					if (parameter instanceof ParameterizedType) {
						var paramType = (ParameterizedType) parameter;
						// Map depends upon two parameters
						System.out.println("1: " + paramType.getActualTypeArguments()[0]);
						System.out.println("2: " + paramType.getActualTypeArguments()[1]);
					}
				}
			}
		}
	}
}
