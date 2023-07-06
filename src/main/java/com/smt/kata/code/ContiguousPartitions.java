package com.smt.kata.code;

import java.util.Arrays;



/****************************************************************************
 * <b>Title</b>: ContiguousPartitions.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Contiguous Partitions Kata
 * 
 * Given a list of strictly positive integers, partition the list into 3 contiguous 
 * partitions which each sum up to the same value. If not possible, return empty int[][].
 * 
 * For example, given the following list:
 * 
 * [3, 5, 8, 1, 7]
 * Return the following 3 partitions:
 * 
 * [[3, 5],
 *  [8],
 *  [1, 7]]
 *  
 * Which each add up to 8.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2022
 * @updates:
 ****************************************************************************/
public class ContiguousPartitions {

	/**
	 * partitions the array into 3 sub arrays where the sun of each array is equal
	 * @param values Array to partition
	 * @return 3 partitions of equal values.  Emoty array if none found
	 */
	public int[][] find(int[] values) {
		int[][] solution = new int[3][];
		
		// Null and 0 length check for input
		// Check is sum of input is divisible into 3 partitions.
		if (values == null || values.length == 0 || Arrays.stream(values).sum() % 3 != 0) {
			return new int[0][];
		}
				
		// Sum the values and divide by 3 to find the sum of each partition.
		int arraySum = Arrays.stream(values).sum();
				
		// Sum for each individual partition.
		int partitionSum = arraySum / 3;
		
		int currSum = 0;
		int valueIndex  = 0;
		int solutionIndex = 0;
				
		// Iterate values to find consecutive elements that add up to partition sum.
		for (int i = 0; i < values.length; i++) {
			int num = values[i];

			// if adding the current numbers is greater than the partition total, a solution is no not possible.
			if (currSum + num > partitionSum) {
				return new int[0][];
			}
			
			// If adding the current number equals the partition total, add the sub array to the solution
			// Update indeces and running total.
			if (currSum + num == partitionSum) {
				solution[solutionIndex] = Arrays.copyOfRange(values, valueIndex, i+1);
				valueIndex = i + 1;
				solutionIndex++;
				currSum = 0;
			}
			// Else increment the running total.
			else {
				currSum += num;
			}
		}
				
		return solution;
	}
}
