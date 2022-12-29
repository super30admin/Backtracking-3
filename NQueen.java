import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(N * 2^N!) N is to check if queen is safe, 2^(N!) 
//Space Complexity :O(N^3) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class NQueen {
	List<List<String>> result = new ArrayList<>();
	boolean[][] state;

	public List<List<String>> solveNQueens(int n) {
		state = new boolean[n][n];
		helper(0, n);

		return result;
	}

	public void helper(int r, int n) {

		// base condition
		if (r == n) {
			List<String> sol = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (state[i][j]) {
						sb.append("Q");
					} else {
						sb.append(".");
					}
				}
				sol.add(sb.toString());
			}
			result.add(sol);

			return;
		}
		// logic
		for (int j = 0; j < n; j++) {

			if (isSafe(r, j, n)) {
				state[r][j] = true;
				helper(r + 1, n);
				state[r][j] = false;
			}
		}

	}

	private boolean isSafe(int r, int c, int n) {

		// check row up
		for (int i = 0; i < r; i++) {
			if (state[i][c])
				return false;
		}
		// diagonal right
		int nc = c;
		for (int i = r - 1; i >= 0; i--) {
			if (nc < n - 1 && state[i][nc + 1])
				return false;
			nc = nc + 1;
		}
		// diagonal left
		nc = c;
		for (int i = r - 1; i >= 0; i--) {
			if (nc > 0 && state[i][nc - 1])
				return false;
			nc = nc - 1;
		}

		return true;

	}

}
