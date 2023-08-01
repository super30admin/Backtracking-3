package Backtracking_3;

/**
 * Using DFS with backtracking as there can be multiple paths that satisfy a
 * part of the solution but may not lead to the correct path. In such case we
 * backtrack and explore further to find the correct path.
 * 
 * Time Complexity : O(3^(L))- where L is the length of the given string. (using
 * 3^L as we will have 3 options to explore at every node expect first)
 * 
 * Space Complexity : O(L), accounts for recursive stack space.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem2 {
	int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public boolean exist(char[][] board, String word) {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (dfs(board, word, i, j, 0))
						return true;
				}
			}

		}
		return false;
	}

	boolean dfs(char[][] board, String word, int i, int j, int currIdx) {
		// base
		if (currIdx == word.length()) {
			return true;
		} else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}

		// logic
		if (board[i][j] == word.charAt(currIdx)) {
			board[i][j] = '_';

			for (int k = 0; k < dirs.length; k++) {
				if (dfs(board, word, i + dirs[k][0], j + dirs[k][1], currIdx + 1))
					return true;

			}
			board[i][j] = word.charAt(currIdx);

		}

		return false;
	}

}
