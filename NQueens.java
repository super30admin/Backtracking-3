class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        helper(board, 0, n);
        return result;
    }
    private boolean helper(int[][] board, int row, int n) {
        // base
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i ++) {
                StringBuilder tempRow = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 0) {
                        tempRow.append(".");
                    } else {
                        tempRow.append("Q");
                    }
                }
                temp.add(tempRow.toString());
            }
            result.add(temp);
            return false;
        }
        for(int i = 0; i < n; i++) {
            if(isSafe(board, row, i, n)) {
                board[row][i] = 1;
                if(helper(board, row + 1, n)) {
                    return true;
                }
                board[row][i] = 0;
            }
        }
        return false;
    }
    private boolean isSafe(int[][] board, int r, int c, int n) {
        for(int i = 0; i < r; i++) {
            if(board[i][c] == 1) {
                return false;
            }
        }
        int i = r - 1;
        int j = c - 1;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        i = r - 1;
        j = c + 1;
        while(i >= 0 && j < n) {
            if(board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}