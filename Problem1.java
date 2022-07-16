// Time Complexity : O(n!)
// Space Complexity : O(n) //
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//51. N-Queens
//https://leetcode.com/problems/n-queens/

class Solution {
    // time: O(n!)
    // space:
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {

        if (n == 0)
            return result;
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n); // to do the dfs

        return result;
    }

    private void helper(boolean[][] board, int r, int n) {
        // base
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < n; l++) {
                    if (board[k][l])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        // logic
        for (int i = r; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isSafe(board, i, j, n)) {
                    // action
                    board[i][j] = true;

                    // recursion
                    helper(board, i + 1, n);

                    // backtrack
                    board[i][j] = false;
                }
            }
            return;
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c, int n) {
        int i = r;
        int j = c;
        while (i > 0 && j > 0) {
            i--;
            j--;
            if (board[i][j] == true)
                return false;
        }

        i = r;
        j = c;
        while (i > 0 && j < n - 1) {
            i--;
            j++;
            if (board[i][j] == true)
                return false;
        }

        i = r;
        j = c;
        while (i > 0) {
            i--;
            if (board[i][j] == true)
                return false;
        }

        return true;
    }
}