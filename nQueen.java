class nQueens {

    // TC: O(N!) SC: O(N^2)
    List<List<String>> result;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        backtrack(0);
        return result;
    }

    private void backtrack(int r) {
        // base
        if (r == board.length) {
            List<String> li = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == true) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        // logic
        for (int j = 0; j < board.length; j++) {
            if (isSafe(r, j)) {
                // action
                board[r][j] = true;
                // recurse
                backtrack(r + 1);
                // backtrack
                board[r][j] = false;
            }
        }
    }

    private boolean isSafe(int r, int c) {
        // col check
        for (int i = 0; i < r; i++) {
            if (board[i][c] == true)
                return false;
        }

        // diagonal up left
        int i = r;
        int j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == true)
                return false;
            i--;
            j--;
        }
        // diagonal up right
        i = r;
        j = c;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == true)
                return false;
            i--;
            j++;
        }
        return true;
    }
}