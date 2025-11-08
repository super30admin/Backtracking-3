/**
 * N-Queens Problem (LeetCode 51: https://leetcode.com/problems/n-queens/)
 * Approach: Backtracking - Place queens row by row, checking for column and diagonal conflicts.
 * Time Complexity: O(N!), where N is the number of queens (and board size).
 * Space Complexity: O(N^2) for the board and result storage.
 */

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private boolean[][] board;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board  = new boolean[n][n];
        helper(0, n);
        return result;
    }

    private void helper(int r, int n) {
        //base
        if (r == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) builder.append("Q");
                    else builder.append(".");
                }
                list.add(builder.toString());
            }
            result.add(list);
        }


        //logic
        for (int i = 0; i < n; i++) {
            if (isSafe(r, i)) {
                //action
                board[r][i] = true;
                //recursion
                helper(r + 1, n);
                //backtrack
                board[r][i] = false;
            }
        }
    }

    private boolean isSafe(int r, int c) {
        //up direction
        for (int i = 0; i < r; i++) {
            if (board[i][c]) return false;
        }

        int i = r;
        int j = c;
        //Diagonal up left
        while (i >= 0 && j >= 0) {
            if (board[i][j]) return false;
            i--;
            j--;
        }

        i = r;
        j = c;
        //Diagonal up right
        while (i >= 0 && j < board[0].length) {
            if (board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}
