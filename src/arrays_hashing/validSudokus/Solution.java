package arrays_hashing.validSudokus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static boolean isValidSudoku(char[][] board) {
		// key -> 0..8 column; value -> HashSet with values 1-9
        Map<Integer, Set<Character>> cols = new HashMap<>();
        // key -> 0..8 row; value -> HashSet with values 1-9
        Map<Integer, Set<Character>> rows = new HashMap<>();
        // Subsquares 3x3: key String "0,0" or "1,2"
        Map<String, Set<Character>> squares = new HashMap<>();
        
        for(int r = 0; r < 9; r++) {
        	for(int c = 0; c < 9; c++) {
        		// For empty cells
        		if(board[r][c] == '.') continue;
        		
        		// Math trick for subsquares
        		String squareKey = (r/3) + "," + (c/3);
        		
        		if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
        				cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
        		   		squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
        		   		return false;
        		}
        		rows.get(r).add(board[r][c]);
        		cols.get(c).add(board[r][c]);
        		squares.get(squareKey).add(board[r][c]);
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		char[][] board = {
			    {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
			    {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
			    {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
			    {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
			    {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
			    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			    {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
			    {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
			    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
			};
		
		System.out.print("Input: \n" );
		for (char[] fila : board) {
		    for (char celda : fila) {
		        // Imprime la celda actual y un espacio, sin saltar de línea
		        System.out.print(celda + " "); 
		    }
		    // Cuando termina la fila, hace un salto de línea
		    System.out.println(); 
		}
		System.out.println("Output: " + isValidSudoku(board));
	}
}
