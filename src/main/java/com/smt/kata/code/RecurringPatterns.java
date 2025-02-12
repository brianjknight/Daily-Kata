package com.smt.kata.code;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/****************************************************************************
 * <b>Title</b>: RecurringPatterns.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Recurring Patterns Kata
 * 
 * Given a string and a pattern, find the starting indices of all occurrences of 
 * the pattern in the string. For example, given the string "abracadabra" and 
 * the pattern "abr", you should return [0, 7]
 * 
 * Any spaces in the word or the should be ignored
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 10, 2021
 * @updates:
 ****************************************************************************/
public class RecurringPatterns {

	/**
	 * Gets the number of occurrences of a pattern in a word
	 * @param pattern Pattern to evaluate
	 * @param word word to search against
	 * @return starting location of all patterms
	 */
	public List<Integer> count(String word, String pattern) {
		List<Integer> result = new ArrayList<>(); 
		
		// Null and empty check.
		if (Objects.isNull(word) || Objects.isNull(pattern) || word.isEmpty() || pattern.isEmpty()) {
			return result;
		}
		
		// Remove all spaces.
		word = word.replaceAll(" ", "");
		
		// find the index of the pattern in word
		int index = word.indexOf(pattern);
		
		// While loop to continue finding pattern matches.
		while (index != -1) {
			result.add(index);
			index = word.indexOf(pattern,++index);
		}
		
		return result;
	}

}
