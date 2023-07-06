package com.smt.kata.word;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/****************************************************************************
 * <b>Title</b>: DeletingLetters.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Word in Dictionary through Deleting
 * 
 * Given a string s and a string array dictionary, return the longest string in the 
 * dictionary that can be formed by deleting some of the given string characters. If 
 * there is more than one possible result, return the longest word with the smallest 
 * lexicographical order. If there is no possible result, return the empty string.
 * 
 * Example 1:
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * 
 * Example 2:
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 17, 2021
 * @updates:
 ****************************************************************************/
public class DeletingLetters {

	/**
	 * Finds the longest word in the dictionary that can be created by removing 
	 * letters from the source in order
	 * @param source Source string to search
	 * @param dictionary Words to find a match
	 * @return Longest match.  Empty if no matches
	 */
	public String findLongest(String source, String[] dictionary) {
		if (Objects.isNull(source) || Objects.isNull(dictionary) || dictionary.length < 1 || source.equals("")) {
			return "";
		}
	
		// Below sorting resulted in null pointer exception when a null item is in the dictionary array.
		// Although adding to time complexity a work around is to replace null values with an empty string.
		for (int i=0; i<dictionary.length; i++) {
			if(dictionary[i] == null) {
				dictionary[i] = "";
			}
		}
		
		// Sort lexicographically first.
		Arrays.sort(dictionary);
		
		// Then sort descending by string length.
		Arrays.sort(dictionary, Collections.reverseOrder(Comparator.comparing(String::length)));
		
		// Map the source string to each letter and count of its occurrences.
		Map<Character, Integer> sourceMap = mapWord(source);
		
		// Loop the dictionary to determine if the word can be formed from the letters in the source string.
		for (String word : dictionary) {
				
			// Map the current word for letter count.
			Map<Character, Integer> wordMap = mapWord(word);
			
			// For each letter in the current word, check if the source word/map contains enough letters to spell 				
			for (int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				
				// If the source word does not contain a letter or enough letters to spell the dictionary word, the word cannot be spelled.
				if (!sourceMap.containsKey(c) || sourceMap.get(c) < wordMap.get(c)) {
					break;
				}
				
				// If the loop has not been broken after iterating to the last letter, it means that word can be spelled from the source. Return the word.
				if (i==word.length()-1 && word.length() < source.length()) {
					return word;
				}
			}
		}
			
		// If no word is found return an empty string.
		return "";
	}
	
	// Helper method to map letters to number of occurrences in a word.
	private Map<Character, Integer> mapWord(String input){
		Map<Character, Integer> result = new HashMap<>();
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			if (!result.containsKey(c)) {
				result.put(c,1);
			}
			else {
				result.put(c, result.get(c) + 1);
			}
		}
		
		return result;		
	}
}
