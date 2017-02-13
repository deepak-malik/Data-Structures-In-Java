/**
 * Data-Structures-In-Java
 * BooleanUtils.java
 */
package com.deepak.data.structures.Utils;

/**
 * Utilities for Boolean
 * 
 * @author Deepak
 */
public class BooleanUtils {

	/**
	 * Method to negate a Boolean
	 * 
	 * @param bool
	 * @return {@link Boolean}
	 */
	public static Boolean negate(final Boolean bool) {
		if (bool == null) {
			return null;
		}
		return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
	}

	/**
	 * Method to check if boolean is True
	 * 
	 * @param bool
	 * @return {@link boolean}
	 */
	public static boolean isTrue(final boolean bool) {
		return Boolean.TRUE.equals(bool);
	}

	/**
	 * Method to check if boolean is false
	 * 
	 * @param bool
	 * @return {@link boolean}
	 */
	public static boolean isFalse(final boolean bool) {
		return Boolean.FALSE.equals(bool);
	}

	/**
	 * Method to convert Boolean object to boolean primitive
	 * 
	 * @param bool
	 * @return {@link boolean}
	 */
	public static boolean toBoolean(final Boolean bool) {
		return bool != null && bool.booleanValue();
	}

	/**
	 * Method to convert int to boolean
	 * 
	 * @param val
	 * @return {@link boolean}
	 */
	public static boolean toBoolean(final int val) {
		return val != 0;
	}

	/**
	 * Method to convert int to Boolean object
	 * 
	 * @param val
	 * @return {@link Boolean}
	 */
	public static Boolean toBooleanObject(final int val) {
		return val != 0 ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Method to compare two boolean values
	 * If both the same, it returns 0, if x is true, it returns 1
	 * else it returns -1
	 * 
	 * @param x
	 * @param y
	 * @return {@link int}
	 */
	public static int compare(final boolean x, final boolean y) {
		if (x == y) {
			return 0;
		}
		return x ? 1 : -1;
	}

}

