/**
 * Data-Structures-And-Algorithms-in-Java
 */
package com.deepak.data.structures.Arrays;

/**
 * Class to hold implementation of basic operations in java
 * <p> Perform following basic operations on Arrays
 * 	1. Declare Array
 * 	2. Insert elements in Array. ex. 3, 5, 6, 13, 45, 56, 67, 78, 89, 90
 * 	3. Delete a element say 6 and print the rest of the array</p>
 * @author Deepak
 */
public class BasicOperations {

	public static void main(String[] args) {
		// Since we know size of elements is 10, declare the array
		int[] sampleArray = new int[10];
		// Insert values as asked in the problem
		sampleArray[0] = 3;
		sampleArray[1] = 5;
		sampleArray[2] = 6;
		sampleArray[3] = 13;
		sampleArray[4] = 45;
		sampleArray[5] = 56;
		sampleArray[6] = 67;
		sampleArray[7] = 78;
		sampleArray[8] = 89;
		sampleArray[9] = 90;
		// Hold size of the array in a variable
		int arraySize = sampleArray.length;

		// Printing the elements of the array
		System.out.println("Elements are inserted. Starting to print them");
		for (int i=0; i < arraySize; i++) {
			System.out.print(sampleArray[i] + " ");
		}
		System.out.println();
		System.out.println("**********************************");

		// Search the given elements
		System.out.println("Starting to Search an element");
		int index = -1;
		for (int i=0; i < arraySize; i++) {
			if (sampleArray[i] == 45) {
				System.out.println("Element found at index = " + i);
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println("Element not found");
		}

		System.out.println("**********************************");
		// Delete the given element
		System.out.println("Starting to delete an element and printing updated array");
		for (int i=0; i < arraySize; i++) {
			if (sampleArray[i] == 6) {
				for (int j=i; j < arraySize - 1; j++) {
					// move the elements one place to left
					sampleArray[j] = sampleArray[j + 1]; 
				}
				// decrease the size of array by 1
				arraySize--;
				break;
			}
		}

		// Print the final Array
		for (int i=0; i < arraySize; i++) {
			System.out.print(sampleArray[i] + " ");
		}
	}

}
