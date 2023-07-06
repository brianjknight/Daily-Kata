package com.smt.kata.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MatchstickToSquare.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Match Stick to Square Kata
 * 
 * You are given an integer array matchsticks where matchsticks[i] is the length 
 * of the ith matchstick. You want to use all the matchsticks to make one square. 
 * You should not break any stick, but you can link them up, and each matchstick 
 * must be used exactly one time.
 * 
 * Return true if you can make this square and false otherwise.
 * 
 * Example 1:
 * https://assets.leetcode.com/uploads/2021/04/09/matchsticks1-grid.jpg
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * 
 * Example 2:
 * Input: matchsticks = [3,3,3,3,4]
 * Output: false
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class MatchstickToSquare {

	/**
	 * Determines if the match sticks can form a square
	 * @param matchsticks Match sticks to evaluate
	 * @return True if they form a square, false otherwise
	 */
	public boolean canFormSquare(int[] matchsticks) {
				
		// Find the perimeter length of the square by adding all match stick lengths.
		int perimeter = 0;
		List<Integer> list = new ArrayList<>();
		
		
		for (int i : matchsticks) {
			perimeter += i;
			list.add(i);
		}
		
		// If the perimeter length is not divisible by 4, then a square cannot be made. Return false.
		if (perimeter % 4 > 0 ) {return false;}
		
		// Else divide perimeter by 4 to find the length of a side.
		int side = perimeter / 4;
		
		// Determine if 4 equal sides can be made using ALL of the given match sticks.
		
		// Sort the match sticks by length.
		Collections.sort(list, Collections.reverseOrder());
		
		int numSides = 0;
		
		for (int i=0; i<list.size(); i++) {
			// Start with the longest available match stick. 
			int stick = list.get(i);
						
			// If it is longer than the side length you cannot form a square. Return false.
			if (stick > side) {
				return false;
			}
			
			// If it equals the side length, remove the match stick from the pile and increment number of sides.
			if (stick == side) {
				numSides++;
				list.remove(i);
			}
			
			// If it is less than the side length, see if you can add matches from the remaining pile to equal the side length.
			
				// If no a square cannot be formed. Return false.

				// If yes, remove the match or matches from the pile and increment the side. 
	
		}
		// return true if the number of sides formed is 4 and there are no matches remaining in the pile.
		
			
		
		return true;
	}

}
