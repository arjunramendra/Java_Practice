package com.example.designpatterns;

public class SingletonRunner {

	public static void main(String[] args) {
		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
	}
	
}
