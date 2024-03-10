package week6.day3;

class Solution {
	int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public boolean exist(char[][] board, String word) {
		char ch = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == ch)
					return dfs(board, word, i, j, 0);
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, String word, int i, int j, int idx) {
		// base
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') {
			return false;
		}
		if (idx == word.length()) {
			return true;
		}
		// logic
		if (board[i][j] == word.charAt(idx)) {
			board[i][j] = '#';

			for (int[] dir : directions) {
				int nr = i + dir[0];
				int nc = j + dir[1];

				if (dfs(board, word, nr, nc, idx + 1))
					return true;
				// backtrack
				board[i][j] = word.charAt(idx);
			}
		}
		return false;
	}
}

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'F', 'D' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABFDEESDF";
		Solution s = new Solution();
		System.out.println(s.exist(board, word));

	}

}
