package com.example.factorypattern2;

public class TextMessage extends Message {

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return "Text";
	}

	@Override
	public String toString() {
		return "TextMessage [getContent()=" + getContent() + "]";
	}
	
	

}
