package com.example.designpatterns;

public class Singleton {

	public static Singleton single = new Singleton();
	private Singleton() {};
	
	public static Singleton getInstance() {
		return single;
	}
	
}
