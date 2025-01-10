// Time Complexity : 0(n!)
// Space Complexity : 0(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    //aesha
    List<List<String>> result;
    Boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new Boolean[n][n];
        
        // Initialize the board with false (no queens placed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = false;
            }
        }

        helper(0, n);
        return result;
    }

    public void helper(int i, int n)
    {
        //base case
        if (i == n) {
            List<String> path = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (board[r][c]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                path.add(sb.toString());
            }
            result.add(path);
            return;
        }
        //logic
        for(int j = 0;j<n ; j++)
        {
            if(isSafe(i,j,n))
            {
                board[i][j] = true;
                helper(i+1,n);
                board[i][j] = false;
            } 

        }
    }

    public boolean isSafe(int i, int j, int n) {
        // Check column
        int r = i, c = j;
        while (r >= 0) {
            if (board[r][c]) return false;
            r--;
        }

        // Check left diagonal
        r = i; c = j;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) return false;
            r--; c--;
        }

        // Check right diagonal
        r = i; c = j;
        while (r >= 0 && c < n) {
            if (board[r][c]) return false;
            r--; c++;
        }

        return true;
    }
}