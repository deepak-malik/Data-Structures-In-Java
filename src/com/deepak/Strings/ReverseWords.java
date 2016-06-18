/**
 * Data-Structures-And-Algorithms-in-Java
 * ReverseWords.java
 */
package com.deepak.Strings;

/**
 * <p>Problem Statement</p>
 * <p> Given a string, 
 * 1. Reverse the string word by word.
 * 2. Reverse each character of each word in the string 
 * Expected time and space complexity is O(n).
 * For example, if the input string is "This is a new String"
 * Output for 1st Scenario => String new a is This
 * Output for 2nd Scenario => sihT si a wen gnirtS</p>
 * 
 * @author Deepak
 */
public class ReverseWords {

	/**
	 * Method to start the flow of the program
	 * @param args
	 */
	public static void main(String[] args) {
		String inputString = "This is a new String";
		String reversedString = reverseWordsInAString(inputString);
		String reversedCharacters = reverseCharactersInEachWord(inputString);
		System.out.println("Actual String => " + inputString);
		System.out.println("String with reversed words => " + reversedString);
		System.out.println("String with each character as reversed => " + reversedCharacters);
	}

	/**
	 * Method to reverse characters of each word in a string
	 * <p> Algorithm :
	 * 1. Split the string based in white spaces. This will give Array holding each word of string
	 * 2. Loop through the arrays, take each word and convert it to charArray
	 * 3. Loop through the character array, find lowest index, and highest index
	 * 4. Each iteration, increase low by 1 and decrease high by 1
	 * 5. Keep swapping words until low < high </p>
	 * 
	 * @param iString
	 * @return {@link String}
	 */
	private static String reverseCharactersInEachWord(String iString) {
		String[] strArray = iString.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			char[] charArray = strArray[i].toCharArray();
			int iLowestIndex = 0;
			int iHighestIndex = charArray.length - 1;
			while (iLowestIndex < iHighestIndex) {
				swap(charArray, iLowestIndex, iHighestIndex);
				iLowestIndex++;
				iHighestIndex--;
			}
			strArray[i] = new String(charArray);
		}
		return String.join(", ", strArray).replace(",", "");
	}

	/**
	 * Method to reverse words in a string
	 * <p> Algorithm :
	 * 1. Split the string based in white spaces. This will give Array holding each word of string
	 * 2. Find lowest index, and highest index
	 * 3. Each iteration, increase low by 1 and decrease high by 1
	 * 4. Keep swapping words until low < high </p>
	 * 
	 * @param iString 
	 * @return {@link String}
	 */
	private static String reverseWordsInAString(String iString) {
		String[] strArray = iString.split(" ");
		int arrayLength = strArray.length;
		int lowestIndex = 0;
		int highestIndex = arrayLength -1;
		while (lowestIndex < highestIndex) {
			swap(strArray, lowestIndex, highestIndex);
			lowestIndex++;
			highestIndex--;
		}
		return String.join(", ", strArray).replace(",", "");
	}

	/**
	 * Method to swap items in string Array
	 * @param iStringArray
	 * @param iLowestIndex
	 * @param iHighestIndex
	 */
	private static void swap(String[] iStringArray, int iLowestIndex, int iHighestIndex) {
		String tempVariable = iStringArray[iLowestIndex];
		iStringArray[iLowestIndex] = iStringArray[iHighestIndex];
		iStringArray[iHighestIndex] = tempVariable;
	}

	/**
	 * Method to swap items in character Array
	 * @param iCharArray
	 * @param iLowestIndex
	 * @param iHighestIndex
	 */
	private static void swap(char[] iCharArray, int iLowestIndex, int iHighestIndex) {
		char tempVariable = iCharArray[iLowestIndex];
		iCharArray[iLowestIndex] = iCharArray[iHighestIndex];
		iCharArray[iHighestIndex] = tempVariable;
	}

}
