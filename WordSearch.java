// Time Complexity : O(N * 3^L) [N: number of cells and L is lenth of word]
// Space Complexity : O(L)   [Maximum length of stack will be length of word]

// We perform sequential traversal over the matrix
// For each item in matrix, we perform dfs to find if the word matches
// When the character matches the item then we mark it as visited "#" and go forward to check next charater
// In case if we don't find the word in our dfs then we come out of recursion and backtrack the visited mark

class Solution {
    private int m = 0, n = 0;
    private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {

        if (board == null || board[0].length == 0 || word == null || word.length() == 0)
            return false;

        m = board.length;
        n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // base
        if (index == word.length())
            return true;

        if (r < 0 || r == m || c < 0 || c == n || word.charAt(index) != board[r][c]) {
            return false;
        }

        // logic
        // action
        char temp = board[r][c];
        board[r][c] = '#'; // marking visited
        // recurse
        // perform dfs in 4 directions
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (dfs(board, word, nr, nc, index + 1)) {
                return true;
            }
        }

        // backtracking
        board[r][c] = temp;
        return false;
    }
}