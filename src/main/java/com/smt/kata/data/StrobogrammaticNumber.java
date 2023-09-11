package com.smt.kata.data;

/****************************************************************************
 * <b>Title</b>: StrobogrammaticNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Strobogrammatic Number Kata
 * 
 * A strobogrammatic number is a positive number that appears the same after 
 * being rotated 180 degrees. For example, 16891 is strobogrammatic.
 * 
 * Create a program that finds all strobogrammatic numbers with N digits.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 22, 2022
 * @updates:
 ****************************************************************************/
public class StrobogrammaticNumber {
	
	/**
	 * Determines if a number is strobomatic
	 * @param source Number to evaluate
	 * @return True if stobomatic.  False otherwise
	 */
	public boolean isStrobogrammaticNumber(int source) {
		
		//Convert to string
		String numString = String.valueOf(source);
		
		//Iterate characters comparing front to back positions
		for (int i=0; i< numString.length()/2; i++) {
			char a = numString.charAt(i);
			char b = numString.charAt(numString.length()-1-i);
			
			// check for strobogrammatic digits
			if (
				(a=='0' && b!='0' || b=='0' && a!='0') || 
				(a=='1' && b!='1' || b=='1' && a!='1') || 
				(a=='8' && b!='8' || b=='8' && a!='8') ||
				(a=='6' && b!='9' || b=='6' && a!='9') ||
				(a=='9' && b!='6' || b=='9' && a!='6')
				) {
				return false;
			}
		}
		
		return true;
	}

}
