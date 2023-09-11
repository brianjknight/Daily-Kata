package com.smt.kata.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.IntFunction;

/**
 * Given a master int array and removes diff array.  Remove all instances of
 * elements in remove from master.
 * 
 * Example
 * 
 * master: {1,2,3,3,4,5,6}, remove: {1,3,5} => {2,4,6}
 * master: {1,2,3,3,4,5,6}, remove: {} => {1,2,3,3,4,5,6}
 * master: {1,2,3,3,4,5,6}, remove: {1,2,3,3,4,5,6} => {}
 * master: {}, remove: {1,3,5} => {}
 * 
 * Notes:
 * 
 * Order is not guaranteed on incoming lists but return should be ordered low->high
 * Method always returns an array, even if it is empty or inputs are null.
 * 
 * @author raptor
 *
 */
public class DiffRemover {

	public int[] deDiff(int[] master, int[] remove) {
		
		// null & empty check on master
		if (Objects.isNull(master) || master.length == 0) {
			return new int[0];
		}
		
		// null & empty check on remove
		if (Objects.isNull(remove) || remove.length == 0) {
			return master;
		}
		
		// convert both to Collections
		List<Integer> mast = new ArrayList<>();
		for (int i : master) { 
			mast.add(i);
		}
		List<Integer> rem = new ArrayList<>();
		for (int i : remove) { 
			rem.add(i);
		}
		
		// for each remove number, remove occurrences from master
		mast.removeAll(rem);
		Collections.sort(mast);
		
		//convert master back to Array and return
		int result[] = new int[mast.size()];
		for (int i = 0; i<mast.size(); i++) {
			result[i] = mast.get(i); 
		}
		
		return result;
	}
}
