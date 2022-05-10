//TC : exponential
//SC : O (L) where l is length of word
public class Problem2 {
    int m, n;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return true;

        m = board.length;
        n = board[0].length;
        System.out.println("m value " + m);
        System.out.println("n value " + n);

        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int index) {
        //base case
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i == m || j < 0 || j == n || board[i][j] == '#') {
            return false;
        }
        //logic
        if (word.charAt(index) == board[i][j]) {
            char ch = board[i][j];
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int raw = i + dir[0];
                int col = j + dir[1];
                if (helper(board, raw, col, word, index + 1)) return true;
            }
            board[i][j] = ch;
        }
        return false;
    }
}
