//Time Complexity : O(n!), n -> Board size (row or col)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	List<List<String>> ans;
	boolean[][] board;

	public List<List<String>> solveNQueens(int n) {
		ans = new ArrayList<>();
		if (n == 0 || n == 2 || n == 3) {
			return ans;
		}

		board = new boolean[n][n];
		helper(n, 0);
		return ans;
	}

	private void helper(int n, int row) {
		// Base
		if (row == n) {
			List<String> solution = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (board[i][j]) {
						sb.append("Q");
					} else {
						sb.append(".");
					}
				}
				solution.add(sb.toString());
			}
			ans.add(solution);
		}
		// Logic
		for (int i = 0; i < n; i++) {
			if (isSafe(n, row, i)) {
				board[row][i] = true;
				helper(n, row + 1);
				board[row][i] = false;
			}
		}
	}

	private boolean isSafe(int n, int row, int col) {
		// Column Check
		for (int i = 0; i < row; i++) {
			if (board[i][col]) {
				return false;
			}
		}
		// Left Diagonal Check
		int r = row;
		int c = col;
		while (r >= 0 && c >= 0) {
			if (board[r--][c--]) {
				return false;
			}
		}
		// Right Diagonal Check
		r = row;
		c = col;
		while (r >= 0 && c < n) {
			if (board[r--][c++]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens obj = new NQueens();
		int n = 4;
		List<List<String>> ans = obj.solveNQueens(n);
		System.out.println("List of solutions:");
		for (List<String> sol : ans) {
			for (String row : sol) {
				System.out.print(row + ", ");
			}
			System.out.println();
		}
	}

}
