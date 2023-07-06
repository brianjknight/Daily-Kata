package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: BrokenStrings.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Broken Strings
 * Given a string s and an integer k, break up the string into multiple lines such 
 * that each line has a length of k or less. You must break it up so that words don't 
 * break across lines. Each line has to have the maximum possible amount of words. 
 * If there's no way to break the text up, then return empty list.
 * 
 * You can assume that there are no spaces at the ends of the string and that there 
 * is exactly one space between each word.
 * 
 * For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, 
 * you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. 
 * No string in the list has a length of more than 10.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 10, 2021
 * @updates:
 ****************************************************************************/
public class BrokenStrings {

	/**
	 * 
	 */
	public BrokenStrings() {
		super();
	}
	
	/**
	 * Slices the phrase into chunks no greater than k characters long
	 * @param phrase Phrase to slice
	 * @param k Max characters per slice
	 * @return Collection of sliced words
	 */
	public List<String> slice(String phrase, int k) {
		List<String> result = new ArrayList<>();
		
		if (phrase==null || phrase.isEmpty() || k < 1) {
			return result;
		}
		
		// Remove leading and trailing spaces
		String trimmed = phrase.trim();
		
		// Split the phrase into an array.
		String[] words = trimmed.split("\\s");
		
		// If the first word is longer than k return empty list otherwise start a new line to concatenate.
		if (words[0].length() > k) {
			return result;
		}
		String line = words[0];
		
		int curInd = 1;
		int nextInd = 1;
		
		// While their are words left append next words to line if it if less than k.
		while (curInd < words.length) {
			String nextWord = words[nextInd];
			// If any word is longer than k, return an empty List.
			if (nextWord.length() > k) {
				return new ArrayList<>();
			}
			// Append a space and the next word if it is less than k.
			else if (line.length() + 1 + nextWord.length() <= k) {
				line = line + " " + nextWord;
				if (nextInd == words.length -1) {
					result.add(line);
					break;
				}
				nextInd++;				
			}
			// Else add the current line to the result, advance the curIndex pointer, and start a new line. 
			else {
				result.add(line);
				curInd = nextInd;
				line = "";
			}
		}
		
		
		return result;
	}
}
