public class wordsearch {
    class Solution {
        int [][] dirs;
        boolean flag;
        int m,n;
        public boolean exist(char[][] board, String word) {
            this.dirs=new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
            this.flag=false;
            this.m=board.length;
            this.n=board[0].length;
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(!flag)
                        helper(board,word,i,j,0);
                }
            }
            return flag;
        }
    
        public void helper(char[][] board, String word, int i,int j,int idx)
        {
            if(flag)    return;
            if(idx==word.length())
            {
                flag=true;
                return;
            }
            if(j==n||i==m || i<0 || j<0 || board[i][j]=='#')    return;
            if(board[i][j]==word.charAt(idx))
            {
                board[i][j]='#';
                for(int[] dir:dirs)
                {
                    int r=i+dir[0];
                    int c=j+dir[1];
                    helper(board,word,r,c,idx+1);
                }
                board[i][j]=word.charAt(idx);
            }
        }
    }
}
