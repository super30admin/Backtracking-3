// Time Complexity : O(N!)  // Each row tries N columns, pruning reduces possibilities
// Space Complexity : O(N)   // recursion stack + one array for column placements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Explanation:
// The code places queens row by row, checking for conflicts with previously placed queens.
// It uses DFS/backtracking to explore all valid configurations.
// Each valid placement is added to the solution list.

class Solution {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        result = new ArrayList<>();
        helper(n, 0, board);
        return result;
    }

    private void helper(int n, int r, boolean[][] board) {
        if (r == n) {
            result.add(changeBoard(board, n));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (canPut(r, c, n, board)) {
                board[r][c] = true;
                helper(n, r + 1, board);
                board[r][c] = false; // backtrack
            }
        }
    }

    private boolean canPut(int i, int j, int n, boolean[][] board) {
        // vertical check
        for (int r = 0; r < i; r++) {
            if (board[r][j]) {
                return false;
            }
        }

        // diagonal left-up
        int r = i - 1, c = j - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }

        // diagonal right-up
        r = i - 1;
        c = j + 1;
        while (r >= 0 && c < n) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    private List<String> changeBoard(boolean[][] board, int n) {
        List<String> formatted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j] ? 'Q' : '.');
            }
            formatted.add(sb.toString());
        }

        return formatted;
    }
}
