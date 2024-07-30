public class NQueen {
    // go row by row and then backtrack
    public List<List<String>> solveNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();

        bactrack(grid, 0, result);

        return result;

    }

    private void bactrack(boolean[][] grid, int r, List<List<String>> result) {
        // base
        if (r == grid.length) {
            // all queens
            List<String> li = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sbr = new StringBuilder();
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j]) {
                        sbr.append('Q');
                    } else {
                        sbr.append('.');
                    }
                }
                li.add(sbr.toString());
            }
            result.add(li);
            return;
        }

        // logic on row r
        for (int c = 0; c < grid[0].length; c++) {
            if (isSafe(grid, r, c)) {
                // action
                grid[r][c] = true;
                // recurse
                bactrack(grid, r + 1, result);
                // backtrack
                grid[r][c] = false;

            }
        }
    }

    private boolean isSafe(boolean[][] grid, int r, int c) {
        int n = grid[0].length;
        // column check
        for (int i = 0; i < r; i++) {
            if (grid[i][c]) {
                return false;
            }
        }

        // diag up right
        int i = r;
        int j = c;
        while (i >= 0 && j < n) {
            if (grid[i][j]) {
                return false;
            }
            i--;
            j++;
        }

        // diag up left
        int x = r;
        int y = c;
        while (x >= 0 && y >= 0) {
            if (grid[x][y]) {
                return false;
            }
            x--;
            y--;
        }

        return true;
    }
}