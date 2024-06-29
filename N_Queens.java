// Time Complexity : O(n!)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<String>> res;
    boolean [][] grid;
    public List<List<String>> solveNQueens(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        grid = new boolean[n][n];
        res = new ArrayList();

        backtrack(0);
        return res;
    }

    private void backtrack(int row){
        //base
        if(row == grid.length){
            List<String> answer = new ArrayList<>();
            for(int l =0; l< grid.length; l++){
                StringBuilder sb = new StringBuilder();
                for(int m=0; m< grid.length; m++){
                    if(grid[l][m] == true){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                answer.add(sb.toString());
            }
            res.add(answer);
            return;
        }
        
        //logic
        for(int i = 0; i < grid.length; i++){
            if(isSafe(row,i)){
                //action
                grid[row][i] = true;
                //recurse
                backtrack(row+1);
                //backtrack
                grid[row][i] = false;
            }
        }
    }

    private boolean isSafe(int row, int col){
        // check up
        for(int i = row; i >= 0; i--){
            if(grid[i][col] == true){
                return false;
            }
        }

        // check upper left
        int i = row;
        int j = col;
        while(i >= 0 && j >= 0)
        {
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j--;
        }

        // check upper right
        i = row;
        j = col;
        while(i >= 0 && j < grid.length)
        {
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j++;
        }
    
        return true;
    }
}