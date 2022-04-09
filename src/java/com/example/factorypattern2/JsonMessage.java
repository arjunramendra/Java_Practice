package com.example.factorypattern2;

public class JsonMessage extends Message{

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return "{\"JSON]\":[]}" ;
	}

	@Override
	public String toString() {
		return "JsonMessage [getContent()=" + getContent() + "]";
	}

	
	
}
