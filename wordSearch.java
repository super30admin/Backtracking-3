// Time Complexity : O(3^L), l is length of the string
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * we go thorugh every index in the matrix and check if that char is present in the word.
 * If so, we change it to visited and check for neighbouring directions and if we find the word it return true.
* else bracktrack.
*/
class Solution {
    private int[][] dirs;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j, m, n))
                    return true;
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, int r, int c, int m, int n) {
        // base
        if (idx == word.length())
            return true;

        if (r < 0 || c < 0 || r == m || c == n || board[r][c] == '#')
            return false;

        // logic
        if (word.charAt(idx) == board[r][c]) {
            // action
            board[r][c] = '#';

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                // recurse
                if (backtrack(board, word, idx + 1, nr, nc, m, n)) {
                    return true;
                }
            }
            // backtrack
            board[r][c] = word.charAt(idx);
        }

        return false;
    }
}