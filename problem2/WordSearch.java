//Time Complexity : O(m*n*3^l), m -> Number of rows, n -> Number of columns, l -> Size of string
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class WordSearch {
	int[][] dirs;

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) {
			return false;
		}

		if (word.equals("")) {
			return true;
		}

		dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (helper(board, i, j, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(char[][] board, int row, int col, String word) {
		// Base
		if (word.length() == 0) {
			return true;
		}
		if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(0)) {
			return false;
		}
		boolean flag = false;
		board[row][col] = '-';
		// Logic
		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = col + dir[1];
			flag = helper(board, r, c, word.substring(1));
			if (flag) {
				break;
			}
		}
		board[row][col] = word.charAt(0);
		return flag;

	}

	public static void main(String[] args) {
		WordSearch obj = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println("Is the given word present in the board? " + (obj.exist(board, word) ? "Yes" : "No"));

	}

}
