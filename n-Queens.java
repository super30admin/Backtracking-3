import java.util.*;

class Solution {
    //Backtracking Solution
    // Time complexity is exponential (n!)
    // Space complexity is O(n^2)
    // This solution is submitted on leetcode with zero errors
    private List<List<String>> result;
    private int len;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        len = n;
        //Edge case
        if( n == 0) return result;
        boolean[][] board = new boolean[n][n];
        helper(board,0);
        return result;
    }
    
    private void helper(boolean[][] board, int row){
        // Base case
        if(row == len){
            List<String> li = new ArrayList<>();
            for(int a = 0; a<len;a++){
                StringBuilder sb = new StringBuilder();
                for(int b = 0;b<len; b++){
                    if(board[a][b])
                        sb.append('Q');
                    else 
                        sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        // Logic
        for(int i = 0; i<len;i++){
            if(isSafe(board,row, i)){
                //action
                board[row][i] = true;
                // recurse
                helper(board, row+1);
                //backtrack
                board[row][i] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int c, int d){
        // check up
        for(int k = 0; k<c;k++){
            if(board[k][d]) return false;
        }
        
        // left diagonal check
        int nc = c;
        int nd = d;
        while(nc>=0 && nd>=0){
            if(board[nc][nd]) return false;
            nc--;
            nd--;
        }
        // right diagonal check
        nc = c;
        nd = d;
        while(nc>=0 && nd< len){
            if(board[nc][nd]) return false;
            nc--;
            nd++;
        }
        return true;
    }
}