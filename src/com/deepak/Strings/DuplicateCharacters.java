/**
 * Data-Structures-And-Algorithms-in-Java
 * DuplicateCharacters.java
 */
package com.deepak.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>Problem Statement</p>
 * <p> Given a string of characters consisting of 0 or more spaces, 
 * Find all the characters which are repeating? 
 * For example, if the input string is "Green Yellow Boots" 
 * then the output returned should be "e=3,l=2,o=3"
 * We will implement two solutions for it, one using data structures and another one without it</p>
 * 
 * @author Deepak
 */
public class DuplicateCharacters {

	public static void main(String[] args) {
		String inputString = "Green Yellow Boots";
		findDuplicateCharactersUsingAdditionalDataStructures(inputString);
		System.out.println();
		findDuplicateCharactersWithoutDataStructures(inputString);
	}

	/**
	 * Method to find duplicate characters in the input string using data structure
	 * <p> Let's note the complexity here. When we use data structures complexity is O(N)</p>
	 * <p> Algorithm : 
	 * 1. Convert the input string to a character array
	 * 2. Loop through it, and add the key, values in a map where key will be the character and value will be the count
	 * 3. For printing purpose, loop through the each of the entry map, and check if value is > 1
	 * 4. If value is greater then 1 and character is not a space, print it </p>
	 * 
	 * @param iInputString
	 */
	private static void findDuplicateCharactersUsingAdditionalDataStructures(String iInputString) {
		char[] charArray = iInputString.toCharArray();
		Map<Character, Integer> characterMap = new HashMap<>();
		for (Character character : charArray) {
			if (character != ' ') {
				characterMap.put(character, characterMap.get(character) != null ? characterMap.get(character) + 1 : 1);
			}
		}
		Set<Map.Entry<Character, Integer>> entrySet = characterMap.entrySet();
		System.out.println("List of duplicate characters in word using Data Structure => " + iInputString);
		for (Map.Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}

	/**
	 * Method to find duplicate characters in the input string without using any data structure
	 * <p> Without using a data structure, complexity of the program grows from O(N) to O(N^2),
	 * since we are using multiple loops here. One for loop and one while loop</p>
	 * <p> Algorithm : 
	 * 1. Initialize index as 0 and keep iterating until index < length of character array
	 * 2. Loop through the elements on the right of index value and compare each for the character holding index value
	 * 3. If matches, increase the count for that character. Also check if we have already evaluated that character. If yes, ignore it
	 * 4. If count > 1 and character is not white space, print it
	 * 5. Increase the value of index to move to next character and make count again 0 since this is a new character. </p>
	 * 
	 * @param iInputString
	 */
	private static void findDuplicateCharactersWithoutDataStructures(String iInputString) {
		System.out.println("List of duplicate characters in word without using Data Structure => " + iInputString);
		char[] charArray = iInputString.toCharArray();
		int index = 0;
		int count = 0;
		char selectedChar = ' ';
		String alreadyEvalueated = "";
		while (index < charArray.length) {
			for (int i = index; i < charArray.length; i++) {
				selectedChar = charArray[index];
				if (selectedChar == charArray[i] && !alreadyEvalueated.contains(String.valueOf(selectedChar))) {
					count++;
				}
			}
			if (count > 1 && selectedChar != ' ') {
				alreadyEvalueated = alreadyEvalueated + selectedChar;
				System.out.println(selectedChar + " : " + count);
			}
			index++;
			count = 0;
		}
	}

}
