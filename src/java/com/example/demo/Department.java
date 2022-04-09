package com.example.demo;

@FunctionalInterface
public interface Department {
	
	public void getDep();
	
	default String returnName() {
		return "name";
	}

}
