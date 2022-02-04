// Time Complexity: O(n!) where n is number of rows
// Space Complexity: O(n)

import java.util.*;
class Solution {
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        int r = 0;
        board = new boolean[n][n];
        backtrack(n, r, res);
        return res;
    }
    
    private void backtrack(int n, int r, List<List<String>> res){
        //base
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }
        
        //logic
        for(int c=0; c<n; c++){
            if(isSafe(r,c)){
                //action
                board[r][c] = true;
                //recurse
                backtrack(n, r+1, res);
                //backtrack
                board[r][c] = false;
            }
        }
    }
    private boolean isSafe(int r, int c){
        //check column
        for(int i=0; i<=r; i++){
            if(board[i][c]){
                return false;
            }
        }
        //check diagnal up left and right
        int i=r, j=c;
        while(i >=0 && j >= 0){
            if(board[i][j]){
                return false;
            }
            i--;j--;
        }
        i=r; j = c;
        while(i >= 0 && j < board.length){
            if(board[i][j]){
                return false;
            }
            i--; j++;
        }
        
        return true;
    }
}