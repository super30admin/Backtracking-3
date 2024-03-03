// Time Complexity : O(n* m* 2 ^ n)
// Space Complexity : O(n* m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> results;
    boolean[][] board;
    int n;

    public List<List<String>> solveNQueens(int n) {
        results = new ArrayList<>();
        this.n = n;
        board = new boolean[this.n][this.n];
        heleprRecursion(0);
        return results;
    }

    private void heleprRecursion(int row) {
        // base
        if (row == this.n) {
            List<String> li = new ArrayList<>();
            for (int i = 0; i < this.n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < this.n; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            results.add(li);
            return;
        }

        for (int col = 0; col < this.n; col++) {
            if (isValidQueenPos(row, col)) {
                // action
                board[row][col] = true;
                // recurse
                heleprRecursion(row + 1);
                // backtrack
                board[row][col] = false;
            }
        }
    }

    private boolean isValidQueenPos(int r, int c) {
        for(int i = 0; i< r; i++) {
            if(board[i][c] == true) {
                return false;
            }
        }

        int i= r;
        int j = c;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }

        i = r;
        j = c;    
         while(i >= 0 && j < this.n) {
            if(board[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}