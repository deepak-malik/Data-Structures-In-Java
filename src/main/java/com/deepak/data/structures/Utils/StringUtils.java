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
		/* String is empty is it is null or length is 0 */
		return cs == null || cs.length() == 0;
	}

	/**
	 * Method to check if any string is empty in an array of strings
	 * 
	 * @param css
	 * @return {@link boolean}
	 */
	public static boolean isAnyEmpty(final CharSequence... css) {
		/* Input has to be array */
		if (ArrayUtils.isEmpty(css)) {
			return false;
		}
		/* Check for each character */
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
		/* If string is null or length is 0 */
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		/* There should not be any white space character */
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
		/* Input has to be array */
		if (ArrayUtils.isEmpty(css)) {
			return true;
		}
		/* Check for each character, if it is blank */
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
		/* If string is null, return null else trim */
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
		return truncate(str, 0, maxWidth);
	}

	/**
	 * Method to truncate the string when max width 
	 * and offset is given
	 * 
	 * @param str
	 * @param offset
	 * @param maxWidth
	 * @return {@link String}
	 */
	public static String truncate(final String str, final int offset, final int maxWidth) {
		/* Offset and max width can't be less then 0 */
		if (offset < 0) {
			throw new IllegalArgumentException("offset cannot be negative");
		}
		if (maxWidth < 0) {
			throw new IllegalArgumentException("maxWidth cannot be negative");
		}
		/* If string is null, return null */
		if (str == null) {
			return null;
		}
		/* If offset is greater then list length, return empty string */
		if (offset > str.length()) {
			return "";
		}
		/* If valid scenario, find where we have to stop */
		if (str.length() > maxWidth) {
			final int ix = offset + maxWidth > str.length() ? str.length() : offset + maxWidth;
			return str.substring(offset, ix);
		}
		return str.substring(offset);
	}

	/**
	 * Method to check if two strings are equal
	 * 
	 * @param cs1
	 * @param cs2
	 * @return {@link boolean}
	 */
	public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
		/* If there reference is same, they are equal */
		if (cs1 == cs2) {
			return true;
		}
		/* If any one of them is null, they can't be equal */
		if (cs1 == null || cs2 == null) {
			return false;
		}
		/* If there lengths are different, they can't be equal */
		if (cs1.length() != cs2.length()) {
			return false;
		}
		/* Now, both of them has to be string and equal in value */
		if (cs1 instanceof String && cs2 instanceof String) {
			return cs1.equals(cs2);
		}
		return false;
	}

	/**
	 * Method to check if two strings are equal when cases are ignored
	 * 
	 * @param str1
	 * @param str2
	 * @return {@link boolean}
	 */
	public static boolean equalsIgnoreCase(final CharSequence str1, final CharSequence str2) {
		String updatedStr1 = String.valueOf(str1).toLowerCase();
		String updatedStr2 = String.valueOf(str2).toLowerCase();
		return equals(updatedStr1, updatedStr2);
	}

	/**
	 * Method to compare two strings
	 * 
	 * @param str1
	 * @param str2
	 * @return {@link int}
	 */
	public static int compare(final String str1, final String str2) {
		return compare(str1, str2, true);
	}

	/**
	 * Method to compare two strings when null has to be considered or not
	 * 
	 * @param str1
	 * @param str2
	 * @param shouldConsiderNull
	 * @return {@link int}
	 */
	public static int compare(final String str1, final String str2, final boolean shouldConsiderNull) {
		/* If both are same, return 0 */
		if (str1 == str2) {
			return 0;
		}
		/* If str1 is less, return < 0 */
		if (str1 == null) {
			return shouldConsiderNull ? -1 : 1;
		}
		/* If str2 is less, return > 0 */
		if (str2 == null) {
			return shouldConsiderNull ? 1 : -1;
		}
		return str1.compareTo(str2);
	}

	/**
	 * Method to find the index of first occurrence of character in a string
	 * 
	 * @param seq
	 * @param searchChar
	 * @return {@link int}
	 */
	public static int indexOf(final CharSequence seq, final int searchChar) {
		return indexOf(seq, searchChar, 0);
	}

	/**
	 * Method to find the index of a character after a given position
	 * 
	 * @param seq
	 * @param searchChar
	 * @param startPos
	 * @return {@link int}
	 */
	public static int indexOf(final CharSequence seq, final int searchChar, final int startPos) {
		if (isEmpty(seq)) {
			throw new IllegalArgumentException("Invalid character sequence!");
		}
		if (startPos < seq.length()) {
			for (int i = startPos; i < seq.length(); i++) {
				/* If a negative start position is given, keep jumping until you reach 0 */
				if (i < 0) continue;
				if (seq.charAt(i) == searchChar) {
					return i;
				}
			}
		}
		return -1;
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
