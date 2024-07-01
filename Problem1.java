/*
    LC - 51. N-Queens
    TC - O(n!)
        if we see on each row, no. of ways is getting reduced
        first now -> n ways
        second row -> n-2 ways
        third row -> n-4 ways 
        n * n-2 * n-4 which is factorial.
    SC - n^2 (which is for grid)  +  n (which is for recursive space)
         Overall ~ O(n^2)
    Approach - using backtrack.
*/

class Solution {
    boolean[][] grid;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        grid = new boolean[n][n];
        backtrack(0);
        return result;
    }
    public void backtrack(int row) {
        // base
        if(row == grid.length) {
            List<String> answer = new ArrayList<>();
            for(int i=0; i<grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<grid.length; j++) {
                    if(grid[i][j] == true) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;
        }

        // logic
        for(int i=0; i<grid.length; i++) { // since it is n x n grid. it is the column
            if(isSafe(row, i)) {
                // action
                grid[row][i] = true;
                // recurse
                backtrack(row + 1);
                // backtrack
                grid[row][i] = false;
            }
        }
    }
    public boolean isSafe(int row, int col) {
        // check the upper direction
        for(int i = row; i>=0; i--) {
            if(grid[i][col] == true) {
                return false;
            }
        }
        // check the left diagonal
        int i = row, j = col;
        while( i>=0 && j>=0) {
            if(grid[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }
        // check the right diagonal
        i = row;
        j = col;
        while( i>=0 && j<grid.length) {
            if(grid[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}