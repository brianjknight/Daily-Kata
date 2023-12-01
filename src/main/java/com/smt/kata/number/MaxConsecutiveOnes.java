package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: MaxConsecutiveOnes.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Max Consecutive Ones
 * 
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * 
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * 
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * 
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 25, 2021
 * @updates:
 ****************************************************************************/
public class MaxConsecutiveOnes {

	/**
	 * Finds and counts the longest sequence of 1s int he array
	 * @param values Array to count
	 * @return Count of the largest sequence of ones
	 */
	public int count(int[] values) {
		// null & empty check
		int longest = 0;
		if (values == null || values.length == 0) {
			return longest;
		}
		
		// Use a nested loop. Starting from each index count the consecutive ones.
		for (int i=0; i<values.length; i++) {
			int count = 0;
			for (int j=i; j<values.length; j++) {
				if (values[j]==0) {break;}
				if (values[j] == 1) {
					count++;
				}
				// if number of consecutive ones is greater than max update max.
				if (count > longest) {
					longest = count;
				}
			}
		}
		
		return longest;
	}

}
