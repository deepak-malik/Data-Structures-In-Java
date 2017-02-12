/**
 * Data-Structures-In-Java
 * BasicOperations.java
 */
package com.deepak.data.structures.Arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class to hold implementation of basic operations in java
 * 
 * <p> Perform following basic operations on Arrays
 * 1. Declare Array
 * 2. Insert elements in Array. ex. 3, 5, 6, 13, 45, 56, 67, 78, 89, 90
 * 3. Iterating over arrays in regular order and reverse order
 * 4. Converting arrays to Stream
 * 5. Finding an element in array
 * 6. Getting the length of the array
 * 7. Copying/Resizing arrays
 * 8. Removing elements from arrays
 * 9. Sorting elements in a array
 * 10. Arrays as method params
 * 11. Arrays in memory
 * 12. Casting arrays
 * 13. Comparing arrays for equality
 * 14. Converting array of objects to array of primitives
 * 15. Converting arrays between primitives and boxed types
 * 16. Reversing an array
 * 
 * @author Deepak Malik
 */
public class BasicOperations {

	/**
	 * Method to perform all operations mentioned above
	 * @param args
	 */
	public static void main(String[] args) {

		/* Declare 1-D Array */
		int[] sampleArray = new int[10];

		/* Declare 2-D Array */
		int[][] sample2DArray = {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println("Array declared\n");

		/* Insert elements in Array, ex. 3, 5, 6, 13, 45, 56, 67, 78, 89, 90 */
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
		System.out.println("Sample values inserted\n");

		/* Iterating over arrays in regular order */
		System.out.println("Printing values in regular order");
		for (int i = 0; i < sampleArray.length; i++) {
			System.out.println("Value in array at index " + i + " is " + sampleArray[i]);
		}

		/* Iterating over arrays in reverse order */
		System.out.println("\nPrinting values in reverse order");
		for (int i = sampleArray.length - 1; i >= 0; i--) {
			System.out.println("Value in array at index " + i + " is " + sampleArray[i]);
		}

		/* Iterating over 2-D array */
		for (int indexOuter = 0; indexOuter < sample2DArray.length; indexOuter++) {
			for (int indexInner = 0; indexInner < sample2DArray[indexOuter].length; indexInner++) {
				// Do something
			}
		}

		/* Print 2-D Array matrix */
		System.out.println("\nPrinting a 2-D matrix");
		for (int[] numbers : sample2DArray) {
			System.out.println(Arrays.toString(numbers));
		}

		/* Converting arrays to Stream */
		System.out.println("\nConverting Array of objects to Stream");
		String[] stringArray = {"str1", "str2", "str3"};
		Stream<String> stream = Arrays.stream(stringArray);
		System.out.println(stream.collect(Collectors.joining(" ")));

		/* Finding an element in array */
		System.out.println("\nFinding element 67 in Array");
		/* Approach 1 : Direct Linear Search. This is the most efficient solution */
		int indexFromLinearSearch = -1;
		for (int i = 0; i < sampleArray.length; i++) {
			if (67 == sampleArray[i]) {
				indexFromLinearSearch = i;
				break;
			}
		}
		System.out.println("Index of number 67 using direct linear search is " + indexFromLinearSearch);

		/* Approach 2 : Using binary search provided by Arrays class */
		int indexFromBinarySearch = Arrays.binarySearch(sampleArray, 67);
		System.out.println("Index of number 67 using binary search provided by Arrays class is " + indexFromBinarySearch);

		/* Approach 3 : Using a list for Non-Primitive arrays only */
		String[] array = new String[]{"A", "B", "C", "D"};
		int indexForNonPrimitiveArrays = Arrays.asList(array).indexOf("C");
		System.out.println("Index of \"C\" using a list is " + indexForNonPrimitiveArrays);

		/* Approach 4 : Using a stream for Non-Primitive arrays only */
		int indexUsingStream = IntStream.range(0, array.length)
				.filter(i -> "C".equals(array[i]))
				.findFirst()
				.orElse(-1);
		System.out.println("Index of \"C\" using a stream is " + indexUsingStream);

		/* Getting the length of the array */
		System.out.println("\nLength of sample Array is " + sampleArray.length);

		/* Copying a Array using for loop */
		int[] originalArray = {1, 2, 3, 4, 5};
		int[] copiedArray = new int[originalArray.length];
		for (int i = 0; i < originalArray.length; i++) {
			copiedArray[i] = originalArray[i];
		}
		System.out.println("\nUsing for loop copying original array " + Arrays.toString(originalArray) + " to new one => " + Arrays.toString(copiedArray));

		/* Copying a Array using a Object.clone */
		int[] a = {1, 2, 3, 4, 5};
		int[] b = a.clone();
		System.out.println("Using Object.clone() method copying original array " + Arrays.toString(a) + " to new one => " + Arrays.toString(b));

		/* Using Arrays.copyOf() method */
		int[] x = {4, 1, 3, 2};
		int[] y = Arrays.copyOf(x, x.length);
		System.out.println("Using Arrays.copyOf() method to copy original array " + Arrays.toString(x) + " to new one => " + Arrays.toString(y));
		/* NOTE : Arrays.copyOf also provides a overloaded version to change the type of array ex. Double[] z = Arrays.copyOf(x, x.length, Double[].class); */
		/* Another variant of this method is to provide range i.e int[] y = Arrays.copyOf(x, 0, 3); */

		/* Using System.ArrayCopy() method */
		/* Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array. */
		int[] z = new int[x.length];
		System.arraycopy(x, 0, z, 0, x.length);
		System.out.println("Using System.ArrayCopy() method to copy original array " + Arrays.toString(x) + " to new one => " + Arrays.toString(z));
	}

}
