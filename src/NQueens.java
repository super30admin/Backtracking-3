class NQueens {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, 0);
        return result;
    }

    private void helper(char[][] board, int col) {
        //base case
        if(col == board.length) {
            result.add(buildSolution(board));
            return;
        }
        //logic
        for(int row = 0; row < board.length; row++) {
            if(isSafe(board,row,col)) {
                board[row][col] = 'Q';
                helper(board, col + 1);
                board[row][col] = '.';
            }
        }
    }

    private List<String> buildSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for(char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        // Check the row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        
        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check lower diagonal on left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
}