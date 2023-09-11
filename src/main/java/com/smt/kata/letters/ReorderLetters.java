package com.smt.kata.letters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: ReorderLetters.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reorder Letters Kata
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters. 
 * If there are multiple characters with the same count, the letters should be
 * sorted alphabetically.  Same letter with different case should be consider as 
 * 2 different characters
 * 
 * Example One
 * Input: tweet
 * Output: eettw
 * 
 * Example Two
 * Input: TwEet
 * Output: ETetw
 * 
 * Empty/Null
 * Input: null or ""
 * Output: ""
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 31, 2022
 * @updates:
 ****************************************************************************/
public class ReorderLetters {

	/**
	 * Reorders the letters based upon the total number each character is present and 
	 * then ordered alphabetically.
	 * @param word Word to reorder it's letters
	 * @return Reordered word
	 */
	public String process(String word) {
		String result = "";
		
		if (word == null || word.isEmpty()) {
			return result;
		}
		
		List<Letter> letters = getLetters(word);
		
		for (Letter l : letters) {
			result += Character.toString(l.c).repeat(l.count);
		}
		
		return result;
	}
	
	List<Letter> getLetters(String word) { 
		Map<Character, Integer> map = new HashMap<>();
		
		for (char c : word.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}			
		}
		List<Letter>  list = new ArrayList<>();

		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			list.add(new Letter(e.getKey(), e.getValue()));
		}
		
		Collections.sort(list);
		
		return list;
	}
	
	class Letter implements Comparable<Letter>{
		Character c;
		Integer count;;
		Letter(char c, int count) {
			this.c = c;
			this.count = count;
		}
		
		@Override
		public int compareTo(Letter other) {
			int result = other.count.compareTo(this.count);
			if (result == 0) {
				result = this.c.compareTo(other.c);
			}
			return result;
		}
	}
}




