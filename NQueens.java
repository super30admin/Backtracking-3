//T: O(n^n)
//S: O(n^2)
class Solution {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 0)
            return result;
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);
        return result;
    }

    private void helper(boolean[][] board, int r, int n) {
        // base
        if (r >= n) {
            List<String> li = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());

            }
            result.add(li);
        }
        // logic
        for (int j = 0; j < n; j++) {
            if (isSafe(board, r, j, n)) {
                board[r][j] = true;
                helper(board, r + 1, n);
                board[r][j] = false;
            }
        }

    }

    private boolean isSafe(boolean[][] board, int r, int c, int n) {
        // up col
        for (int x = 0; x < r; x++) {
            if (board[x][c])
                return false;
        }
        int i = r;
        int j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j])
                return false;
            i--;
            j--;
        }
        int a = r;
        int b = c;
        while (a >= 0 && b < n) {
            if (board[a][b])
                return false;
            a--;
            b++;
        }
        return true;
    }
}