public class Word_Search {

    // Approach: Backtracking on all the cells, return false if character does not match
    // if character matches recursive call to backtrack() with idx+1 of the word
    // Time: O(N*3^L) where N = no. of cells and 3^L since we don't go back
    // to where we came from so 3 further options and L = length of the word
    // Space: O(L) for recursive stack
    private int[][] dirs;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (backtrack(board, word, 0, rows, cols, i, j)) return true;
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, int idx, int rows, int cols, int i, int j) {

        if (idx == word.length()) return true;
        // boundary check
        if (i < 0 || j < 0 || i == rows || j == cols || board[i][j] == '#') return false;

        if (board[i][j] == word.charAt(idx)) {
            // action: mark visited using #
            board[i][j] = '#';

            // recurse
            for (int dir[] : dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(backtrack(board, word, idx+1, rows, cols, nr, nc)) return true;
            }

            // backtrack
            board[i][j] = word.charAt(idx);
        }

        return false;
    }
}