import java.util.*;

//tc is O(3^n)
//sc is O(n)
class Solution {
    List<List<String>> result;
    boolean[][] grid;
    int n;

    public List<List<String>> solveNQueens(int n) {

        if (n == 0)
            return new ArrayList<>();

        result = new ArrayList<>();
        this.n = n;
        grid = new boolean[n][n];

        backtrack(0);

        return result;

    }

    private void backtrack(int row) {
        // base
        if (row == n) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (grid[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }

                answer.add(sb.toString());
            }

            result.add(answer);
            return;

        }

        // logic
        // we run through all cols

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                // action
                grid[row][col] = true;

                // recurse
                backtrack(row + 1);

                // backtrack
                grid[row][col] = false;
            }
        }
    }

    private boolean isSafe(int row, int col) {
        // check the col above for queen

        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == true) {
                return false;
            }
        }

        // checking upper left diagonal

        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (grid[i][j] == true) {
                return false;
            }

            i--;
            j--;
        }

        // checking upper right diagonal

        i = row - 1;
        j = col + 1;

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