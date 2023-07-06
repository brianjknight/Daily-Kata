package com.smt.kata.distance;

/****************************************************************************
 * <b>Title</b>: ClosestPoints.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Closest points Kata
 * 
 * Given a set of points (x, y) on a 2D cartesian plane, find the two closest points. 
 * For example, given the points [
 * 		(1, 1), 
 * 		(-1, -1), 
 * 		(3, 4), 
 * 		(6, 1), 
 * 		(-1, -6), 
 * 		(-4, -3)
 * ], 
 * 
 * return [(-1, -1), (1, 1)]
 * 
 * Constraints:
 * points length > 1
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 16, 2021
 * @updates:
 ****************************************************************************/
public class ClosestPoints {

	/**
	 * Finds the two closest points and returns them
	 * @param points Points to calculate distance against
	 * @return Closest points
	 */
	public Integer[][] calculateClosestPoints(Integer[][] points) {
		Integer[][] result = new Integer[2][];
		Double minDistance = Double.MAX_VALUE;
		
		// Check for null or empty input.
		if (points == null || points.length == 0) {
			return new Integer[0][];
		}
		
		// Outer loop to getting starting point to calculate distance.
		for (int i=0; i<points.length-1; i++) {
			Integer[] curPoint = points[i];
			
			// Inner loop to calculate the distance for all remaining points.
			for (int j=i+1; j<points.length; j++) {
				Integer[] nextPoint = points[j];
				
				// Find the distance between the 2 points.
				Double curDist = getDistance(curPoint, nextPoint);
				
				// If the distance is shorter than the current minimum distance calculated, save the points in result.
				if (curDist < minDistance) {
					minDistance = curDist;
					result[0] = curPoint;
					result[1] = nextPoint;
				}
			}
		}
		return result;
	}
	
	// Helper method to calculate the distance between 2 points.
	private Double getDistance(Integer[] p1, Integer[] p2) {
		Double dist = 0.0;
		
		Double x = Math.pow(p1[0] - p2[0], 2);
		Double y = Math.pow(p1[1] - p2[1], 2);		
				
		dist = Math.sqrt(x+y);
		
		return dist;
	}
}
