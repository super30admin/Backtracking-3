// Time complexity - N!, space compelixty N^2.

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        backtrack(grid, 0, result, n);
        return result;
    }

    private void backtrack(boolean[][] grid, int r, List<List<String>> result, int n) {
        if (r == n) {
            List<String> li = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(grid[i][j] ? 'Q' : '.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (isSafe(grid, r, c, n)) {
                grid[r][c] = true;
                backtrack(grid, r + 1, result, n);
                grid[r][c] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] grid, int r, int c, int n) {
        int i = r;
        while (i > 0) {
            i--;
            if (grid[i][c]) return false;
        }
        i = r;
        int j = c;
        while (i > 0 && j < n - 1) {
            i--;
            j++;
            if (grid[i][j]) return false;
        }
        i = r;
        j = c;
        while (i > 0 && j > 0) {
            i--;
            j--;
            if (grid[i][j]) return false;
        }
        return true;
    }
}
