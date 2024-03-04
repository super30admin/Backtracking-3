//TC: m*n*3^l
class Solution {
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.m=board.length;
        this.n=board[0].length;
        this.dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    if(dfs(i,j,0,word,board))return true;
                }
            }
        }
        return false;
        
    }
    private boolean dfs(int r,int c,int i,String word,char[][] board)
    {
        if(i==word.length())
        return true;
        if(r<0||c<0||r==m||c==n||board[r][c]=='$')
        return false;
       
        if(board[r][c]==word.charAt(i))
        {
         board[r][c]='$';
        for(int [] dir:dirs)
        {
             int r1=r+dir[0];
             int c1=c+dir[1];
             if(dfs(r1,c1,i+1,word,board))return true;
        }
        board[r][c]=word.charAt(i);
        }
        return false;
    }
}