class Solution {
    int[][] dirs;
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};//U D L R
        this.m=board.length;
        this.n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,i,j,word,0))return true;
            }
        }
        return false;
    }
        private boolean dfs(char[][] board,int r,int c,String word,int index){
            if(index==word.length())return true;
            if(r<0||r==m||c<0||c==n||board[r][c]=='#')return false;
            if(board[r][c]!=word.charAt(index))return false;
             char temp=word.charAt(index);
            board[r][c]='#';
            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];
                 if(dfs(board,nr,nc,word,index+1))return true;
            }
            board[r][c]=temp;
            return false;
        
        }
        
    }