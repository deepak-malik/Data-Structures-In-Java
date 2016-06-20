/**
 * Data-Structures-And-Algorithms-in-Java
 * MergeSort.java
 */
package com.deepak.Sorting;

import java.util.Arrays;

/**
 * Class for MergeSort implementation
 * @author Deepak
 */
public class MergeSort {

	/**
	 * Main method to start the flow of program
	 * @param args
	 */
	public static void main(String[] args) {
		int[] valuesToBeSorted = {7, 10, 47, 40, 83, 84, 65, 61, 32, 55, 49, 46, 25, 20, 93, 63, 54, 10};
		System.out.println("******************* MERGE - SORT *******************");
		int[] sortedValues = performMergeSort(valuesToBeSorted, 0, valuesToBeSorted.length - 1);
		Arrays.stream(sortedValues).forEach(System.out::println);
	}

	/**
	 * Merge Sort implementation
	 * 
	 * <p>Time Complexity</p>
	 * Whenever there are inner loops associated, complexity is n^2. In this case, 
	 * Best - O(n log(n))
	 * Average - O(n log(n))
	 * Worst - O(n log(n))
	 * 
	 * @param listOfValues - List of values passed in the request
	 */
	public static int[] performMergeSort(int[] iListOfValues, int iLowestPosition, int iHighestPosition) {
		if (iLowestPosition < iHighestPosition) {
			int middlePosition = iLowestPosition + (iHighestPosition - iLowestPosition) / 2;
			performMergeSort(iListOfValues, iLowestPosition, middlePosition);
			performMergeSort(iListOfValues, middlePosition + 1, iHighestPosition);
			merge(iListOfValues, iLowestPosition, middlePosition, iHighestPosition);
		}
		return iListOfValues;
	}

	/**
	 * Method to merge two items from the list
	 * @param iListOfValues
	 * @param iLowestPosition
	 * @param middlePosition
	 * @param iHighestPosition
	 * @return {@link int[]} 
	 */
	private static int[] merge(int[] iListOfValues, int iLowestPosition, int middlePosition, int iHighestPosition) {
		int[] copyOfArrays = new int[iListOfValues.length];
		for (int i = 0; i < iListOfValues.length; i++ ) {
			copyOfArrays[i] = iListOfValues[i];
		}

		int i = iLowestPosition;
		int j = middlePosition + 1;
		int k = iLowestPosition;

		while (i <= middlePosition && j <= iHighestPosition) {
			if (copyOfArrays[i] <= copyOfArrays[j]) {
				iListOfValues[k] = copyOfArrays[i];
				i++;
			} else {
				iListOfValues[k] = copyOfArrays[j];
				j++;
			}
			k++;
		}
		while (i <= middlePosition) {
			iListOfValues[k] = copyOfArrays[i];
			k++;
			i++;
		}
		return iListOfValues;
	}

}
