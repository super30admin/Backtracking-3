// Time Complexity : O(N!) 
// Space Complexity : O(N*N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Add the queen at a position.
// Check if the position is safe. If yes continue if not change it. 
// If we dont get any good position for our current position then backtrack and change the previsous posiiton.

class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        helper(0, n);
        return result;
    }

    public void helper(int r, int  n) {
        if(r == n) {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++) {
                String row = "";
                for(int j=0;j<n;j++) {
                    if(board[i][j] == 0) row += ".";
                    else if(board[i][j] == 1) row += "Q";
                }
                temp.add(row);
            }
            result.add(temp);
            return;
        }

        for(int i=0;i<n;i++) {
            if(isSafe(r, i, n)) {
                //action
                board[r][i] = 1;
                helper(r+1, n);
                //backtrack
                board[r][i] = 0;
            }
        }
    }

    public boolean isSafe(int r, int c, int n) {
        for(int i=0;i<r;i++) {
            if(board[i][c] == 1) return false;
        }
        int i = r; int j = c;
        while(i>=0 && j>=0) {
            if(board[i][j] == 1) return false;
            i--; j--;
        }
        i = r; j = c;
        while(i>=0 && j<n) {
            if(board[i][j] == 1) return false;
             i--; j++;
        }
       return true; 
    }
}
