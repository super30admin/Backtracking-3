// Time Complexity : O(n!) because we try placing queens column by column for every row and prune invalid placements using safety checks
// Space Complexity : O(n^2) for storing the chess board and recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use backtracking to place one queen in every row and try all possible columns while ensuring the current position is safe from previously placed queens.
// When all rows are processed, we convert the board configuration into the required string representation and add it to the result as a valid arrangement.
// Backtracking removes the queen after recursion so that other possible board configurations can be explored correctly.

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        helper(grid, 0, result);
        return result;
    }

    private void helper(boolean[][] grid, int r, List<List<String>> result) {
        // base case
        if (r == grid.length) {
            List<String> li = new ArrayList<>();
            for (int i=0; i<grid.length; i++) {
                StringBuilder s = new StringBuilder();
                for(int j=0; j<grid.length; j++) {
                    if (grid[i][j]) {
                        s.append("Q");
                    } else {
                        s.append(".");
                    }
                }
                li.add(s.toString());
            }
            result.add(li);
        }

        for (int c = 0; c < grid.length; c++) {
            if (isSafe(grid, r, c)) {
                // action
                grid[r][c] = true;

                // recurse
                helper(grid, r+1, result);

                // backtrack
                grid[r][c] = false;

            }
        }    
    }

    private boolean isSafe(boolean[][] grid, int r, int c) {
        // column
        for (int i =0; i<r; i++) {
            if (grid[i][c]) return false;
        }

        // left diagonal
        int i = r; int j = c;
        while(i>=0 && j>=0) {
            if (grid[i][j]) return false;
            i--;
            j--;
        }

        // right diagonal
        i = r; j = c;
        while(i>=0 && j<grid.length) {
            if (grid[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}