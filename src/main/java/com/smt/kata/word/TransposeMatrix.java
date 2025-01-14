package com.smt.kata.word;

import java.util.Arrays;
import java.util.Objects;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

/****************************************************************************
 * <b>Title</b>: TransposeMatrix.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Enter the Matrix
 * In this challenge, you have to obtain a sentence from the elements of a given 
 * matrix. In the matrix, each word of the sentence follows a columnar order from 
 * the top to the bottom, instead of the usual left-to-right order: 
 * it's time for transposition! 
 * 
 * Given a matrix mtx, implement a function that returns the complete sentence as 
 * a string, with the words separated by a space between them.
 * 
 * Notes
 * All given matrices are regular, as to say that each column has the same length.
 * Punctuation is already given.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 1, 2021
 * @updates:
 ****************************************************************************/
public class TransposeMatrix {

	/**
	 * 
	 */
	public TransposeMatrix() {
		super();
	}

	/**
	 * Performs the transposing of the array into a String
	 * @param matrix
	 * @return
	 */
	public String parse(String[][] matrix) {
		
		StringBuilder sb = new StringBuilder();
		
		if (Objects.isNull(matrix) || matrix.length == 0) {
			return sb.toString();
		}
		
		int maxCol = 0;
		
		for (String[] s : matrix) {
			if (s.length > maxCol) {
				maxCol = s.length;
			}
		}
				
		// iterate the 2D matrix by column first
		for (int c=0; c < maxCol; c++) {
			if (c > maxCol-1) continue;
			
			// iterate the row for each column
			for (int r=0; r<matrix.length; r++) {
				String word = matrix[r][c];
				
				if (Objects.isNull(word) || word.isEmpty()) continue;
				
				 // append the current word
				sb.append(word);
				sb.append(" ");
			}
		}
		
		return sb.toString().trim();
	}
}
