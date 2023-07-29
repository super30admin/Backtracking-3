// Time Complexity: O(n!)
// Space Complexity: O(n^2)

class Solution1 {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        backtrack(grid, 0, n);
        return result;
    }

    private void backtrack(boolean[][] grid, int i, int n) {
        //base case
        if( i == n) {
            List<String> list = new ArrayList<>();
            for(int x = 0; x < n; x++) {
                StringBuilder sb = new StringBuilder();
                for(int y = 0; y < n; y++) {
                    if( grid[x][y] ) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        //logic
        for(int j = 0; j < n; j++) {
            if( isSafe(grid, i, j) ) {
                grid[i][j] = true;
                backtrack(grid, i+1, n);
                grid[i][j] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] grid, int i, int j) {
        int n = grid.length;
        //column check
        for(int r = 0; r < i; r++) {
            if( grid[r][j] ) {
                return false;
            }
        }
        //diagonal check
        int x = i;
        int y = j;
        while( x >= 0 && y >= 0) {
            x = x-1;
            y = y-1;
            if( x >= 0 && y >= 0 && grid[x][y] ) {
                return false;
            }
        }
        x = i;
        y = j;
        while( x >= 0 && y < n) {
            x = x-1;
            y = y+1;
            if(x >= 0 && y < n && grid[x][y] ) {
                return false;
            }
        }
        return true;
    }
}