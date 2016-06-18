/**
 * Data-Structures-And-Algorithms-in-Java
 * BinarySearch.java
 */
package com.deepak.Searching;

/**
 * Class for BinarySearch implementation
 * @author Deepak
 */
public class BinarySearch {

	/**
	 * Main method to start the flow of program
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sortedValues = {7, 10, 10, 20, 25, 32, 40, 46, 47, 49, 54, 55, 61, 63, 65, 83, 84, 93};
		int valueToBeSearched = 84;
		System.out.println("******************* BINARY SEARCH *******************");
		performBinarySearch(sortedValues, valueToBeSearched);
	}

	/**
	 * <p>Binary Search 
	 * Few points to note here,
	 * 1. Binary search works only on sorted collection
	 * 2. Ex. Looking up a name in Telephone directory
	 * 3. Each time we make a comparison, we eliminate half of the list </p>
	 * 
	 * <p> Algorithm :
	 * 1. Find the mid index in the list and compare it with the search term
	 * 2. If search term is smaller then the element at mid index, eliminate upper half, else eliminate lower half
	 * 3. If it is equal, break the loop as we have found our element. 
	 * 4. Keep running the loop until high >= low. 
	 * 5. return index of matching item, or -1 if not found
	 * </p>
	 * 
	 * <p>Complexity :
	 * 1. Best Case : What is the fewer number of iterations to find the item?
	 * 	=> Best case is when search term is at the first try
	 * 	=> Number of comparisons in this case is 1
	 *  
	 * 2. Worst Case : What is the most number of comparisons needed to find the item?
	 * 	=> Worst case is when search term is not at all in the array
	 * 	=> If our array is of size N, we need N comparisons for worst case
	 * 
	 * 3. Average Case : On an Average, how many comparisons are needed to find the element in the array?
	 * 	=> On an average, search term is anywhere in the list
	 * </p>
	 */
	private static void performBinarySearch(int[] iListOfValues, int iValueToBeSearched) {
		int index = -1;
		int low = 0;
		int mid;
		int high = iListOfValues.length - 1;
		while (high >= low) {
			mid = (high + low)/2;
			if (iValueToBeSearched < iListOfValues[mid]) { 
				high = mid - 1;
			} else if (iValueToBeSearched > iListOfValues[mid]) {
				low = mid + 1;
			} else {
				index = mid;
				break;
			}
		}
		if (index != -1) {
			System.out.println("Element found in the list at position = " + index);
		} else {
			System.out.println("Element not found in the list");
		}
	}

}
