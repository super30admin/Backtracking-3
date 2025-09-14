// Time Complexity : O(N!) where N is the number of queens
// Space Complexity : O(N^2) for the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Place queens at every safe place and recursively call for next row.
// Iterate over the entire column and check only for upper part of the grid since we have not placed any queens below.
// If non of the columns are safe, we backtrack and try for the next column in the previous row.

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList();
        boolean[][] grid = new boolean[n][n];
        helper(grid, 0);
        return result;
    }

    private void helper(boolean[][] grid, int r){
        //base
        if(r == grid.length){
            List<String> pos = new ArrayList();
            StringBuilder sb;
            for(int i=0;i<grid.length;i++){
                sb = new StringBuilder();
                for(int j=0;j<grid.length;j++){
                    if(grid[i][j])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                pos.add(sb.toString());
            }

            result.add(pos);
        }
        //logic
        for(int c=0;c<grid.length;c++){
            if(isSafe(grid,r,c)){
                grid[r][c] = true;
                helper(grid,r+1);
                grid[r][c] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] grid, int r, int c){
        //row check
        for(int i=0;i<r;i++)
            if(grid[i][c]) return false;
        // up left dia
        int i =r-1; int j = c-1;
        while(i>=0 && j>=0){
            if(grid[i--][j--]) return false;
        }
        // up right
        i = r-1; j = c+1;
        while(i>=0 && j<grid.length){
            if(grid[i--][j++]) return false;
        }

        return true;
    }
}