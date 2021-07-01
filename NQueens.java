// TC: O(n!)
// SC: O(n^2)
class Solution {
    int[][] board;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        board = new int[n][n];
        res = new ArrayList<>();
        backtrack(n, 0);
        return res;
    }
    private void backtrack(int n, int row) {
        int i, j;
        if(row == n) {
            List<String> l = new ArrayList<>();
            for(i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(j = 0; j < n; j++) {
                    if(board[i][j] == 1) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                l.add(sb.toString());
            }
            res.add(l);
            return;
        }
        for(i = 0; i < n; i++) {
            if(isSafe(row, i, n)) {
                board[row][i] = 1;
                backtrack(n, row + 1);
                board[row][i] = 0;
            }
        }
    }
    private boolean isSafe(int r, int c, int n) {
        int i, j;
        //column up
        for(i = 0; i < r; i++) {
            if(board[i][c] == 1) return false;
        }
        // left diagonal up
        i = r;
        j = c;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }
        // right diagonal up
        i = r;
        j = c;
        while(i >= 0 && j < n) {
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }
}