/**
 * Data-Structures-And-Algorithms-in-Java
 * CharactersPresent.java
 */
package com.deepak.Strings;

/**
 * <p>Problem Statement</p>
 * <p> print all the characters present in the given string only once in a reverse order. 
 * Time & Space complexity should not be more than O(N). 
 * e.g. Given a string aabdceaaabbbcd 
 *	the output should be - dcbae </p>
 * 
 * @author Deepak
 */
public class CharactersPresent {

	/**
	 * Method to start the flow of the program
	 * @param args
	 */
	public static void main(String[] args) {
		String inputString = "aabdceaaabbbcd";
		System.out.println("Input String => " + inputString);
		printCharactersInReverseOrder(inputString);
	}

	/**
	 * Method to print characters in reverse order only once
	 * <p> Algorithm : 
	 * 1. Convert the input string into character array
	 * 2. Loop through character array in reverse order and check if each character is evaluated earlier
	 * 3. If evaluated earlier, skip it else append the output string </p>
	 * 
	 * @param iInputString
	 */
	private static void printCharactersInReverseOrder(String iInputString) {
		char[] charArray = iInputString.toCharArray();
		String alreadyEvaluatedCharacters = "";
		for (int i = charArray.length - 1; i >= 0; i--) {
			if (!alreadyEvaluatedCharacters.contains(String.valueOf(charArray[i]))) {
				alreadyEvaluatedCharacters = alreadyEvaluatedCharacters + charArray[i];
			}
		}
		System.out.println("String in Reverse Order with characters printed only once => " + alreadyEvaluatedCharacters);
	}

}
