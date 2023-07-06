package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: OrderPlease.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Order Please Kata
 * 
 * Our task is to sort a given string. Each word in the string will contain a 
 * single number. This number is the position the word should have in the result.
 * 
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * 
 * If the input string is empty, return an empty string. The words in the input
 * String will only contain valid consecutive numbers.
 * If a word does not have a number, default it to 0
 * 
 * For Example:
 * Input: "is2 Thi1s T4est 3a"
 * Output: "Thi1s is2 3a T4est"
 * 
 * Input: "We1 1the p1eople i1n o1rder t1o 1form 1a 1more 1perfect 1union"
 * Output: "We1 1the p1eople i1n o1rder t1o 1form 1a 1more 1perfect 1union"
 * 
 * Input: "4of Fo1r pe6ople g3ood th5e the2"
 * Output: "Fo1r the2 g3ood 4of th5e pe6ople"
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class OrderPlease {
	public String reorder(String phrase) {
		
		if (phrase == null || phrase.isEmpty()) {
			return "";
		}
		
		// Split phrase into an array.
		String[] input = phrase.split(" ");
		
		// Create new array of equal length.
		String[] ordered = new String[input.length];
		
		// Index location
		int index = 0;
		
		// Iterate the input array to first add words with no digits.
		for (String s : input) {
			if(!s.matches("\\d+")) {
				ordered[index] = s;
				index++;
			}
		}
		
		// For each word in input that does contain digits: 
		for (String s : input) {
			// Find the digit in the word
			for (int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if (Character.isDigit(c)) {
					// Insert the word into the ordered array and index location.
					int ind = Character.getNumericValue(c) + index - 1;
					ordered[ind] = s;
					break;
				}
			}
			
		}
		
		// Concatenate the ordered array and return the ordered string.
		String result = "";
		
		for (String s : ordered) {
			result += s + " ";
		}
		
		// Return result removing trailing space.
        return result.trim();
    }
}
