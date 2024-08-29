// Problem 51. N-Queens
// Time Complexity : O(N!)
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        backtrack(grid, 0, result);
        return result;
    }
    private void backtrack(boolean[][] grid, int r, List<List<String>> result) {
        // base
        if (r == grid.length) {
            // valid solution
            List<String> l1 = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                l1.add(sb.toString());
            }
            result.add(l1);
            return;
        }
        // logic
        for (int c = 0; c < grid.length; c++) {
            if (isSafe(grid, r, c)) {
                // action
                grid[r][c] = true;
                // recurse
                backtrack(grid, r + 1, result);
                // backtrack
                grid[r][c] = false;
            }
        }
    }
    private boolean isSafe(boolean[][] grid, int r, int c) {
        // column up check
        for (int i = 0; i < r; i++) {
            if (grid[i][c]) {
                return false;
            }
        }
        // diag up left
        int i = r, j = c;
        while (i >= 0 && j >= 0) {
            if (grid[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        // diag up right
        i = r;
        j = c;
        while (i >= 0 && j < grid.length) {
            if (grid[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
