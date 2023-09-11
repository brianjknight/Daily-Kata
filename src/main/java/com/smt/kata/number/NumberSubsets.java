package com.smt.kata.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/****************************************************************************
 * <b>Title:</b> NumberSubsets.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Number Subsets
 * Given a multiset of integers, return whether it can be partitioned into two 
 * subsets whose sums are the same.
 * 
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, 
 * it would return true, since we can split it up into {15, 5, 10, 15, 10} and 
 * {20, 35}, which both add up to 55.
 * 
 * Given the multiset {15, 5, 20, 10, 35}, it would return false, since we 
 * can't split it up into two subsets that add up to the same sum.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class NumberSubsets {
	
	/**
	 * Method gets every possible combo and then adds the elements in the combos 
	 * to see if we have a match
	 * @param elements Elements to use to add the options
	 * @return True if there is a matching pattern.  False otherwise
	 */
	public boolean findMataches(int[] elements) {
		// null and empty check
		if(Objects.isNull(elements) || elements.length == 0) {
			return false;
		}
		
		// Sum all elements to see if it can be evenly divided
		int sum = Arrays.stream(elements).sum();
		
		// Divide sum by 2 to get the sub-total for each partition
		if (sum % 2 > 0) {
			return false;
		}
		int sub = sum / 2;
		
		// See if that sub-total can be reached from any combination of nums in the given array.
		
		
		
		// If yes do the remaining elements also equal the sub-total.
		
		
		
		
		
		return false;
	}
}
