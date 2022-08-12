// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> result;
    int n;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        result= new ArrayList<>();
        grid = new boolean[n][n];
        this.n=n;
        
        backtracking(0);
        return result;
    }
    private void backtracking(int row){
        // base case
        if(row == n){
           List<String> answer= new ArrayList<>(); 
           for(int i=0;i<n;i++){
               StringBuilder sb = new StringBuilder();
               for(int j=0;j<n;j++){
                   if(grid[i][j]==true){
                       sb.append("Q");
                   }else{
                       sb.append(".");
                   }
               }
               answer.add(sb.toString());
           }
            result.add(answer);
        }
        
        // logic
        
        for(int i=0;i<n;i++){
            if(isSafe(row,i)){
                // placing queen in grid if safe 
                grid[row][i] = true;
                // moving to next row reccursion
                backtracking(row+1);
                //backtracking reversing action
                grid[row][i] = false;
            }
        }
    }
    private boolean isSafe(int r,int c){
        //column check
        for(int i=r-1;i>=0;i--){
            if(grid[i][c]==true){
                return false;
            }
        }
        
        //left upward digonal
        int i=r, j=c;
        while(i>=0 && j>=0){
            if(grid[i][j]==true){
                return false;
            }
            i--;
            j--;
        }
        
        //right digonal upward
        
        while(r>=0 && c<n){
            if(grid[r][c]==true){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}