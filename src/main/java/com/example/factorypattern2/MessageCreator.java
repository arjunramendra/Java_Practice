package com.example.factorypattern2;

public abstract class MessageCreator {
	
	public Message getMessage() {
		 Message msg = createMessage();
		 msg.addDefaultheaders();
		 msg.encrypt();
		 return msg;
	}
	
	//FactoryMethod
	public abstract Message createMessage();
	
}
