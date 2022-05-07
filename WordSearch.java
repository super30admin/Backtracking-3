public class WordSearch {

    // DFS with backtracking
    // TC: O(4 ^ l * m * n) l - length of the word  m - number of rows  n- number of columns
    // SC: O(l) recursive stack depends on the number of characters in the word
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word.length() == 0) return false;

        dirs = new int[][]{
                {-1,0}, // UP
                {1,0},  // DOWN
                {0,-1}, // RIGHT
                {0,1}   // LEFT
        };

        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j])
                    if(backtracking(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean backtracking(char[][] board, String word, int r, int c, int index) {

        //base
        if(index == word.length()) return true;

        if(r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] == '#'){
            return false;
        }

        //logic
        if(word.charAt(index) == board[r][c]){


            // action
            char ch = board[r][c];
            board[r][c] = '#'; // Marking it as visited

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // recurse
                if(backtracking(board, word, nr, nc, index + 1)) return true;
            }

            // backtrack
            board[r][c] = ch;

        }
        return false;
    }
}
