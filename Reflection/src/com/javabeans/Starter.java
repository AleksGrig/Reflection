package com.javabeans;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class Starter {

	public static void main(String[] args) throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(Employee.class);
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		for (var descriptor : descriptors) {
			if (!descriptor.getName().equals("class")) {
				System.out.println(descriptor.getName());
				System.out.println(descriptor.getReadMethod());
				System.out.println(descriptor.getWriteMethod());
			}
		}
	}

}
