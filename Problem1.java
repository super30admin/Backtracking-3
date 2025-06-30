//N Queens(https://leetcode.com/problems/n-queens/)

// Time Complexity : O(n!)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//for every row, we look at all possible places(coloumn) we can put queen,(using for loop and backtracking) and use recursion to 
//check for every queen, every row

class Solution {
    boolean[][] grid;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result=new ArrayList<>();
        this.grid = new boolean[n][n];
        helper(0,n);
        return result;
    }
    private void helper(int row, int n){
        //base
        if(row==n){
            List<String> r = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder s= new StringBuilder();
                for(int j=0;j<n;j++){
                    if(grid[i][j]==true)s.append('Q');
                    else s.append('.');
                }
                r.add(s.toString());
            }
            result.add(r);
            return;
        }
        //logic
        for(int j=0;j<n;j++){
            if(isSafe(row,j,n)){
                //action
                grid[row][j]=true;
                //recurse
                helper(row+1,n);
                //backtrack
                grid[row][j]=false;
            }
        }
    }
    private boolean isSafe(int row, int coloumn, int n){
        //column up
        for(int i=0;i<row;i++){
            if(grid[i][coloumn]) return false;
        }
        //diagonal right up
        int i=row; int j=coloumn;
        while(i>=0 && j<n){
            if(grid[i][j]) return false;
            i--;j++;
        }
        //diagonal right up
        i=row;j=coloumn;
        while(i>=0&&j>=0){
            if(grid[i][j]) return false;
            i--;j--;
        }
        return true;
    }
}