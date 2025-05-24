// Time Complexity : O(n!), n = no of queens and size of board
// Space Complexity : O(n^2), boolean board
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - We use a backtracking approach to explore all valid placements of queens row by row.
//   - For each row, we attempt to place a queen in each column if it is valid (i.e., not attacked).
//   - A position is valid if no queen exists in the same column, and both diagonals above.
//   - Once we fill all n rows with valid queen placements, we convert the board into a list of strings.
//   - Backtrack after each recursive call to explore other configurations.

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);
        return result;
    }

    private void helper(boolean[][] board, int row, int n) {
        // base condition
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j] ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(board, row, j, n)) {
                // action
                board[row][j] = true;
                // recurse
                helper(board, row + 1, n);
                // backtrack
                board[row][j] = false;
            }
        }
    }

    private boolean isValid(boolean[][] board, int i, int j, int n) {
        int r = i, c = j;

        // check straight above
        while (r >= 0) {
            if (board[r][c]) return false;
            r--;
        }

        // check diagonal left up
        r = i;
        c = j;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) return false;
            r--;
            c--;
        }

        // check diagonal right up
        r = i;
        c = j;
        while (r >= 0 && c < n) {
            if (board[r][c]) return false;
            r--;
            c++;
        }

        return true;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();
        int n = 4; // Try with different values of n
        List<List<String>> solutions = solver.solveNQueens(n);

        System.out.println("Number of solutions for " + n + "-Queens: " + solutions.size());
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
