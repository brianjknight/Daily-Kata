package com.smt.kata.word;

import java.util.Objects;

/****************************************************************************
 * <b>Title</b>: Palindrome.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> This program does not use any API method instead it uses 
 * division and remainder operator of Java programming language to determine if 
 * number is palindrome or not.  No Strings, StringBuilders, or Collections are allowed.  
 * Arrays are not to be used in the calculation of the palindrome (only as source for the output)
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class Palindrome {

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	public boolean isPalindrome(int startNumber){
		// check for negative number
		startNumber = startNumber < 0 ? -startNumber : startNumber;
		
		int num = startNumber;
		int reversed = 0;
				
		while (num > 0) {
			// Get the last digit.
			int lastDigit = num % 10;

			// Remove with the last digit while digits are left
			num /= 10;
			
			// add the last digit to the reversed num
			reversed = reversed * 10 + lastDigit;

		}
		
		return startNumber == reversed;
	}

}
