//Time Complexity: O(n!)
//Space Complexity: O(n^2)
// Did this code successfully run on Leetcode : Yes

import java.awt.*;
import java.util.ArrayList;

public class NQueens{
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m = n;
        boolean[][] board = new boolean[n][n];
        // null case
        if(n == 0) return result;
        backtrack(board, 0);
        return result;
    }

    private void backtrack(boolean [][] board, int row) {
        // base
        if(row == m) {
            List<String> li = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++) {
                    if(board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        // logic
        for(int j = 0; j < m; j++) {
            if(isSafe(board, row, j)) {
                // action
                board[row][j] = true;
                // recurse
                backtrack(board, row+1);
                // backtrack
                board[row][j] = false;
            }
        }
    }

    private boolean isSafe(boolean [][] board, int r, int c) {
        //check in same column above
        for(int i = 0; i < r; i++) {
            if(board[i][c]) return false;
        }
        //check diagonal up -> left
        int i = r; int j = c;
        while(i >= 0 && j >= 0) {
            if(board[i][j]) return false;
            i--; j--;
        }
        //check diagonal up -> right
        i = r; j = c;
        while(i >= 0 && j < m) {
            if(board[i][j]) return false;
            i--; j++;
        }
        return true;
    }
}
