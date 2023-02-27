import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//Time Complexity : O(N!) since we dont cover all indices instead we use only the non dangerous cells
//Space Complexity : O(N^2) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

// Start backtracking from 0th row. In backtracking, we have to check on each column,
// if queen is placed in that (row, col) then wether it would be clashing with diagonal
// antidiagonal. Push these values to their respective sets and then apply backtracking
// on next row. After that remove all these additions from the respective sets. Push 
// the result when row is reached last index.
class Solution {
	List<List<String>> ans = new ArrayList<>();
	Set<Integer> cols = new HashSet<>();
	Set<Integer> diagonals = new HashSet<>();
	Set<Integer> antiDiagonals = new HashSet<>();

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(board[i], '.');
		helper(n, 0, board);
		return ans;
	}

	private List<String> createBoard(char[][] state) {
		List<String> board = new ArrayList<String>();
		for (int row = 0; row < state.length; row++) {
			String current_row = new String(state[row]);
			board.add(current_row);
		}

		return board;
	}

	public void helper(int n, int row, char[][] board) {
		if (row == n) {
			ans.add(createBoard(board));
			return;
		}
		for (int col = 0; col < n; col++) {
			int diag = row - col;
			int antiDiag = row + col;

			if (cols.contains(col) || diagonals.contains(diag) || antiDiagonals.contains(antiDiag))
				continue;
			cols.add(col);
			diagonals.add(diag);
			antiDiagonals.add(antiDiag);

			board[row][col] = 'Q';
			helper(n, row + 1, board);
			cols.remove(col);
			diagonals.remove(diag);
			antiDiagonals.remove(antiDiag);
			board[row][col] = '.';
		}
	}
}