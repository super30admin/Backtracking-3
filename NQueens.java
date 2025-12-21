
class NQueens {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(dfsBacktrack(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfsBacktrack(char[][] board, int r, int c, String word, int idx)
    {
        // base
        // have got all char of the word
        if(idx == word.length()) return true;
        // check boundry for nr and nc and also check if we hit a dead end by getting a '#' already
        // visited char/grid
        if(r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] == '#') return false;

        // logic
        // dfs search, idx for char of word
        // backtrack if not yet found
        if(board[r][c] == word.charAt(idx))
        {
            // action
            board[r][c] = '#';
            for(int[] dir : dirs)
            {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                // recurse
                if(dfsBacktrack(board, nr, nc, word, idx+1)) return true;
            }
            // backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}