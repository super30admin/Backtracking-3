public class WordSearch {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // TC: O(M * N * 3 ^ L) where M is rows of board, N is cols of board and L is length of word
    // SC: O(L) where L is length of word
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int wordIndex) {
        if (wordIndex == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return false;
        }
        if (board[i][j] == word.charAt(wordIndex)) {
            board[i][j] = '#';
            for (int[] d : dirs) {
                int nextI = d[0] + i;
                int nextJ = d[1] + j;
                if (backtrack(board, word, nextI, nextJ, wordIndex + 1)) {
                    return true;
                }
            }
            board[i][j] = word.charAt(wordIndex);
        }
        return false;
    }
}
