/**
 * Data-Structures-And-Algorithms-in-Java
 * WeakHashMapImplementation.java
 */
package com.deepak.data.structures.Hashing;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Class to implement weak HashMap
 * @author Deepak
 */
public class WeakHashMapImplementation {

	/**
	 * Method to start the flow of the program
	 * 1. Create a Map of Orders and Integer (Order Count)
	 * 2. Create one strong reference and two weak references of object Orders
	 * 3. Insert all three values
	 * 4. Force run GC on the map
	 * 5. Check the size of the Map
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Orders, Integer> ordersMap = new WeakHashMap<>();

		// Creating a strong reference of object Orders and inserting in map
		Orders order = new Orders(1, "Details of Order 1");
		ordersMap.put(order, 60);

		// Creating weak references of object Orders and inserting in map
		ordersMap.put(new Orders(2, "Details of Order 2"), 50);
		ordersMap.put(new Orders(3, "Details of Order 3"), 30);

		// Check the size of Map
		System.out.println("Size of Map after one Strong reference and two weak references insertion. => "
				+ ordersMap.size());

		// Force run garbage collection
		System.gc();
		System.runFinalization();

		// Check the size of Map again. It should should 1 (Strong reference)
		System.out.println("Size of Map after Gargabe Collection => " + ordersMap.size());
	}

}

/**
 * Sample class orders
 * @author Deepak
 */
class Orders {

	int orderId;
	String orderDetails;

	/**
	 * Constructor for creating orders
	 * @param iOrderId
	 * @param iOrderDetails
	 */
	public Orders(int iOrderId, String iOrderDetails) {
		orderId = iOrderId;
		orderDetails = iOrderDetails;
	}

}