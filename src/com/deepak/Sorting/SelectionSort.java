/**
 * Data-Structures-And-Algorithms-in-Java
 * SelectionSort.java
 */
package com.deepak.Sorting;

import java.util.Arrays;

/**
 * Class for SelectionSort implementation
 * @author Deepak
 */
public class SelectionSort {

	/**
	 * Main method to start the flow of program
	 * @param args
	 */
	public static void main(String[] args) {
		int[] valuesToBeSorted = {7, 10, 47, 40, 83, 84, 65, 61, 32, 55, 49, 46, 25, 20, 93, 63, 54, 10};
		System.out.println("******************* SELECTION - SORT *******************");
		performSelectionSort(valuesToBeSorted);
	}

	/**
	 * Selection Sort implementation
	 * <p> This Algorithm divides the array into two imaginary arrays i.e one with sorted elements, 
	 * and other one with unsorted elements. Initially sorted array will be empty, while unsorted
	 * one contains the whole array.
	 * At every step algorithm finds minimal element from the unsorted array and adds it to the end
	 * of sorted one. When unsorted part becomes empty algorithm stops</p>
	 * 
	 * <p>How it works?
	 * 1. Loop through the entire collection of elements n-1 times. 
	 * 	  We need n-1 passes here because second last pass will sort entire collection.  
	 * 2. Assume first element is the smallest one in the collection.
	 * 3. Loop through rest of the unsorted collection and find the minimum element.
	 * 	  If found, replace it with the minimum we choose at the beginning.
	 * 4. Keep doing it until we finish the inner loop i.e all unsorted elements.
	 * 5. Now, swap the minimum value with the value from where parent loop started
	 * 6. Repeat 2-5 till we get sorted collection back</p>
	 * 
	 * <p>Time Complexity</p>
	 * Whenever there are inner loops associated, complexity is n^2. In this case, 
	 * Best - O(n^2)
	 * Average - O(n^2)
	 * Worst - O(n^2)
	 * 
	 * @param listOfValues - List of values passed in the request
	 */
	private static void performSelectionSort(int[] listOfValues) {
		for (int i = 0; i < listOfValues.length - 1; i++) {
			int positionHoldingMinimumValue = i;
			for (int j = i + 1; j < listOfValues.length; j++) {
				if (listOfValues[j] < listOfValues[positionHoldingMinimumValue]) {
					positionHoldingMinimumValue = j;
				}
			}
			swap(listOfValues, positionHoldingMinimumValue, i);
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
