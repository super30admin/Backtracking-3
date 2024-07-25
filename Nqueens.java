// Time Complexity : N!
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Nqueens {
    // using dfs with backtracking
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        helper(grid, 0, result);
        return result;
    }

    private void helper(boolean[][] grid, int r, List<List<String>> result) {
        // base
        if (r == grid.length) {
            // All the queens are placed
            List<String> list = new ArrayList();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder currRowStr = new StringBuilder();
                // iterte over coloumn
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j])
                        currRowStr.append('Q');
                    else
                        currRowStr.append('.');
                }
                list.add(currRowStr.toString());
            }

            result.add(list);
            return;
        }

        // for the specific row, iterate over coloumns
        for (int c = 0; c < grid[0].length; c++) {
            if (isSafeToPlaceQueen(grid, r, c)) {
                // Action
                grid[r][c] = true;
                // Recurse
                helper(grid, r + 1, result);
                // Backtrack
                grid[r][c] = false;

            }
        }
    }

    private boolean isSafeToPlaceQueen(boolean[][] grid, int r, int c) {
        // check for col
        for (int i = 0; i < r; i++) {
            if (grid[i][c])
                return false;
        }

        // check for diagonal up right
        int i = r, j = c;
        while (i >= 0 && j < grid[0].length) {
            if (grid[i][j])
                return false;
            i--;
            j++;
        }

        // reset i and j
        i = r;
        j = c;
        // check for diagonal up left
        while (i >= 0 && j >= 0) {
            if (grid[i][j])
                return false;
            i--;
            j--;
        }
        return true;
    }
}