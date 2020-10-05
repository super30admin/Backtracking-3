// Time Complexity : SInce at each every new row we have n-2 then n-4 then n-6 options O(n!) and we for issafe it is O(n) 
// So O(n! *n)
// Space Complexity : O(n^2) since we have matrix
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
Here we pass the row 0 to helper function which is doing backtrack.
Our base condition for this backtrack is if row>n
else for int col = 0 to n for each row we see that the i,j is safe or not (isSafe)
THe isSafe function sees if i,j is safe from Left diagonal(i-1,j-1), col above(i-1, j)and (i-1,j+1)right diagonal 

*/

class Solution {
    List<List<String>> result;
    int m;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new LinkedList<>();
        m = n;
        board = new boolean[m][m];

        helper(0);
        return result;
    }

    public void helper(int r) {
        if (r == m) {
            addToResult();

        }
        for (int j = 0; j < m; j++) {

            if (isSafe(r, j)) {
                // place queen if safe
                board[r][j] = true;

                // progress
                helper(r + 1);

                // remove the queen from the board
                board[r][j] = false;
            }
        }
    }

    public boolean isSafe(int r, int c) {
        for (int row = 0; row < r; row++)
            if (board[row][c] == true)
                return false;

        for (int row = r - 1, col = c + 1; ((row >= 0) && (col < m)); row--, col++)
            if (board[row][col] == true)
                return false;

        for (int row = r - 1, col = c - 1; ((row >= 0) && (col >= 0)); row--, col--)
            if (board[row][col] == true)
                return false;

        return true;

    }

    private void addToResult() {
        List<String> chessboard = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sbr = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == true)
                    sbr.append("Q");
                else
                    sbr.append(".");
            }
            chessboard.add(sbr.toString());
        }
        result.add(chessboard);
    }

}