/**
 * Data-Structures-In-Java
 * ArrayUtils.java
 */
package com.deepak.data.structures.Utils;

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
		return false; // TODO
	}

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
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
	}

}
