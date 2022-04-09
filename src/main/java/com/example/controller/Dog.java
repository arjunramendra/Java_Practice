package com.example.controller;

import org.springframework.stereotype.Service;

@Service
public class Dog implements Animal {

	public String sound() {
		return "Bark";
	}
	
}
