/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Idea: traverse the whole board, at each cell, if the character matches the
 * character we are currently processing in the string, consume it and recurse
 * on this cells 4 neighbors.
 * 
 * Space Complexity: O(m*n) 
 * Time Complexity: O(m^2 * n^2), mn time we do dfs each of which is O(mn)
 * 
 * Leetcode Results:
 * Runtime: 5 ms, faster than 46.30% of Java online submissions for Word Search.
 * Memory Usage: 43.2 MB, less than 20.41% of Java online submissions for Word Search.
 * 
 * Leetcode Attempts: 2
 * 1: missed on the part of marking visited
 * 2: success
 * 
 */
class WordSearch {

    int[] dx = new int[] { -1, 0, 1, 0 };
    int[] dy = new int[] { 0, 1, 0, -1 };

    public boolean exist(char[][] board, String word) {
        // iterate over the board, call dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) { // match found
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param board of characters
     * @param i     current row index
     * @param j     current col index
     * @param word
     * @param k     index of word currently being processed
     * @return true, is remainder is a match, false otherwise
     */
    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) { // whole word processed
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) { // out of bounds
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char cache = board[i][j];
            board[i][j] = 'X'; // mark visited
            for (int t = 0; t < 4; t++) { // recurse on neighbours
                if (dfs(board, i + dx[t], j + dy[t], word, k + 1)) {
                    return true;
                }
            }
            board[i][j] = cache;
        }
        return false;
    }
}