// Time Complexity : O(n!)
// Space Complexity : O(n ^ 2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

public class NQueens {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        
        if(n == 0) return result;
        board = new boolean[n][n];
        
        helper(0);
        
        return result;
    }
    
    private void helper(int row) {
        // base case
        if(row == board.length) {
            List<String> path = new ArrayList<>();
            
            for(int i = 0; i < board.length; i++) {
                StringBuilder string = new StringBuilder();
                
                for(int j = 0; j < board.length; j++) {
                    if(board[i][j]) {
                        string.append("Q");
                    } else {
                        string.append(".");
                    }
                }
                path.add(string.toString());
            }
            result.add(path);
            return;
        }
        
        // logic
        
        for(int i = 0; i < board.length; i++) {
            if(canPlace(row, i)) {
                // action
                board[row][i] = true;
                // recurse
                helper(row + 1);
                
                // backtrack
                board[row][i] = false;
            }
        }
    }
    
    private boolean canPlace(int r, int c) {
        
        for(int i = 0; i < r; i++) {
            if(board[i][c]) return false;
        }
        
        int i = r, j = c;
        
        while(i >=0 && j >= 0) {
            if(board[i--][j--]) return false;
        }
        
        i = r;
        j = c;
        
        while(i >= 0 && j < board.length) {
            if(board[i--][j++]) return false;
        }
        
        return true;
    }
}
