// Time Complexity : O(mn4^L) where m and n are the dimensions of the board, L is 4^L accounts for the
//                            four possible directions (up, down, left, right) for each character in the word
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




/*

Approach:

Iterate through each cell on the board and check
if the first character of the word matches the current cell.
If it does, it starts a DFS from that cell to explore all
possible paths while marking visited cells.

During the DFS, it checks adjacent cells in four directions
(up, down, left, right) to match the characters in the word,
effectively searching for the entire word.

If it successfully finds the entire word along a path,
it returns true; otherwise, it backtracks by restoring
visited cells, and if no path is found, it returns false.

 */

class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char original = board[i][j];
        board[i][j] = '#'; // Mark the cell as visited

        boolean found = dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i, j - 1, index + 1);

        board[i][j] = original; // Restore the original character

        return found;
    }
}
