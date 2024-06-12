// Problem1 : (https://leetcode.com/problems/n-queens/)
//Time Complexity : O(n*n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// I have used backtracking to solve this problem. I have used a boolean board to keep track of the queens placed on the board. 
//I have used isSafe method to check if the queen can be placed at a particular position or not. 
//I have used helper method to place the queens on the board and then backtrack if the queen cannot be placed at a particular position.


class Solution {
   List<List<String>> result;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        helper(0, n);
        return result;
    }

    private void helper(int i, int n) {
        if (i == n) {
            List<String> li = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (board[r][c]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(i, j, n)) {
                board[i][j] = true;
                helper(i + 1, n);
                board[i][j] = false;
            }
        }
    }

    private boolean isSafe(int i, int j, int n) {
        int r = i, c = j;
        while (r >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
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
        r = i;
        c = j;
        while (r >= 0 && c < n) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}
