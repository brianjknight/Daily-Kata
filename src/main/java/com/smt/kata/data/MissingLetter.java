package com.smt.kata.data;

/****************************************************************************
 * <b>Title</b>: MissingLetter.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Create a method that takes an array of increasing letters 
 * and return the missing letter.  Tests will always have exactly one letter missing.
 * The length of the test array will always be at least two.
 * Tests will be in one particular case (upper or lower but never both).
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class MissingLetter {

	/**
	 * 
	 */
	public MissingLetter() {
		super();
	}
	
	/**
	 * loops through the String[] and checks the current item to the previous
	 * @param chars
	 * @return
	 */
	public char missingLetter(String[] chars) {
		
		// null and empty input check
		if (chars == null || chars.length == 0) {
			return '*';
		}
		
		// get the first character
		char cur = chars[0].charAt(0);
		
		// If the next character is not one more than the previous, return the previous plus 1.
		for (int i=1; i<chars.length; i++) {
			char next = chars[i].charAt(0);
			if(cur + 1 != next) {
				return ++cur;
			}
			else {
				cur = next;
			}
		}
		
		return '*';
	}

}
