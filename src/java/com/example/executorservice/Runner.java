package com.example.executorservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Runner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		runnableRunner();
		callableRunner();
	}
	
	public static void runnableRunner() {
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for(int i= 0; i < 1000; i++) {
			service.execute(new RunnableExample());
		}
	}
	
	public static void callableRunner() throws InterruptedException, ExecutionException {
		Collection<Callable<String>> tasks = new ArrayList<>();
		for(int i = 0; i < 1000; i++) {
			tasks.add(new CallableFututreExample());
		}
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		List<Future<String>> response = pool.invokeAll(tasks);
		for(Future<String> future : response) {
			System.out.println(future.get());
		}
		pool.shutdown();
	}
}
