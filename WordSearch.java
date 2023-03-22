class Solution {

    int m, n;
    int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int ind) {
        if(word.length() == ind) {
            return true;
        }
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] != word.charAt(ind)) {
            return false;
        }
        board[i][j] = '#';
        for(int[] d : dir) {
            int r = d[0] + i;
            int c = d[1] + j;
            if(helper(board, r, c, word, ind + 1)) {
                return true;
            }
        }
        board[i][j] = word.charAt(ind);
        return false;
    }
}