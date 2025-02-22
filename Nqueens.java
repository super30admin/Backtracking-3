// Time Complexity : O(N!)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA

class Solution {
    List<List<String>> res;
    boolean[][] grid;

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        this.grid = new boolean[n][n];
        backtrack(n, 0);
        return res;
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            List<String> li = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(row, i, n)) {
                grid[row][i] = true;
                backtrack(n, row + 1);
                grid[row][i] = false;
            }
        }
    }

    private boolean isSafe(int row, int col, int n) {
        // check up
        for (int i = 0; i < row; i++) {
            if (grid[i][col]) {
                return false;
            }
        }
        int i = row;
        int j = col;

        // check diagonal left
        while (i >= 0 && j >= 0) {
            if (grid[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;

        // check diagonal right
        while (i >= 0 && j < n) {
            if (grid[i][j]) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}
