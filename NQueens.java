// Time Complexity : O(n^(n+2))
// Space Complexity : O(n^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(board, 0);
        return result;
    }

    private void backtrack(boolean[][] board, int i) {
        // base

        if (i == board.length) {
            List<String> li = new ArrayList<>();
            for (int r = 0; r < board.length; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < board.length; c++) {
                    if (board[r][c]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        // logic
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, i, j)) {
                board[i][j] = true;
                backtrack(board, i + 1);
                board[i][j] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c])
                return false;
        }

        int i = r, j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j])
                return false;
            i--;
            j--;
        }

        i = r;
        j = c;
        while (i >= 0 && j < board.length) {
            if (board[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create an instance of SolveNQueens
        NQueens obj = new NQueens();

        // Solve the N-Queens problem
        int n = 4;
        List<List<String>> solutions = obj.solveNQueens(n);

        // Print the solutions
        System.out.println("Solutions for N-Queens problem with N = " + n + ":");
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}