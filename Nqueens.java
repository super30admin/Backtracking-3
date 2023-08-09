// Time Complexity : O(N^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.*;
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[][] board = new int[n][n];
        recurse(n, 0, board);
        return result;
    }

    public void recurse(int n, int row, int[][] board){
        if(row == n){
            List<String> val = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder temp = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(board[i][j] == 1){
                        temp.append("Q");
                    }
                    else {
                        temp.append(".");
                    }
                }
                val.add(temp.toString());
            }
            this.result.add(val);
            return;
        }
        // System.out.println
        for(int i=0; i<n; i++){
            if(isSafe(board, new int[] {row, i})){
                board[row][i] = 1;
                recurse(n, row+1, board);
                board[row][i] = 0;
            }
        }

    }

    public boolean isSafe(int[][] board, int[] pos){
        int row = pos[0];
        int col = pos[1];
        for(int i= row; i>=0; i--){
            if(board[i][col] == 1)
                return false;
        }
        
        while(row >=0 && col >=0){
            if(board[row][col] == 1)
                return false;
            row--;
            col--;
        }
        row = pos[0];
        col = pos[1];
        while(row >=0 && col < board[0].length){
            if(board[row][col] == 1)
                return false;
            row--;
            col++;
        }
        return true;
    }
}