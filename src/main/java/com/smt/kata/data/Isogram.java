package com.smt.kata.data;

import java.util.Objects;

/****************************************************************************
 * <b>Title</b>: Isogram.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Isograms
 *
 * Determine if a word or phrase is an isogram.
 * 
 * Use the Unit Test to determine the rules for an Isogram
 * 
 * You MAY not use collections or anything other than primitives and Strings for this exercise
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 17, 2021
 * @updates:
 ****************************************************************************/
public class Isogram {

	/**
	 * Validates whether or not the phrase is an isogram
	 * @param phrase Phrase to check against the Isogram rules
	 * @return true if an isogram.  False if empty or not an isogram
	 */
	public boolean isValidIsogram(String phrase) {
        if (Objects.isNull(phrase) || phrase.isEmpty()) {
        	return false;
        }
		
		String lower = phrase.toLowerCase();
		String word = "";
		
		// loop the input phrase adding each character to a new string.
		for (int i=0; i<lower.length(); i++) {
			char c = lower.charAt(i);
			
			//ignore spaces and dashes
			if (c == ' ' || c == '-') continue;
			
			// Return false if the word already contains the character.
			if (word.indexOf(c) >= 0) return false;
			
			word += c;
			System.out.println(word);
		}
		 
        return true;
    }
}
