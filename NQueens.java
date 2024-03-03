// Time complexity: n!
// Space complexity: n*n

// Approach
// Use dfs to put queen at every row; before placing a queen
// check if they are eligible to place; if yes; proceed to the next row
// if not; backtrack

import java.util.ArrayList;
import java.util.List;

class NQueens {
    boolean[][] matrix;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList();
        this.matrix = new boolean[n][n];
        dfs(0, matrix);
        return res;
    }

    private void dfs(int rowIndex, boolean[][] matrix) {
        // all queens have been placed
        if (rowIndex == matrix.length) {
            // will contain all the rows
            List<String> current = new ArrayList();

            for (int i = 0; i < matrix.length; i++) {
                StringBuilder rowString = new StringBuilder();
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j]) {
                        rowString.append("Q");
                    } else {
                        rowString.append(".");
                    }
                }
                current.add(rowString.toString());
            }
            res.add(current);
            return;
        }

        // logic
        for (int col = 0; col < matrix[0].length; col++) {
            if (canPlace(matrix, rowIndex, col)) {
                matrix[rowIndex][col] = true;
                dfs(rowIndex + 1, matrix);
                matrix[rowIndex][col] = false;
            }
        }
    }

    private boolean canPlace(boolean[][] matrix, int row, int column) {
        int i = row - 1;
        int j = column;

        // check same column
        while (i >= 0) {
            if (matrix[i][j]) {
                return false;
            }
            i--;
        }

        // diagonal left
        i = row - 1;
        j = column - 1;
        while (i >= 0 && j >= 0) {
            if (matrix[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        // diagonal right
        i = row - 1;
        j = column + 1;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j]) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}