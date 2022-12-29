// N-QUEENS

// Time Complexity : nPn = n!
// Space Complexity : N^2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    private List<List<String>> result;
    private boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        helper(0, n);
        return result;
    }
    private void helper(int r, int n){
        //base - Stop after traversing all the rows
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        //logic
        for(int j = 0; j < n; j++){
            if(isSafe(r,j,n)){
                //action
                board[r][j] = true;
                //recurse
                helper(r+1, n);
                //backtrack
                board[r][j] = false;
            }
        }
    }
    private boolean isSafe(int r, int c, int n){
        //Column-up
        for(int i = 0; i < r; i++){
            if(board[i][c])
                return false;
        }
        //Diagonal-right
        int i = r, j = c;
        while(i >= 0 && j < n){
            if(board[i][j])
                return false;
            i--;
            j++;
        }
        //Diagonal-left
        i = r;
        j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j])
                return false;
            i--;
            j--;
        }
        return true;
    }
}