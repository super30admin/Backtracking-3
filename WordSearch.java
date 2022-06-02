// Time Complexity: Exponential O(3^L)
// Space Complexity: Number of calls in the recursive stack at a point of time O(m*n)
// Did this code successfully run on Leetcode : Yes

public class WordSearch {
    private int[][] dirs;
    int m; int n;
    public boolean exist(char[][] board, String word) {
        // null case
        if(board == null || board.length == 0) return false;
        m = board.length; n = board[0].length;
        dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        // base case
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
        // logic
        if(board[i][j] == word.charAt(index)) {
            //action
            //char c = board[i][j];
            board[i][j] = '#';

            //recurse
            for(int[] dir: dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(backtrack(board, word, nr, nc, index + 1)) return true;
            }
            //backtrack
            board[i][j] = word.charAt(index);
        }
        return false;
    }
}
