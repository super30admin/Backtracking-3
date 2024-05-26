class Solution {
    private int[][] dirs;
    int m;
    int n;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        //null
        if(board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;

        dirs = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};
        for(int i=0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(!flag) 
                {
                    if(backtrack(board, word, i, j, 0)) return true;
                }

            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int idx)
    {
        //base
        if(idx == word.length())
        {
            return true;
        }

        if(i < 0 || j < 0 || i==m || j ==n || board[i][j] == '#') return false;
        //logic
        if(word.charAt(idx) == board[i][j])
        {
            //action
            board[i][j] = '#';

            //recurse
            for(int[] dir: dirs)
            {
                int nr = dir[0] + i;
                int nc = dir[1] + j;
            
                if(backtrack(board, word, nr, nc, idx+1)) return true;
            }

            //backtrack
            board[i][j] = word.charAt(idx);
        }
        return false;
    }
}