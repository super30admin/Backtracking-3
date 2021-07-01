// Time Complexity : O(3 POW L) // L is length of string. at every char we have 3 choices
// Space Complexity :O(L) // stack size of string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. First find first char index and run recursion. If result is true return other wise find next occurrence of first char. 
 * 2. for each char move to next char on string and search over dir array.
 * 3. if char is not found return false other wise continue till index reached string length. 
 */

public class WordSearch {
	int[][] dir;

	public boolean exist(char[][] board, String word) {
		dir = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (helper(board, word, row, col, 0))
					return true;
			}
		}
		return false;
	}

	private boolean helper(char[][] board, String word, int row, int col, int index) {
		// base

		if (index == word.length())
			return true;
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
				|| board[row][col] != word.charAt(index)) {
			return false;
		}

		// logic

		// action
		char c = board[row][col];
		board[row][col] = '#';

		for (int i = 0; i < dir.length; i++) {
			int rowt = row + dir[i][0];
			int colt = col + dir[i][1];
			// recur
			if (helper(board, word, rowt, colt, index + 1))
				return true;
		}
		// backtrack
		board[row][col] = c;

		return false;
	}
}
