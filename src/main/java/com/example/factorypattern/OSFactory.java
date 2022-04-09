package com.example.factorypattern;

public class OSFactory {

	public OS getInstance(String str) {
		if(str == "iOS") {
			return new iOS();
		}else if(str == "Android") {
			return new Android();
		}else {
			return new Windows();
		}
	}
	
}
