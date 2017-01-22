/**
 * Data-Structures-And-Algorithms-in-Java
 * ConcurrentHashMapImplementation.java
 */
package com.deepak.data.structures.Hashing;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Concurrent HashMap implementation
 * @author Deepak
 */
public class ConcurrentHashMapImplementation {

	// Map to store orders for different cities
	static Map<String, AtomicLong> ordersMap = new ConcurrentHashMap<>();

	/**
	 * Method to process orders
	 */
	static void processOrders() {
		for (String city : ordersMap.keySet()) {
			for (int i = 0; i < 50; i++) {
				ordersMap.get(city).getAndIncrement();
			}
		}
	}

	/**
	 * Main method to start the flow of program
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ordersMap.put("Delhi", new AtomicLong());
		ordersMap.put("London", new AtomicLong());
		ordersMap.put("New York", new AtomicLong());
		ordersMap.put("Sydney", new AtomicLong());

		// Executor service with 2 threads
		ExecutorService service = Executors.newFixedThreadPool(2);

		// Submitting two tasks to service
		service.submit(new Runnable() {
			@Override
			public void run() {
				processOrders();
			}
		});
		service.submit(new Runnable() {
			@Override
			public void run() {
				processOrders();
			}
		});

		// Waiting for 1 second and then shutting down the service
		service.awaitTermination(1, TimeUnit.SECONDS);
		service.shutdown();
		System.out.println(ordersMap);
	}

}
