// Time Complexity : exponential
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.*;
class NQueen {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        
        if(n == 2 || n == 3){
            return result;
        }
        
        board = new boolean[n][n];
        
        //we pass the row as the second param because we will iterate row by row
        helper(n, 0);
        
        return result;
    }
    
    private void helper(int n, int row){
        //base
        if(row == n){
            List<String> list = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                    
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        //logic
        for(int i = 0; i < n; i++){
            if(isSafe(row, i, n)){
                board[row][i] = true; //action
                helper(n, row + 1); //recurse
                board[row][i] = false; //backtrack
            }
        }
    }
    
    private boolean isSafe(int r, int c, int n){
        //column checks
        //there won't be queens below the given row so only check until given row
        for(int j = 0; j < r; j++){
            if(board[j][c])
                return false;
        }
        //diagonal left checks
        int i = r, j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]){
                return false;
            }
            i--;
            j--;
        }
        //diagonal right checks
        i = r;
        j = c;
        while(i >= 0 && j < n){
            if(board[i][j]){
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}