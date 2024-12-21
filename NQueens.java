// Logic - pure backtracking
// Time complexity = O(n!)
// Space complexity = O(n^2)// for making the grid.
// the columns are in iteration, that's why it is not repeated subproblems,since the start of the grid determines a lot of what will happen later.
// the rows increase one step further one at a time.
// note - the grid should be a boolean array to be easier to code.
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res= new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        backtrack(grid, 0);
        return res;
    }
    
    private void backtrack(boolean[][] grid,int row) {
        // base
        if(row== grid.length) {
            List<String> li = new ArrayList<>();
            for(int i=0;i< grid.length;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j< grid.length;j++) {
                    if(grid[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }
        
        // logic
        for(int c=0;c< grid.length;c++) {
            if(isSafe(grid, row,c)) {
                grid[row][c] = true;
                backtrack(grid, row+1);
                grid[row][c] = false;
            }
            
        }
    }
    
    private boolean isSafe(boolean[][] grid, int row, int column) {
        // column check
        for(int i=0;i<=row-1;i++) {
            if(grid[i][column]) return false;            
        }
        // upper left diagonal check
        int i= row-1;
        int j = column-1;
        while(i >= 0 && j>=0) {
            if(grid[i][j]) return false;
            i--;
            j--;
        }

        // upper right diagonal check
        i= row-1;
        j = column+1;
        while(i >= 0 && j<grid.length) {
            if(grid[i][j]) return false;
            i--;
            j++;
        }

        return true;
    }
}