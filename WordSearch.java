//SC  = O(L) L = length of stack = length of string
//TC =O(m*n(3^L) )

class Solution {
    private int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        if(board == null) return false;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(backtrack(board, i, j, word, 0) == true) return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int r, int c , String word, int idx)
    {
        //base case
        if(idx == word.length()) return true;
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') return false;

        //action
        if(board[r][c] == word.charAt(idx))
        {
            board[r][c] = '#';
            for(int[] dir: dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];
                //recursion
                if(backtrack(board, nr, nc, word, idx + 1)) return true;
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}