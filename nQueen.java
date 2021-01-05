// Time Complexity :O(N!)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode :Yes

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) {
            return result;
        }
        board = new int[n][n];
        backtrack(n, 0);
        return result;
    }

    private void backtrack(int n, int row) {
        //base case
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i=0; i< n;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++) {                
                    if(board[i][j] == 1) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');                
                    }
                }
                temp.add(sb.toString()); 
            }
            result.add(temp);
            return;
        }
       //logic
        for(int i=0;i<n;i++) {
            if(safeMove(row, i, n)) {
                //action
                board[row][i] = 1;
                //recurse
                backtrack(n, row + 1);   
                //backtrack
                board[row][i] = 0;
            }
        }
    }

    private boolean safeMove(int row, int col, int n) {
        //checking the column
        for(int i=row;i>=0;i--) {
            if(board[i][col] == 1) {
                return false;
            }
        }
        //upper left
        int i = row; int j = col;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        //upper right
        i = row; j = col;
        while(i >=0 && j < n) {
            if(board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}