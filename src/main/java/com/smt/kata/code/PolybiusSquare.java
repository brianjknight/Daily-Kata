package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: PolybiusSquare.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> The Polybius Square cipher is a simple substitution cipher 
 * that makes use of a 5x5 square grid. The letters A-Z are written into the grid, 
 * with "I" and "J" typically sharing a slot (as there are 26 letters and only 25 slots).

			1	2	3	4	5
		1	A	B	C	D	E
		2	F	G	H	I/J	K
		3	L	M	N	O	P
		4	Q	R	S	T	U
		5	V	W	X	Y	Z

 * To encipher a message, each letter is merely replaced by its row and column numbers in the grid.
 * Create a function that takes a plaintext or ciphertext message, and returns the corresponding ciphertext or plaintext.
 * As "I" and "J" share a slot, both are enciphered into 24, but deciphered only into "I" (see third and fourth test).
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class PolybiusSquare {

	// Create an 2D array so that a letter can be found given int value and vice versa.
	private char[][] letters = {
			{'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'k'},
            {'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u'},
            {'v', 'w', 'x', 'y', 'z'}
        };
	
	/**
	 * Encodes a sentence into its polybius values
	 * @param term
	 * @return
	 */
	public String polybiusEncode(String term){
		// convert input to lowercase
		String word = term.toLowerCase();
		
		//Find each character in the 2D array and convert to 1 based index location.
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if (c == ' ') {
				sb.append(c);
			}
			else if (c == 'j') {
				sb.append(findLetter('i'));
			}
			else {
				sb.append(findLetter(c));
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Decodes the polybius back to a string
	 * @param code
	 * @return
	 */
	public String decodeValue(String code){
		StringBuilder sb = new StringBuilder();
		
		// Iterate the encoded value to find each coordinate.
		for (int i=0; i<code.length()-1; i+=2) {
			// Check for a space instead of a character
			if (code.charAt(i) == ' ') {
				sb.append(" ");
				i--;
				continue;
			}
			
			// find row index
			int r = Character.getNumericValue(code.charAt(i)) - 1;
			// find column index
			int c = Character.getNumericValue(code.charAt(i+1)) - 1;
			// Append letter
			sb.append(letters[r][c]);
		}
		
	    return sb.toString().trim();
	}
	
	/**
	 * Helper method to find a character.
	 * @param c
	 * @return
	 */
	private String findLetter(char c) {
		for (int i=0; i<letters.length; i++) {
			for (int j=0; j<letters[0].length; j++) {
				if (letters[i][j] == c) {
					return "" + (i+1) + (j+1);
				}
			}
		}
		return "";
	}
	
}
