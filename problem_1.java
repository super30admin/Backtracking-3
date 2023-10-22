/*

N Queens(https://leetcode.com/problems/n-queens/)


Time Complexity : O(n!)
Space Complexity : O(n^2)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/


class Solution {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return new ArrayList<>();
        }

        grid = new boolean[n][n];
        result = new ArrayList<>();
        recurse(0);
        return result;
    }

    private void recurse(int row){

        if(row == grid.length){
            List<String> add = new ArrayList<>();
            for(int i =0; i<grid.length; i++){
                StringBuilder s = new StringBuilder();
                for(int j = 0; j<grid.length; j++){
                    if(grid[i][j]){
                        s.append('Q');
                    }
                    else{
                        s.append('.');
                    }
                }
                add.add(s.toString());
            }
            result.add(add);
            return;
        }

        for(int j = 0; j < grid.length; j++){
            if(isAllowed(row, j)){
                grid[row][j] = true;
                recurse(row + 1);
                grid[row][j] = false;

            }
        }

    }

    private boolean isAllowed(int row, int col){
        int row1 = row;
        int col1 = col;
        while(row1 >= 0){
            if(grid[row1][col1]){
                return false;
            }
           row1--;
        }
        row1 = row;
        while(row1>= 0 && col1>= 0){
            if(grid[row1][col1]){
                return false;
            }
            row1--;
            col1--;
        }
        row1 = row;
        col1 = col;
        while(row1>= 0 && col1< grid.length){
            if(grid[row1][col1]){
                return false;
            }
            row1--;
            col1++;
        }

        return true;
    }
}