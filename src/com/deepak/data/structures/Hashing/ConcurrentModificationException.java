/**
 * Data-Structures-And-Algorithms-in-Java
 * ConcurrentModificationException.java
 */
package com.deepak.data.structures.Hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Program to show concurrent modification exception
 * @author Deepak
 */
public class ConcurrentModificationException {

	/**
	 * Main method to start the flow of the program
	 * 1. We will create a HashMap and insert some key value pairs in it
	 * 2. Iterate over the KeySet
	 * 3. Try inserting a new value in the HashMap
	 * 4. Since we are reading the HashMap and doing insertion at same time, 
	 * 	  It will throw ConcurrentModificationException
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> scores = new HashMap<>();
		scores.put("Team A", 10);
		scores.put("Team B", 10);
		scores.put("Team C", 12);
		scores.put("Team D", 10);
		scores.put("Team E", 14);
		scores.put("Team F", 10);

		// Iterate over the entries of HashMap
		Iterator<String> scoresItr = scores.keySet().iterator();
		while (scoresItr.hasNext()) {
			System.out.println(scores.get(scoresItr.next()));
			// Try inserting a new entry
			scores.put("Team G", 10);
		}
	}

}
