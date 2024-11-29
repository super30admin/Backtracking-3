public class problem2 {
    // Time Complexity: (m *n) S^L ; L: length of the string , m*n is the length of the matrix
    int[][] dirs;
    int m,n;
    boolean flag;
    public boolean exist(char[][] board, String word)
    {
        this.dirs= new int[][]{{-1,0}, {1,0},{0,1},{0,-1}};
        this.m= board.length;
        this.n= board[0].length;
        this.flag= false;

        for (int i = 0; i < this.m; i++)
        {
            for (int j = 0; j < this.n; j++)
            {
                if (!flag)
                {
                    dfs(board, i, j, word, 0);
                }
                else {break;}
            }
        }
        return flag;
    }
    private void dfs(char[][] board, int i, int j, String word, int idx)
    {
        // base case

        if (idx== word.length())
        {
            flag= true;
            return;
        }

        if (i<0 || i==m || j<0 || j==n || board[i][j]=='#')
        {return;}

        //logic
        if (board[i][j] == word.charAt(idx))
        {
            board[i][j]= '#';
            //recurse
            for (int[] dir: dirs)
            {
                int r= dir[0]+i;
                int c= dir[1]+j;
                dfs(board, r, c, word, idx+1);

            }
            //backtrack
            board[i][j]= word.charAt(idx);

        }

    }



}
