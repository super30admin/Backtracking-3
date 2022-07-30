import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n!) due to the available choices to place the queen reducing at each row.
//Space Complexity: O(n*n) + Recursive stack space, (n*n)=for the grid used 

class Solution {
    List<List<String>> result;
    boolean[][] grid;
    int n;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 0)
            return result;
        grid = new boolean[n][n];
        this.n = n;

        backtrack(0); // row
        return result;
    }

    private void backtrack(int row) {
        // base
        if (row == n) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < n; i++) { // for each row creating a new string builder.
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == true) {
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
        for (int i = 0; i < n; i++) { // for each row traversing all columns
            if (IsSafe(row, i)) { // checking if cell[row][i] is safe to place a queen
                // action
                grid[row][i] = true;
                // recurse
                backtrack(row + 1);
                // backtrack
                grid[row][i] = false;
            }
        }
    }

    private boolean IsSafe(int r, int c) {

        // column check - checking if the columns above current cell contain any queen
        for (int i = r - 1; i >= 0; i--) {
            if (grid[i][c] == true) {
                return false;
            }
        }

        // left diagonal check
        int i = r;
        int j = c;
        while (i >= 0 && j >= 0) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }

        // right diagonal check
        i = r;
        j = c;
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