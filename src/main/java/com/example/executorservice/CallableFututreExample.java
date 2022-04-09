package com.example.executorservice;

import java.util.concurrent.Callable;

public class CallableFututreExample implements Callable<String> {

	@Override
	public String call() throws Exception {
		new Thread();
		return Thread.currentThread().getName();
	}
}