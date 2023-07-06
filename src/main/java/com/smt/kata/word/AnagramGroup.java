package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: AnagramGroup.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Group Anagrams
 * 
 * Given an array of strings strs, group the anagrams together. You can return 
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different 
 * word or phrase, typically using all the original letters exactly once.
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * 
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * Constraints:
 * strs[i] consists of lower-case English letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class AnagramGroup {

	/**
	 * Group the anagrams together
	 * @param words Array of words to group 
	 * @return Groups of anagrams
	 */
	public Collection<List<String>> assign(String[] words) {
		// iIf input is null or empty, return an empty list.
		if (words == null || words.length == 0) {
			return new ArrayList<>();
		}
		
		// For each word in the input array, sort it alphabetically for easier comparison to match anagrams.
		// Store the sorted anagram match in a map with the anagram and value of a List of the original words.
		Map<String, List<String>> map = new HashMap<>();
		
		for (String s : words) {
			if (s == null || s.isEmpty()) {
				continue;
			}
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sorted = new String(c);
			
			// If the anagram does not exist, add it and a new List with the current word.
			if (!map.containsKey(sorted)) {
				List<String> temp = new ArrayList<>();
				temp.add(s);
				map.put(sorted, temp);
			}
			
			// If the anagram does exist in the map, add the current word to its list.
			else {
				map.get(sorted).add(s);
			}
		}
		
		// Return a list of the values in the map.
		List<List<String>> result = new ArrayList<>();
		for (List<String> list : map.values()) {
			result.add(list);
		}
		
		return result;
	}

}
