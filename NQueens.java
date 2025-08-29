// Time Complexity : ~O(n!) — classic N-Queens backtracking (each row chooses a column that doesn't conflict).
// Space Complexity : O(n^2) for the board plus O(n) recursion depth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N0
//
// Approach (Backtracking with validity checks):
// - Place one queen per row.
// - For each row, try each column j. Place if it's valid (no queen in same column, upper-left diag, upper-right diag).
// - When row == n, convert the boolean board to a list of strings and add to result.
// - Backtrack: unset the queen and try next column.
//
// Notes:
// - Validity checks only look "upwards" (previous rows) because we place row by row top→down.
// - For faster solutions, you can maintain 3 hash-sets (cols, diag, anti-diag) or use bitmasks to make isValid O(1).

import java.util.*;

public class NQueens {

    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);
        return result;
    }

    private void helper(boolean[][] board, int row, int n) {
        // If all rows are filled, record the board and return
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j] ? 'Q' : '.');
                }
                list.add(sb.toString());
            }
            result.add(list);
            return; // IMPORTANT: avoid proceeding to the for-loop with row == n
        }

        // Try placing a queen in each column of this row
        for (int j = 0; j < n; j++) {
            if (isValid(board, row, j, n)) {
                board[row][j] = true;          // choose
                helper(board, row + 1, n);     // explore
                board[row][j] = false;         // un-choose (backtrack)
            }
        }
    }

    // Check column up, upper-left diag, upper-right diag
    private boolean isValid(boolean[][] board, int i, int j, int n) {
        // Check same column upwards
        for (int r = i - 1; r >= 0; r--) {
            if (board[r][j]) return false;
        }
        // Check upper-left diagonal
        for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }
        // Check upper-right diagonal
        for (int r = i - 1, c = j + 1; r >= 0 && c < n; r--, c++) {
            if (board[r][c]) return false;
        }
        return true;
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        NQueens solver = new NQueens();

        int n1 = 4;
        List<List<String>> res1 = solver.solveNQueens(n1);
        System.out.println("Solutions for n = " + n1 + " (count = " + res1.size() + "):");
        for (List<String> board : res1) {
            for (String row : board) System.out.println(row);
            System.out.println();
        }

        int n2 = 1;
        List<List<String>> res2 = solver.solveNQueens(n2);
        System.out.println("Solutions for n = " + n2 + " (count = " + res2.size() + "):");
        for (List<String> board : res2) {
            for (String row : board) System.out.println(row);
            System.out.println();
        }
    }
}