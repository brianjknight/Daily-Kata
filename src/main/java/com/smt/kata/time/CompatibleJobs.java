package com.smt.kata.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.springframework.ui.context.Theme;

/****************************************************************************
 * <b>Title</b>: CompatibleJobs.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Compatible Jobs Kata
 * 
 * You are given a list of jobs to be done, where each job is represented by a 
 * start time and end time. Two jobs are compatible if they don't overlap. Find 
 * the largest subset of compatible jobs.
 * 
 * For example, given the following jobs (there is no guarantee that jobs will be sorted):
 * 
 * [(0, 6),
 * (1, 4),
 * (3, 5),
 * (3, 8),
 * (4, 7),
 * (5, 9),
 * (6, 10),
 * (8, 11)]
 * Return:
 * 
 * [(1, 4),
 * (4, 7),
 * (8, 11)]
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 17, 2022
 * @updates:
 ****************************************************************************/
public class CompatibleJobs {

	/**
	 * Calculates the compatible jobs form the array of jobs
	 * @param arrJobs Jobs to check for compatibility
	 * @return Max compatible jobs
	 */
	public int[][] calculate(int[][] arrJobs) {
		
		if (Objects.isNull(arrJobs)) {
			return new int[0][];
		}
		
		// Sort the jobs by start time.
		Arrays.sort(arrJobs, Comparator.comparingInt(a -> a[0]));
		
		// keep track of start and stop times
		List<Integer> resultTimes = new ArrayList<>(); 
		
		// See how many subsequent jobs can be done starting from each job without overlapping.
		
		for (int i=0; i<arrJobs.length-1; i++) {
			int[] curJob = arrJobs[i];
			
			// Keep track of start and stop times in a list for each iteration.
			List<Integer> currTimes = new ArrayList<>();
			currTimes.add(curJob[0]);
			currTimes.add(curJob[1]);
			
			for (int j=i+1; j<arrJobs.length; j++) {
				int[] nextJob = arrJobs[j];
								
				// If current job end time is <= next job start time, include the job and update curJob.
				if (currTimes.get(currTimes.size()-1) <= nextJob[0]) {
					currTimes.add(nextJob[0]);
					currTimes.add(nextJob[1]);
					curJob = nextJob;
				}
				
			}
			
			// If the currentTimes list is longer than the resultTimes list update it.
			if (currTimes.size() > resultTimes.size()) {	
				resultTimes = currTimes;
			}
		}
		
		// convert the resultTimes List into 2D array of start/stop times for jobs.
		int[][] result = new int[resultTimes.size()/2][];
		
		int index = 0;
		
		for (int i=0; i<resultTimes.size(); i += 2) {
			int[] job = {resultTimes.get(i), resultTimes.get(i+1)};
			result[index]= job;
			index++;
		}
		
		return result;
	}
}
