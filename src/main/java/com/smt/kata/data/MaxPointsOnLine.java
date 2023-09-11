package com.smt.kata.data;

import static org.mockito.Mockito.ignoreStubs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/****************************************************************************
 * <b>Title</b>: MaxPointsOnLine.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Max Points on a Line Kata
 * 
 * Given an array of points where points[i] = [xi, yi] represents a point on the 
 * X-Y plane, return the maximum number of points that lie on the same straight line.
 * this check assumes vertical/horizontal and diagonal (45 degrees) as the lines
 * to evaluate
 * 
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * https://assets.leetcode.com/uploads/2021/02/25/plane1.jpg
 * Output: 3
 * 
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * https://assets.leetcode.com/uploads/2021/02/25/plane2.jpg
 * Output: 4
 * 
 * Constraints:
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * Each point is processed only once, even if it is duplicated
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 12, 2021
 * @updates:
 ****************************************************************************/
public class MaxPointsOnLine {
	
	/**
	 * Calculates the number of points on a straight line
	 * @param points Points on the graph
	 * @return Max points in any straight line (vertical, horizontal and diagonal)
	 */
	public int findMax(int[][] points) {
		
		if (Objects.isNull(points)) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		
		Set<Line> lineSet = new HashSet<>();
		
		// Find all possible straight lines for combinations of points. 
		for (int i=0; i<points.length-1; i++) {
			int[] p1 = points[i];
			if (p1 == null) continue;
			
			for (int j=i+1; j<points.length; j++) {
				int[] p2 = points[j];
				if (p2 == null) continue;
				
				Line line = new Line(p1, p2);
				lineSet.add(line);
			}
		}
		
		// For each line, find how many points lie on that line.
		int maxPoints = 0;
		
				
		for (Line l : lineSet) {
			Set<Point> set = new HashSet<>(); 
			
			for (int[] point : points) {
				if (point == null) continue;
				
				if (pointOnLine(l, point)) {
					set.add(new Point(point));
				}
			}
			
			if (set.size() > maxPoints) {
				maxPoints = set.size();
			}
		}
		
		return maxPoints;
	}
	
	private boolean pointOnLine(Line l, int[] point) {
		return point[1] == point[0] * l.slope + l.yIntercept;
	}
	
	/**
	 * Line class to calculate slope and intercept.
	 */
	private class Line {
		Point p1;
		Point p2;
		int slope;
		int yIntercept;
		
		public Line(int[] point1, int[] point2) {
			this.p1 = new Point(point1);
			this.p2 = new Point(point2);
			
			slope = (p2.x - p1.x) == 0 ? 1 : (p2.y - p1.y) / (p2.x - p1.x);
			
			
			yIntercept = slope == 0 ? p1.y : p1.y / (slope * p1.x);
		}

		@Override
		public int hashCode() {
			return Objects.hash(slope, yIntercept);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Line other = (Line) obj;
			return slope == other.slope && yIntercept == other.yIntercept;
		}

		@Override
		public String toString() {
			return "Line [slope=" + slope + ", yIntercept=" + yIntercept + "]";
		}
	}
	
	private class Point {
		int x;
		int y;
		
		Point(int[] p) {
			x = p[0];
			y = p[1];
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		}
		
	}
}
