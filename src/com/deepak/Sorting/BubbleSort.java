/**
 * Data-Structures-And-Algorithms-in-Java
 * BubbleSort.java
 */
package com.deepak.Sorting;

import java.util.Arrays;

/**
 * Class for BubbleSort implementation
 * @author Deepak
 */
public class BubbleSort {

	/**
	 * Main method to start the flow of program
	 * @param args
	 */
	public static void main(String[] args) {
		int[] valuesToBeSorted = {7, 10, 47, 40, 83, 84, 65, 61, 32, 55, 49, 46, 25, 20, 93, 63, 54, 10};
		System.out.println("******************* BUBBLE - SORT *******************");
		performBubbleSort(valuesToBeSorted);
	}

	/**
	 * Bubble Sort implementation
	 * <p> Question - When will you consider a list of items to be sorted?
	 * Answer - When all the elements to the left of each element are smaller then the element
	 * 
	 * This algorithm works on this principle. We start this Algorithm from index = 1, because element
	 * at index 0 is already considered as sorted since there are no elements on its left side.
	 * In this algorithm, we pick up each item and compares it to the item positioned on its left.
	 * If picked up item is smaller then the left item, then it is in wrong position. 
	 * We swap it and keep going on until the items are finished.</p>
	 * 
	 * <p>How it works?
	 * 1. Loop through the entire collection of elements n-1 times. 
	 * 	  We start with N = 1 here, as explained above (Assume first element is already sorted in the collection)
	 * 2. Loop through rest of the collection again to keep comparing each of the item
	 * 3. If item on the left is smaller then the item on the right, swap it
	 * 4. Repeat 1-3 till we get sorted collection back</p>
	 * 
	 * <p>Time Complexity</p>
	 * Whenever there are inner loops associated, complexity is n^2. In this case, 
	 * Best - O(n)
	 * Average - O(n^2)
	 * Worst - O(n^2)
	 * 
	 * @param listOfValues - List of values passed in the request
	 */
	private static void performBubbleSort(int[] listOfValues) {
		for (int i = 0; i < listOfValues.length; i++) {
			for (int j = 1; j < (listOfValues.length - i); j++) {
				if (listOfValues[j - 1] > listOfValues[j]) {
					swap(listOfValues, j - 1, j);
				}
			}
		}
		Arrays.stream(listOfValues).forEach(System.out::println);
	}

	/**
	 * Method to swap 2 values
	 * @param values
	 * @param firstValue
	 * @param secondValue
	 */
	private static void swap(int[] values, int firstValue, int secondValue) {
		int tempValue = values[firstValue];
		values[firstValue] = values[secondValue];
		values[secondValue] = tempValue;
	}

}
