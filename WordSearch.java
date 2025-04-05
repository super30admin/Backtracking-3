class WordSearch {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n= board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    if(backtrack(board,i,j,0,word))
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board,int r, int c, int idx, String word )
    {
        //base
        if(idx==word.length())
        return true;
        if(r<0 || c<0 || r==board.length || c==board[0].length || board[r][c]=='#')
        return false;
        //logic
        if(board[r][c]==word.charAt(idx))
        {
            //action
            board[r][c]='#';
        
        for(int [] dir : dirs)
        {
            int nr = r+dir[0];
            int nc = c+dir[1];
            if(backtrack(board,nr,nc,idx+1,word))
            return true;
        }
         board[r][c] = word.charAt(idx);
        }
       
        return false;
    }
       
}

//tc: O(m×n)
//sc: O(l) , where l is the length of the word.