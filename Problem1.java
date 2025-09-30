// Time Complexity : O(n*n!)
// Space Complexity : O(n^2) for grid
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using backtrack approach to start putting the queen in every possible column in each row to check if the grid is valid.
 * If not valid, then we backtrack the position and try the next one.
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        backtrack(grid, n, 0, result);
        return result;
    }

    private void backtrack(boolean[][] grid, int n, int r, List<List<String>> result) {
        //base case
        // we reach the last row
        if (r == n) {
            // converting boolean grid into result string
            result.add(createResult(grid));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (canPlace(grid, r, c, n)) {
                // action
                grid[r][c] = true;
                //recurse
                backtrack(grid, n, r + 1, result);
                //backtrack
                grid[r][c] = false;
            }
        }
    }

    private boolean canPlace(boolean[][] grid, int r, int c, int n) {
        // checking if there is any queen in same column
        for (int i = 0; i < r; i++) {
            if (grid[i][c]) return false;
        }

        // checking if any queen in left diagonal
        int i = r;
        int j = c;
        while (i >= 0 && j >= 0) {
            if (grid[i][j])
                return false;
            i--;
            j--;
        }

        // checking if any queen in right diagonal
        i = r;
        j = c;
        while (i >= 0 && j < n) {
            if (grid[i][j]) {
                return false;
            }

            i--;
            j++;
        }

        return true;
    }

    List<String> createResult(boolean[][] grid) {
        List<String> li = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j])
                    sb.append('Q');
                else
                    sb.append('.');
            }
            li.add(sb.toString());
        }

        return li;
    }


}