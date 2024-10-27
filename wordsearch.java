class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m=board[0].length,n=board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(board,word,dirs,i,j,m,n,0)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][]board, String word, int[][]dirs, int i, int j, int m, int n, int index){
        if(index==word.length()) return true;
        if(i<0 || j<0 || i==n || j==m) return false;
        if(board[i][j]==word.charAt(index)){
            board[i][j]='#';
            for(int[]dir:dirs){
                int nr=i+dir[0];
                int nc=j+dir[1];

                if(dfs(board,word,dirs,nr,nc,m,n,index+1))
                    return true;

            }
            board[i][j]=word.charAt(index);
        }
        return false;
    }
}
