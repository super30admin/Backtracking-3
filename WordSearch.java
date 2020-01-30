//Time Complexity : O(N * 4^L)

//Space Complexity : O(L)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*
* Backtracking Approach is used for exploring all possibilities for finding the word in board.
* We have solved problem using visited array and local variable.Use of visited array increases space and time complexity. 
* */
public class WordSearch {

	public boolean exist(char board[][], String word) {
		if (board == null || board.length == 0 || board[0].length == 0 || word.isEmpty())
			return false;
		int row = board.length;
		int col = board[0].length;

		boolean visited[][] = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(board, visited, word, i, j))
					return true;
			}
		}
		return false;
	}

	private boolean dfs(char board[][], boolean visited[][], String word, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;
		if (board[i][j] == word.charAt(0)) {
			if (word.length() == 1)
				return true;
			char prev = board[i][j];
			board[i][j] = '#';
			// visited[i][j] = true;
			int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			for (int dir[] : dirs) {
				int r = i + dir[0];
				int c = j + dir[1];
				if (dfs(board, visited, word.substring(1), r, c))
					return true;
			}
			board[i][j] = prev;
			// visited[i][j] = false;
		}
		return false;
	}
}
