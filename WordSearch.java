/**
 * Time Complexity : O(m * n * (3 ^ l)) where m and n are lengths board and l is the length of the word
 * Space Complexity : O(1)
*/

public class WordSearch {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        if (board == null || board.length == 0) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // base case
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || board[i][j] == '#' || board[i][j] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;

        // logic
        char temp = board[i][j];
        board[i][j] = '#';
        int dirs[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int dir[] : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (dfs(board, word, r, c, index + 1)) return true;
        }
        board[i][j] = temp;
        return false;
    }
}