
/**
 * Time complexity: n! 
 * Space complexity: O(n ^ 2) since we are using n * n grid;
 */

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    boolean[][] grid;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        grid = new boolean[n][n];
        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        // base
        if (row == n) {
            List<String> subResult = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == true) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }

                }
                subResult.add(sb.toString());
            }
            result.add(subResult);
            return;
        }

        // logic
        for (int i = 0; i < n; i++) {
            if (canPlaceQueen(row, i, n)) {
                // action
                grid[row][i] = true;
                // recurse
                backtrack(row + 1, n);
                // backtrack
                grid[row][i] = false;
            }
        }
    }

    private boolean canPlaceQueen(int row, int col, int n) {
        // check if any queen is placed on previous rows.
        for (int i = row; i >= 0; i--) {
            if (grid[i][col] == true) {
                return false;
            }
        }

        int i = row;
        int j = col;
        // check if any queen is placed diagonally left on previous rows.
        while (i >= 0 && j >= 0) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        // check if any queen is placed diagonally right on previous rows.
        while (i >= 0 && j < n) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
