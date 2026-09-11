time complexity is O(n!Xn ) so for every row if we have choice to n rows and next row is n-1 so its a n!. and inside every recusrive state we try O(n) columns in for loop
  Space complexity is O(n2) for board


class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];

        helper(board, 0, n);
        return result;
    }

    private void helper(boolean[][] board, int row, int n) {

        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;

        }

        for (int j = 0; j < n; j++) {

            if (isValid(board, row, j, n)) {

                board[row][j] = true;
                helper(board, row + 1, n);
                board[row][j] = false;
            }

        }

    }

    private boolean isValid(boolean[][] board, int i, int j, int n) {

        int r = i;
        int c = j;

        while (r >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
        }

        r = i;

        while (r >= 0 && c < n) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c++;
        }

        r = i;
        c = j;

        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }

        return true;
    }
}
