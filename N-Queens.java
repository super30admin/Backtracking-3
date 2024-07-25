// Time Complexity: O(m.n.n!)
// Space Complexity: O(m.n)

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        backtrack(grid, 0, n, result);
        return result;
    }

    private void backtrack(boolean[][] grid, int r, int n, List<List<String>> result) {
        // base
        if (r == n) {
            List<String> li = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (grid[i][j])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);

        }
        // logic
        for (int j = 0; j < n; j++) {
            if (isSafe(grid, r, j, n)) {
                // action
                grid[r][j] = true;
                // recurse
                backtrack(grid, r + 1, n, result);
                // backtrack
                grid[r][j] = false;
            }
        }

    }

    private boolean isSafe(boolean[][] grid, int r, int c, int n) {
        // col check
        for (int i = 0; i <= r; i++) {
            if (grid[i][c])
                return false;
        }
        // main diag check

        int i = r, j = c;
        while (i >= 0 && j >= 0) {
            if (grid[i][j])
                return false;
            i--;
            j--;
        }

        // min diag check
        i = r;
        j = c;
        while (i >= 0 && j < n) {
            if (grid[i][j])
                return false;
            i--;
            j++;
        }
        return true;

    }
}