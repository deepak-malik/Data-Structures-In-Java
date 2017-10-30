/**
 * Data-Structures-In-Java
 * CustomStringBuilder.java
 */
package com.deepak.data.structures.Strings;

import java.util.Arrays;

/**
 * Custom implementation of StringBuilder
 * 
 * @author Deepak
 */
public class CustomStringBuilder {

	/**
	 * Character array to store our buffer
	 */
	private char[] characterBuffer;

	/**
	 * Current index till where buffer is full
	 */
	private int curIndex;

	/**
	 * Default capacity of the string builder
	 */
	private int DEFAULT_CAPACITY = 10;

	/**
	 * Default Constructor
	 */
	public CustomStringBuilder() {
		characterBuffer = new char[DEFAULT_CAPACITY];
		curIndex = 0;
	}

	/**
	 * Method to append a given string to another string
	 * 
	 * @param input
	 */
	public void append(String input) {
		if (input != null) {
			char[] charArray = input.toCharArray();
			/* Using while loop here because of below use case, 
			 * 1. Initial character buffer initialized with size 10
			 * 2. Input string came of size 25
			 * 3. We need to check for overflow 2 times now because size will be increased by 10 only in one time */
			while (overflow(charArray.length)) {
				ensureCapacity();
			}
			for (int i = 0; i < charArray.length; i++) {
				characterBuffer[curIndex++] = charArray[i];
			}
		}
	}

	/**
	 * Method to print the content 
	 */
	public String toString() {
		return new String(characterBuffer, 0, curIndex);
	}

	/**
	 * Method to ensure capacity when we reach the threshold
	 */
	private void ensureCapacity() {
		characterBuffer = Arrays.copyOf(characterBuffer, characterBuffer.length * 2);
	}

	/**
	 * Method to check if our character buffer will overflow 
	 * when a new text is appended
	 * 
	 * @param length
	 * @return {@link boolean}
	 */
	private boolean overflow(int length) {
		return (length + curIndex) > characterBuffer.length;
	}

}
