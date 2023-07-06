package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: WordSubsets.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Word Subsets
 * 
 * You are given two string arrays words1 and words2.
 * 
 * A string b is a subset of string a if every letter in b occurs in a including multiplicity.
 * 
 * For example, "wrr" is a subset of "warrior" but is not a subset of "world".
 * A string a from words1 is universal if for every string b in words2, b is a subset of a.
 * 
 * Return an array of all the universal strings in words1. You may return the answer in any order.
 * 
 * Example 1:
 * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * 
 * Example 2:
 * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * 
 * Example 3:
 * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","oo"]
 * Output: ["facebook","google"]
 * 
 * Example 4:
 * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lo","eo"]
 * Output: ["google","leetcode"]
 * 
 * Example 5:
 * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 * 
 * Constraints:
 * 
 * 1 <= words1.length, words2.length <= 104
 * 1 <= words1[i].length, words2[i].length <= 10
 * words1[i] and words2[i] 
 * All the strings of words1 are unique.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 9, 2021
 * @updates:
 ****************************************************************************/
public class WordSubsets {
	
	/** 
	 * Finds the matching patterns in the collection of words.  The includes can 
	 * be in any order for the match
	 * @param words1 Words to search
	 * @param patterns Patterns to search for
	 * @return Collection of words that match the patterns
	 */
	public List<String> find(String[] words1, String[] patterns) {
		List<String> result = new ArrayList<>();
		
		if (words1==null || words1.length==0 || patterns==null || patterns.length==0) {
			return result;
		} 
		
		// Iterate each word in words1 array
		for (String word : words1) {
			if (word==null || word.isEmpty()) {
				continue;
			}
			 
			boolean allMatch = true;
			
			// Map the word for count of characters.
			Map<Character, Integer> wordMap = mapWord(word);

			// Iterate each pattern in words2
			for (String pattern : patterns) {				
				if (pattern==null) {
					continue;
				}
				
				// Map the current pattern for the count of characters.
				Map<Character, Integer> patternMap = mapWord(pattern);
				
				// If a pattern is not a match for the word, set allMatch to false and break the loop.
				if (!patternMatch(wordMap, patternMap)) {
					allMatch = false;
					break;
				}
			} 
			
			// If allMatch is still true, add the current word to the result list.
			if (allMatch) { 
				result.add(word.toLowerCase());
			}
		}	
		
		return result;
	}
	
	// Helper method to check if a word contains at least as many characters as a given pattern.
	public boolean patternMatch(Map<Character, Integer> wordMap, Map<Character, Integer> patternMap) {
		
		for (Map.Entry<Character, Integer> entry : patternMap.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			
			if (!wordMap.containsKey(key) || wordMap.get(key) < val) {
				return false;
			}
		}
		
		return true;
	}
	
	// Helper method to map a String to count of character occurrences.
	public Map<Character, Integer> mapWord(String input) {
		Map<Character, Integer> map = new HashMap<>();
	
		for (int i=0; i<input.length(); i++) {
			char c = Character.toLowerCase(input.charAt(i)); 
			
			if (map.containsKey(input.charAt(i))){
				map.put(c,map.get(c)+1);
			}
			else {
				map.put(c,1);
			}
		}
		
		return map;
	}
}
