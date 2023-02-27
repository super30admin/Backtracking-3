//Time Complexity : No idea
//Space Complexity : O(N^2) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Iterate over the board. Maintain an index to track the char found from the
 * word. Apply backtracking. Start from (0,0) index and check if the index is
 * matching with the given index of the word. If so, mark it with some random
 * char and call backtracking on its neighbors with word index incremented. If
 * found true return from there else, put back the original char in place of
 * random char and return false.
 *
 */
class Solution {
	int[] x4 = { 0, 1, 0, -1 };
	int[] y4 = { 1, 0, -1, 0 };

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (helper(board, i, j, word, 0))
					return true;
		return false;
	}

	public boolean helper(char[][] board, int i, int j, String word, int index) {
		if (index >= word.length())
			return true;

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
			return false;

		board[i][j] = '#';
		for (int t = 0; t < 4; t++) {
			int x = i + x4[t];
			int y = j + y4[t];
			if (helper(board, x, y, word, index + 1))
				return true;
		}
		board[i][j] = word.charAt(index);
		return false;
	}
}
