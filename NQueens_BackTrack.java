import java.util.ArrayList;
import java.util.List;

/*
## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)

Time Complexity :   O (N!) 
Space Complexity :  O (N^2) 
Did this code successfully run on Leetcode :    Yes (51. N-Queens)
Any problem you faced while coding this :       No

 */
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

class NQueens_BackTrack {
    List<List<String>> result;
    int m;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m=n;
        
        boolean[][] board = new boolean[n][n];
        
        // null case
        if(n == 0)
            return result;
        
        backtrack(board, 0);
        return result;
    }
    private void backtrack(boolean[][] board, int r){
        // base
        if( r == m){
            List<String> li = new ArrayList<>();
            
            for(int i=0; i< m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<m; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li); 
        }
        
        //logic
        for(int c = 0; c< m; c++){
            if(isSafe(board, r, c)){
                // action
                board[r][c] = true;
                
                // recurse
                backtrack(board, r+1);
                
                // backtrack
                board[r][c] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int r, int c){
        // check if same column
        for(int i=0; i< r; i++){
            if(board[i][c])
                return false;
        }
        
        // check upper left diagonal
        int i = r;
        int j = c;
        while( i >= 0 && j>= 0){
            if(board[i][j])
                return false;
            i--;
            j--;
        }
        
        // check upper right diagonal
        i = r;
        j = c;
        while( i >= 0 && j < m){
            if(board[i][j])
                return false;
            i--;
            j++;
        }
        
        return true;
    }
}