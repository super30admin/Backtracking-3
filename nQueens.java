// Time Complexity : O(n!)// at every level we decrease the number of choices we have for entering the queue 
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
class Solution {
    private List<List<String>> result;
    private boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        board = new boolean[n][n];

        helper(0, n);

        return result;
    }

    private void helper(int r, int n) {
        // base
        // if we reach the last row with all queens at correct position , we create a
        // string for every row and add it to the result.
        if (r == n) {
            List<String> sublist = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                sublist.add(sb.toString());
            }
            result.add(sublist);
            return;
        }

        // logic
        // iterate over all row and column and do backtracking
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

    // isSafe function - check if the queen has no queen in diagonals and column
    // already present.
    private boolean isSafe(int r, int c, int n) {
        // check in the column up
        for (int i = 0; i < r; i++) {
            if (board[i][c])
                return false;
        }
        // check diagonal up right
        int i = r, j = c;

        while (i >= 0 && j < n) {
            if (board[i][j])
                return false;

            i--;
            j++;
        }

        i = r;
        j = c;

        // check diagonal up left
        while (i >= 0 && j >= 0) {
            if (board[i][j])
                return false;

            i--;
            j--;
        }

        return true;
    }
}