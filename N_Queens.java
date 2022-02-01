// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class N_Queens {
    List<List<String>> result;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        backtrack(0, n);
        return result;
    }

    private boolean isSafe(int row, int col, int n) {
        //  column up
        for (int i = 0; i <= row; ++i) {
            if (board[i][col])
                return false;
        }

        //  diagonal up left
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j])
                return false;

            i--;
            j--;
        }

        //  diagonal up right
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (board[i][j])
                return false;

            i--;
            j++;
        }

        //  safe
        return true;
    }

    private void backtrack(int row, int n) {
        //  base
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    if (board[i][j]) {
                        sb.append("Q");
                    }
                    else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        //  logic
        for (int j = 0; j < n; ++j) {
            if (isSafe(row, j, n)) {
                board[row][j] = true;
                backtrack(row + 1, n);
                board[row][j] = false;
            }
        }
    }
}
