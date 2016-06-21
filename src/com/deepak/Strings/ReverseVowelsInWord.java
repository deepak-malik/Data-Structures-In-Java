/**
 * Data-Structures-And-Algorithms-in-Java
 * ReverseVowelsInWord.java
 */
package com.deepak.Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>Problem Statement</p>
 * <p> Given a word of characters consisting of 0 or more vowels, 
 * swap all the vowels from this given word. 
 * For example, if the input string is "Deepak" 
 * then the output returned should be "Daepek"</p>
 * 
 * @author Deepak
 */
public class ReverseVowelsInWord {

	/**
	 * Method to start the flow of the program
	 * @param args
	 */
	public static void main(String[] args) {
		String wordToBeUpdated = "Deepak";
		String output = reverseVowels(wordToBeUpdated);
		System.out.println("Actual Word => " + wordToBeUpdated);
		System.out.println("Word after swapping Vowels => " + output);
	}

	/**
	 * Method to reverse vowels in a word
	 * <p> Algorithm :
	 * 1. Define a ArrayList which contains vowels. Remember to include both lower case and upper case
	 * 2. Convert the given word to char Array. Find lowest index and highest index
	 * 3. Loop through the character array, until lowest index < highest index
	 * 4. Each iteration, check each of the characters starting from both lowest index and highest index
	 * 5. Once a vowel is found at both the positions, swap them  
	 * 5. Increase low by 1 and decrease high by 1 </p>
	 * 
	 * @param iInputString 
	 * @return {@link String}
	 */
	public static String reverseVowels(String iInputString) {
		ArrayList<Character> vowels = new ArrayList<>();
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		char[] charArray = iInputString.toCharArray();
		int lowestIndex = 0;
		int highestIndex = charArray.length - 1;
		while(lowestIndex < highestIndex) {
			if (!vowels.contains(charArray[lowestIndex])) {
				lowestIndex++;
				continue;
			}
			if (!vowels.contains(charArray[highestIndex])) {
				highestIndex--;
				continue;
			}
			char temp = charArray[lowestIndex];
			charArray[lowestIndex] = charArray[highestIndex];
			charArray[highestIndex] = temp;
			lowestIndex++;
			highestIndex--;
		}
		return Arrays.toString(charArray).replace(", ", "").replace("[", "").replace("]", "");
	}

}
