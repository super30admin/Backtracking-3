// Time Complexity : O(m * n * 3^L) l=> length of the string
// Space Complexity : O(L)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We use backtracking to solve this
// We first see if we can find the first char in the string in the board, from that point we check all the directions to find the next character
// we change the character to '#' to specify that we have already visited that part of the board

class Solution {
    int[][] dirs;
    int m, n;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int index, int r, int c) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r == m || c == n || board[r][c] == '#')
            return false;
        if (board[r][c] == word.charAt(index)) {
            char ch = board[r][c];
            board[r][c] = '#';
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (backtrack(board, word, index + 1, nr, nc)) {
                    return true;
                }
            }
            board[r][c] = ch;
        }

        return false;
    }
}