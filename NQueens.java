import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N!)
// Space Complexity : O(N^2)

// We start with inserting queen from the first row (by marking it in boolean board)
// We recurse this to next row while checking each column if isSafe or not
// IsSafe is determined by looking up column wise, diagonal left and diagonal right on boolean board
// When returning from recusrsion we backtrack the marked Queen in boolean board
// Once we get to the last row, thats our solution. We add it to result. 

class PlacingNQueens {
    List<List<String>> result;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 0)
            return result;
        board = new boolean[n][n];
        helper(0, n);
        return result;
    }

    private void helper(int r, int n) {
        // base
        if (r == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }
        ;

        // logic
        for (int j = 0; j < n; j++) {
            if (isSafe(r, j, n)) {
                // action
                board[r][j] = true;
                // recurse
                helper(r + 1, n);
                // backtrack
                board[r][j] = false;
            }
        }
    }

    private boolean isSafe(int r, int c, int n) {
        // Column up
        for (int i = 0; i < r; i++) {
            if (board[i][c])
                return false;
        }
        // Diagonal up left
        int i = r, j = c;
        while (i >= 0 && j < n) {
            if (board[i][j])
                return false;
            i--;
            j++;
        }
        // Diagonal up right
        i = r;
        j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j])
                return false;
            i--;
            j--;
        }
        return true;
    }
}