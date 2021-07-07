// Time complexity is O(m*n*4^L) where L is the length of the word
// Space complexity is O(M*N)+ O(L)
// This solution is submitted on leetcode

public class BigN73FindWordin2DBoardOfCharacter {
		boolean[][] visited;
		public boolean exist(char[][] board, String word) {
			// edge case
			int row = board.length;
			if (board == null || row == 0)
				return false;
			int column = board[0].length;
			visited = new boolean[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (dfs(board, word, i, j))
						return true;
				}
			}
			return false;
		}

		private boolean dfs(char[][] board, String word, int i, int j) {
			// base case
			if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
				return false;
			// logic
			if (board[i][j] == word.charAt(0)) {
				visited[i][j] = true;
				if (word.length() == 1)
					return true;
				int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
				for (int[] dir : dirs) {
					int r = i + dir[0];
					int c = j + dir[1];
					boolean exist = dfs(board, word.substring(1), r, c);
					if (exist == true)
						return true;
				}
				visited[i][j] = false;
			}
			return false;
		}
	}