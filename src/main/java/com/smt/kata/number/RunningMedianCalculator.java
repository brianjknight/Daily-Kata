package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/****************************************************************************
 * <b>Title</b>: RunningMedianCalculator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Compute the running median of a sequence of numbers. 
 * That is, given a stream of numbers, print out the median of the list so far 
 * on each new element.
 * 
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 * 
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 25, 2021
 * @updates:
 ****************************************************************************/
public class RunningMedianCalculator {

	/**
	 * 
	 */
	public RunningMedianCalculator() {
		super();
	}
	
	/**
	 * Takes an array of integers and returns the running median value
	 * @param values
	 * @return
	 */
	public List<Double> getMedianValues(int[] values) {
		// Instantiate empty list for the result.
		List<Double> result = new ArrayList<>();
		
		// If the input is null or empty return the empty list.
		if (values == null || values.length == 0) {
			return result;
		}
		
		// A running list to add each element of the input array.
		List<Integer> runningList = new ArrayList<>();
		
		// Iterate the input array.
		for (int i : values) {
			// Add the current int to the running list.
			runningList.add(i);
			
			// Sort the running list.
			Collections.sort(runningList);
			
			// Find the median and add to the result List
			Double median = getMedian(runningList);
			result.add(median);
		}
		
		return result;
	}

	// Helper method to find the median of a sorted list.
	private Double getMedian(List<Integer> list) {
		Double median = 0.0;
		
		int len = list.size();
		
		if (len%2 == 0) {
			median = (list.get(len/2) + list.get(len/2-1))/2.0; 
		}
		else {
			median = (double) list.get(len/2);
		}
		
		return median;
	}
}

