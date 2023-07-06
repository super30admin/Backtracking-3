class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int start, String word) {
        if (start == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(start))
            return false;

        // same letter can not be used multiple times so we set it to be empty string
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i - 1, j, start + 1, word) ||
                dfs(board, i + 1, j, start + 1, word) ||
                dfs(board, i, j + 1, start + 1, word) ||
                dfs(board, i, j - 1, start + 1, word);
        // assign the value back here
        board[i][j] = temp;
        return found;
    }
}