// Time Complexity : O(m*n * 4 ^ l) where l is the length of the word
// Space Complexity : O(l) where it will l recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * We use the backtracking approach to start finding the word from every possible index.
 * Once a character matches, we convet it to #, look for next character.
 * If the character was not found, backtrack the character back to its original character to continue the recursion.
 */
class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        // checking for the start of the word from every possible index
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isPresent(board, word, 0, i, j))
                    return true;
            }
        }

        return false;
    }

    private boolean isPresent(char[][] board, String word, int idx, int r, int c) {
        //base
        // we reached the end of the word
        if (idx == word.length()) {
            return true;
        }
        // bounds check and check for the current path
        if (r < 0 || r == board.length || c < 0 || c == board[0].length || board[r][c] == '#')
            return false;

        //logic
        if (board[r][c] == word.charAt(idx)) {
            // action
            board[r][c] = '#';
            // recurse
            for (int[] dir : dirs) {
                if (isPresent(board, word, idx + 1, r + dir[0], c + dir[1]))
                    return true;
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }

        return false;
    }
}