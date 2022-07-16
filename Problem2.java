// Time Complexity : O(mxnx3^l)
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//79. Word Search
//https://leetcode.com/problems/word-search/

class Solution {
    // time: O(mxnx3^l) where l is the length of the word
    // space: O(l)
    int m;
    int n;
    int counter;
    boolean flag = false;
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '#';
                    helper(board, i, j, word, counter + 1);
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return flag;
    }

    private void helper(char[][] board, int i, int j, String word, int counter) {
        // base
        if (word.length() == counter) {
            flag = true;
            return;
        }
        if ((i < 0 || j < 0 || i > m || j > n))
            return;

        // logic
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if ((row >= 0 && col >= 0 && row < m && col < n) && (board[row][col] == word.charAt(counter))) {
                // action
                board[row][col] = '#';

                // recursion
                helper(board, row, col, word, counter + 1);

                // backtrack
                board[row][col] = word.charAt(counter);

            }

        }

    }

}