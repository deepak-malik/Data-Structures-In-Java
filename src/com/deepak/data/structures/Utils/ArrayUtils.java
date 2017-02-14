/**
 * Data-Structures-In-Java
 * ArrayUtils.java
 */
package com.deepak.data.structures.Utils;

import java.lang.reflect.Array;

/**
 * Utilities for Arrays
 * 
 * @author Deepak
 */
public class ArrayUtils {

	/**
	 * Method to check if a given array is empty 
	 * 
	 * @param array
	 * @return
	 */
	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * Method to convert array to string
	 * 
	 * @param array
	 * @return {@link String}
	 */
	public static String toString(String[] array) {
		return String.join(",", array);
	}

	/**
	 * Method to convert stream of items to array
	 * 
	 * @param items
	 * @return {@link T[]}
	 */
	@SafeVarargs
	public static <T> T[] toArray(final T... items) {
		return items;
	}

	/**
	 * Method to clone a array
	 * 
	 * @param array
	 * @return {@link T[]}
	 */
	public static <T> T[] clone(final T[] array) {
		if (array == null) {
			return null;
		}
		return array.clone();
	}

	/**
	 * Method to check if two arrays are of same length
	 * 
	 * @param array1
	 * @param array2
	 * @return {@link boolean}
	 */
	public static boolean isSameLength(final Object[] array1, final Object[] array2) {
		return getLength(array1) == getLength(array2);
	}

	/**
	 * Method to get length of the array
	 * 
	 * @param array
	 * @return {@link int}
	 */
	public static int getLength(final Object array) {
		if (array == null) {
			return 0;
		}
		return Array.getLength(array);
	}

	/**
	 * Method to check if two arrays are of same type
	 * 
	 * @param array1
	 * @param array2
	 * @return {@link boolean}
	 */
	public static boolean isSameType(final Object array1, final Object array2) {
		if (array1 == null || array2 == null) {
			throw new IllegalArgumentException("The Array must not be null");
		}
		return array1.getClass().getName().equals(array2.getClass().getName());
	}

	/**
	 * Method to do a binary search on int array
	 * 
	 * @param array
	 * @param size
	 * @param value
	 * @return {@link int}
	 */
	public static int binarySearch(int[] array, int size, int value) {
		int lo = 0;
		int hi = size - 1;
		while (lo <= hi) {
			final int mid = (lo + hi) >>> 1;
			final int midVal = array[mid];
			if (midVal < value) {
				lo = mid + 1;
			} else if (midVal > value) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return ~lo;
	}

}
