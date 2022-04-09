package com.example.factorypattern2;

public class Runner {

	public static void main(String[] args) {
		printMessage(new JsonMessageCreator());
		printMessage(new TextMessageCreator());
	}
	
	public static void printMessage(MessageCreator create) {
		Message msg = create.getMessage();
		System.out.println(msg);
	}
	
}
 