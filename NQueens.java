// Time Complexity : O(Exponential) or O(n^n)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We solve this question using backtracking
// Use a boolean chess board to keep track of the placed queens
class Solution {
    boolean[][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 0) return result;
        board = new boolean[n][n];

        backtrack(0);

        return result;
    }

    private void backtrack(int r) {
        // base
        // if we have placed all the queens we can return the config
        if (r == board.length) {
            List<String> ans = new ArrayList<>();

            for (int i=0; i<board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<board[0].length; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;     // we need to return since we can try another combination of the queens
        }


        // logic
        // traverse each row
        for (int j=0; j<board[0].length; j++) {
            // check if its safe to place the queen at this r and c
            if (isSafe(r, j)) {
                // action
                board[r][j] = true;

                // recurse
                backtrack(r+1);

                // backtrack
                board[r][j] = false;
            }
        }
    }

    private boolean isSafe(int r, int c) {
        // check col
        for (int i=r; i>=0; i--) {
            if (board[i][c] == true) {
                return false;
            }
        }

        // check diagonal upper left
        int i=r, j=c;
        while (i>=0 && j>=0) {
            if (board[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }

        // check diagonal upper right
        i=r; j=c;
        while (i>=0 && j<board.length) {
            if (board[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}