package com.smt.kata.word;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;

// JDK 11.x
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/****************************************************************************
 * <b>Title</b>: RepeatCounter.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Repeat Counter
 * 
 * Given an array, create a function that returns an object detailing how many 
 * times each element was repeated. Any object type may be passed
 * 
 * calculate(["cat", "dog", "cat", "cow", "cow", "cow"]) ➞ { cow: 3, cat: 2, dog: 1 }
 * calculate([1, 5, 5, 5, 12, 12, 0, 0, 0, 0, 0, 0]) ➞ { 0: 6, 5: 3, 12: 2, 1: 1 }
 * calculate(["Infinity", "null", "Infinity", "null", "null"]) ➞ { null: 3, Infinity: 2}
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
public class RepeatCounter {
	// Members
	private Map<Object, Integer> counter = new HashMap<>();
	
	/**
	 * Calculates how many duplicates for each object
	 * @param items Items to calculate
	 * @return Map with each object and it's count
	 */
	public Map<Object, Integer> calculate(Object[] items) {
		//null & empty input check
		if (items == null || items.length == 0) {
			return counter;
		}
		
		// Increment the count of an object in the map or add it with count of 1 if it does not exist.
		for (Object o : items) { 
			if (counter.containsKey(o)) {
				counter.put(o, counter.get(o) + 1);
			}
			else {
				counter.put(o, 1);
			}
		}
		
		return counter;
	}
	
	/**
	 * Simple Bean to be used to test complex objects
	 */
	class MyBean {
		// Members
		private Object key;
		private Object value;
		
		// Constructor to make life simpler
		public MyBean() { super(); }
		public MyBean(Object key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}
		
		// Assign the getters and setters
		public Object getKey() { return key; }
		public Object getValue() { return value; }
		public void setKey(Object key) { this.key = key; }
		public void setValue(Object value) { this.value = value; }
		
		@Override
		public int hashCode() {
			return Objects.hash(key, value);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MyBean other = (MyBean) obj;
			return Objects.equals(key, other.key) && Objects.equals(value, other.value);
		}
		
		
	}
}
