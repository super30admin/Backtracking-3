// Time Complexity : O(n!) ->n - number of rows
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    
    List<List<String>> result;
    boolean [][] board;
    int rows;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        rows = n;
        if(n == 0) return result;
        backtrack(0);
        return result;
    }
    
    private void backtrack(int r) {
        //base case
        if(r == rows) {
            List<String> list = new ArrayList<>();
            for(int i=0; i<rows; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<rows; j++) {
                    if(board[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        
        for(int i=0; i<rows; i++) {
            if(isSafe(r,i)) {
                //action
                board[r][i] = true;
                //recurse
                backtrack(r+1);
                //backtrack
                board[r][i] = false;
            }
        }   
    }
    
    private boolean isSafe(int r, int c) {
        //column up
        for(int i=0; i<rows; i++) {
            if(board[i][c]) return false;
        }
        
        //diagonal up right
        int i = r; int j = c;
        while(i >= 0 && j < rows){
            if(board[i][j]) return false;
            i--; j++;
        }
        
        //diagonal up left
        i = r; j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]) return false;
            i--; j--;
        }
        return true;
    }
    
}