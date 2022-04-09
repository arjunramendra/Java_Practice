package com.example.factorypattern2;

public class JsonMessageCreator extends MessageCreator{

	@Override
	public Message createMessage() {
		// TODO Auto-generated method stub
		return new JsonMessage();
	}

}
