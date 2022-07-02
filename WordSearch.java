//T : O(mn X 3^L)
//S : O(String length)

class Solution {
    int m;
    int n;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 0))
                        return true;
                }
            }
        }
        return false;

    }

    private boolean helper(char[][] board, int i, int j, String word, int index) {
        // base
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;
        // logic
        if (board[i][j] == word.charAt(index)) {
            for (int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                board[i][j] = '#';
                if (helper(board, r, c, word, index + 1))
                    return true;
                board[i][j] = word.charAt(index);
            }
        }
        return false;
    }
}