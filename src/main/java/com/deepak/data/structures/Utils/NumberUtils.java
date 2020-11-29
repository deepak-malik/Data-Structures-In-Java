/**
 * Data-Structures-In-Java
 * NumberUtils.java
 */
package com.deepak.data.structures.Utils;

/**
 * Utilities for Numbers
 * Note : All of these methods are for integers only,
 * All others like, Double, float etc will have same implementation
 * 
 * @author Deepak
 */
public class NumberUtils {

	/**
	 * Method to convert string to Integer
	 * 
	 * @param str
	 * @return {@link int}
	 */
	public static int toInt(final String str) {
		return toInt(str, 0);
	}

	/**
	 * Method to convert string to Integer when a default value is given
	 * 
	 * @param str
	 * @param defaultValue
	 * @return {@link int}
	 */
	public static int toInt(final String str, int defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(str);
		} catch (final NumberFormatException exception) {
			return defaultValue;
		}
	}

	/**
	 * Method to check if string has all zeros
	 * 
	 * @param str
	 * @return {@link boolean}
	 */
	public static boolean isAllZeros(final String str) {
		if (str == null) {
			return true;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0') {
				return false;
			}
		}
		return str.length() > 0;
	}

	/**
	 * Find minimum out of Integer array
	 * 
	 * @param array
	 * @return {@link int}
	 */
	public static int min(final int... array) {
		if (array == null) {
			return 0;
		}
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	/**
	 * Find maximum out of Integer array
	 * 
	 * @param array
	 * @return {@link int}
	 */
	public static int max(final int... array) {
		if (array == null) {
			return 0;
		}
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

}
