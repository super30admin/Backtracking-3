// Time Complexity : O(N!)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class WordSearch {
    private List<List<String>> result;
    private boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        helper(0, n);
        return result;
    }

    private void helper(int r, int n) {
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
        for (int j = 0; j < n; j++) {
            if (isSafe(r, j, n)) {
                board[r][j] = true;
                helper(r + 1, n);
                board[r][j] = false;
            }
        }
    }


    private boolean isSafe(int r, int c, int n) {
        for (int i = 0; i < r; i++) {
            if (board[i][c])
                return false;
        }
        int i = r, j = c;
        while (i >= 0 && j < n) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        i = r;
        j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}