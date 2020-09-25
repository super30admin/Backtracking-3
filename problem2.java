class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(0))
                    if (backtrack(board, i, j, word, 0))
                        return true;
            }
        }

        return false;
    }

    int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    boolean backtrack(char[][] board, int i, int j, String word, int index) {

        if (index >= word.length() - 1)
            return true;

        char temp = board[i][j];
        board[i][j] = '#';

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && (index + 1 < word.length())
                    && word.charAt(index + 1) == board[r][c]) {
                if (backtrack(board, r, c, word, index + 1))
                    return true;
            }

        }
        board[i][j] = temp;
        return false;
    }
}