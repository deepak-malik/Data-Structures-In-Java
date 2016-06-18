/**
 * Data-Structures-And-Algorithms-in-Java
 * RemoveSpaces.java
 */
package com.deepak.Strings;

import java.util.Arrays;

/**
 * <p>Problem Statement</p>
 * <p> Given a string of characters consisting of 0 or more spaces, 
 * remove all the spaces from this given string. 
 * Separation of spaces from other characters should be done in-place(without using extra space).
 * Expected time and space complexity is O(n).
 * For example, if the input string is "  Hi, How are you?  " 
 * then the output returned should be "Hi,Howareyou?"</p>
 * 
 * @author Deepak
 */
public class RemoveSpaces {

	/**
	 * Method to start the flow of the program
	 * @param args
	 */
	public static void main(String[] args) {
		String strWithSpaces = "  Hey, How are you doing?? ";
		String strWithOutSpacesUsingON2 = removeSpacesWithON2(strWithSpaces);
		String strWithoutSpacesUsingON = removeSpacesWithON(strWithSpaces);
		System.out.println("Actual String => " + strWithSpaces);
		System.out.println("String after removing spaces with O(N^2) complexity => " + strWithOutSpacesUsingON2);
		System.out.println("String after removing spaces with O(N) complexity => " + strWithoutSpacesUsingON);
	}

	/**
	 * Method to remove spaces with O(n^2) complexity [Not recommended]
	 * <p> Algorithm :
	 * 1. Convert the entire string to char Array 
	 * 2. Loop through it and search for white space
	 * 3. If found, loop through the array on right side
	 * 4. Shift each element to left and decrease the array size by 1
	 * 5. Repeat step 2-4 until all the white spaces are removed</p>
	 * 
	 * @param strWithSpaces
	 * @return {@link String}
	 */
	private static String removeSpacesWithON2(String strWithSpaces) {
		char[] strToCharArray = strWithSpaces.toCharArray();
		int charArraySize = strToCharArray.length;
		for (int i = 0; i < charArraySize; i++) {
			if (strToCharArray[i] == ' ') {
				for (int j = i; j < charArraySize - 1; j++) {
					strToCharArray[j] = strToCharArray[j+1];
				}
				charArraySize--;
			}
		}
		return new String(strToCharArray);
	}
	
	/**
	 * Method to remove spaces with O(n) complexity [Recommended]
	 * <p> Algorithm :
	 * 1. Convert the entire string to char Array 
	 * 2. Declare a integer "numSpacesBeforeIthChar" with initial value as 0. This will hold number of spaces before i'th character. 
	 * 2. Loop through the char array and search for white space
	 * 3. If found, increase the count of numSpacesBeforeIthChar
	 * 4. else, move the position of current element to left
	 * 5. Once iteration is done, all white spaces will go to right
	 * 6. Remove those white spaces. New array length will be (Actual length - Number of spaces)</p>
	 * 
	 * @param strWithSpaces
	 * @return {@link String}
	 */
	private static String removeSpacesWithON(String strWithSpaces) {
		char[] strToCharArray = strWithSpaces.toCharArray();
		int charArraySize = strToCharArray.length;
		int numSpacesBeforeIthChar = 0;
		for (int i = 0; i < charArraySize; i++) {
			if (strToCharArray[i] == ' ') {
				numSpacesBeforeIthChar += 1;
			} else {
				strToCharArray[i - numSpacesBeforeIthChar] = strToCharArray[i];
			}
		}
		strToCharArray = Arrays.copyOf(strToCharArray, charArraySize - numSpacesBeforeIthChar);
		return new String(strToCharArray);
	}

}
