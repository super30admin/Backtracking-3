// Time Complexity : O(m*n*4^l) m*n matrix and l is the length of the word.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    int[][] dirs;
    int m, n;

    public boolean exist(char[][] board, String word) {
        // null check
        if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wordSearch(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean wordSearch(char[][] board, String word, int index, int i, int j) {
        // base
        if (index == word.length())
            return true;
        if (i < 0 || i == m || j < 0 || j == n || board[i][j] == '#')
            return false;
        // logic
        if (board[i][j] == word.charAt(index)) {
            char ch = word.charAt(index);
            // action
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                // recurse
                if (wordSearch(board, word, index + 1, r, c))
                    return true;
            }
            // backtrack
            board[i][j] = ch;
        }
        return false;
    }

}