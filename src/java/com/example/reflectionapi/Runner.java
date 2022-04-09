package com.example.reflectionapi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> c = Class.forName("com.example.reflectionapi.TestClass");
		TestClass t = (TestClass)c.newInstance();
	
		Method m = c.getDeclaredMethod("privateMethod", null);
		m.setAccessible(true);
		System.out.println(m.invoke(t, null));
	}
}
