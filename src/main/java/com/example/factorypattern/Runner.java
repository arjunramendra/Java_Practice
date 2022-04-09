package com.example.factorypattern;

public class Runner {
	
	public static void main(String[] args) {
		OSFactory factory = new OSFactory();
		OS system = factory.getInstance("Windows");
		system.spec();
	}

}
