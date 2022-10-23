// TC : O(m*n*3 ^(lenght of String))
// Sc: O(Lenght of the string)
class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length ==0) return false;

        dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j=0; j<n; j++) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int index) {

        // base case
        if (index == word.length()) return true;
        if (r <0 || c <0 || r == m || c == n || board[r][c] == '#') return false;

        // logic
        if (board[r][c] == word.charAt(index)) {
            //action
            char ch = word.charAt(index);
            board[r][c] = '#';
            //recurse
            for (int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (backtrack(board, nr, nc, word, index+1)) {
                    return true;
                }
            }
            //backtrack
            board[r][c] = ch;
        }
        return false;
    }
}
