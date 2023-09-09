class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n=board[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        // int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(helper(board,i,j,word,0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char board[][],int i,int j,String word,int idx)
    {
        if(idx==word.length())
        {
            return true;
        }
        if(i<0 || i==m || j<0 || j==n || board[i][j]=='#')
        {
            return false;
        }

        if(board[i][j]==word.charAt(idx))
        {
            board[i][j]='#';
            for(int[] e:dirs)
            {
                int nr = i+e[0];
                int nc = j+e[1];
                if(helper(board,nr,nc,word,idx+1)) return true;
            }
            board[i][j]=word.charAt(idx);
        }
        return false;
    }
}