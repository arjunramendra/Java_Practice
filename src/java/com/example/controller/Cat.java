package com.example.controller;

import org.springframework.stereotype.Service;

@Service
public class Cat implements Animal {

	public String sound() {
		return "Meow";
	}
	
	
	
}
