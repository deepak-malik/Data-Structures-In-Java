/**
 * Data-Structures-In-Java
 * StringUtils.java
 */
package com.deepak.data.structures.Utils;

/**
 * Utilities for String class
 * 
 * @author Deepak
 */
public class StringUtils {

	/**
	 * Method to check if string is empty
	 * 
	 * @param cs
	 * @return {@link boolean}
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 * Method to check if any string is empty in an array of strings
	 * 
	 * @param css
	 * @return {@link boolean}
	 */
	public static boolean isAnyEmpty(final CharSequence... css) {
		if (ArrayUtils.isEmpty(css)) {
			return false;
		}
		for (CharSequence cs : css) {
			if (isEmpty(cs)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to check if a string is blank
	 * Checks if a CharSequence is empty (""), null or whitespace only.
	 * 
	 * @param cs
	 * @return {@link boolean}
	 */
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method to check if any string blank
	 * 
	 * @param css
	 * @return {@link boolean}
	 */
	public static boolean isAnyBlank(final CharSequence... css) {
		if (ArrayUtils.isEmpty(css)) {
			return true;
		}
		for (CharSequence cs : css) {
			if (isBlank(cs)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to trim the white spaces in a string
	 * 
	 * @param str
	 * @return {@link String}
	 */
	public static String trim(final String str) {
		return str == null ? null : str.trim();
	}

	/**
	 * Method to truncate the string when max width is given
	 * 
	 * @param str
	 * @param maxWidth
	 * @return {@link String}
	 */
	public static String truncate(final String str, final int maxWidth) {
		return str;
	}

	public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
		return false;
	}

	public static boolean equalsIgnoreCase(final CharSequence str1, final CharSequence str2) {
		return false;
	}

	public static int compare(final String str1, final String str2) {
		return 0;
	}

	public static int indexOf(final CharSequence seq, final int searchChar) {

		return 0;
	}

	public static int indexOf(final CharSequence seq, final int searchChar, final int startPos) {
		return 0;
	}

	public static int lastIndexOf(final CharSequence seq, final int searchChar) {
		return 1;
	}

	public static boolean contains(final CharSequence seq, final int searchChar) {
		return false;
	}

	public static String substring(final String str, int start) {
		return str;
	}

	public static String left(final String str, final int len) {
		return str;
	}

	public static String right(final String str, final int len) {
		return str;
	}

	public static String mid(final String str, int pos, final int len) {
		return str;
	}

	public static String[] split(final String str, final char separatorChar) {
		return null;
	}

	public static String join(final Object[] array, final char separator) {
		return null;
	}

	public static String remove(final String str, final String remove) {
		return null;
	}

	public static String upperCase(final String str) {
		return null;
	}

	public static String lowerCase(final String str) {
		return null;
	}

	public static int countMatches(final CharSequence str, final CharSequence sub) {
		return 0;
	}

	public static boolean isAlpha(final CharSequence cs) {
		return false;
	}

	public static boolean isAlphaNumeric(final CharSequence cs) {
		return false;
	}

	public static boolean isNumeric(final CharSequence cs) {
		return false;
	}

}
