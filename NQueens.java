// Time Complexity: O(n!)
// Space Complexity: O(n * n)
// Ran succesfully on Leetcode: yes

class Solution {

    List<List<String>> ans = new ArrayList<>();
    boolean [] diaL;
    boolean [] diaR;
    boolean [] col;

    public List<List<String>> solveNQueens(int n) {
        diaL = new boolean[n + n];
        diaR =  new boolean[n + n];
        col = new boolean[n];
        char [][] board = new char[n][n];
        // first fill the board
        for(int i = 0; i < n; i++)
            Arrays.fill(board[i],'.');
        helper(0, n, board);
        return ans;
    }

    private void helper(int r, int n, char [][] board) {
        if (n == r) {
            // add current board as a String to the answer and return
            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(String.valueOf(board[i]));

            }
            ans.add(res);
            return;
        }
        for (int c = 0; c < n; c++) {
            // if column is valid use backtracting to fill, move to the next row and backtrack
            if(isValid(r, c, n)) {
                // action
                board[r][c] = 'Q';

                diaL[r - c + n] = true;
                diaR[r + c] = true;
                col[c] = true;
                // recursion
                helper(r + 1, n, board);

                // backtracking
                board[r][c] = '.';

                diaL[r - c + n] = false;
                diaR[r + c] = false;
                col[c] = false;
            }
        }
    }
    public boolean isValid(int r, int c, int n) {
        return !(diaL[r - c + n] || diaR[r + c] || col[c]);

    }
}