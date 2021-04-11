//tc : O(m *n)
//sc: O(k); k = recursion stack = height of tree
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length() - 1)
            return true;

        char temp = board[i][j];
        board[i][j] = '#';

        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && word.charAt(index + 1) == board[r][c])
                if (dfs(board, word, index + 1, r, c))
                    return true;

        }

        board[i][j] = temp;
        return false;
    }
}