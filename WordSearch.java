// Time Complexity : O(3^L) where L is the length of the word
// Space Complexity : O(L) for the recursion stack 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class WordSearch {
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // char temp = board[i][j];
        board[i][j] = '#';

        for (int[] dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], word, index + 1)) {
                return true;
            }
        }
        // Backtracking by resetting the cell to its original value (board[i][j] = temp)
        // when the path doesn't lead to a solution.
        board[i][j] = word.charAt(index);
        return false;
    }
}
