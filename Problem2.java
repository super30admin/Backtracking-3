// Time Complexity :O(m*n) 3 pow l (l is length of the string)
// Space Complexity :O(L) (stack space for recursion , height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class Problem2 {
    int[][] dirs;
    int m;
    int n;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        dirs= new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        m=board.length;
        n=board[0].length;
        flag=false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!flag){
                    dfs(board, i, j,word,0);
                }else{
                    break;
                }
            }
        }
        return flag;
    }

    private void dfs(char[][] board, int i, int j, String word, int idx){
        if(idx==word.length()){
            flag=true;
            return;
        }

        if(i<0 || j<0 || i==m || j==n || board[i][j]=='#') return;

        if(board[i][j]==word.charAt(idx)){
            board[i][j]='#';
            for(int[] dir:dirs){
                int r= dir[0]+i;
                int c= dir[1]+j;
                dfs(board,r,c,word,idx+1);
            }

            board[i][j]=word.charAt(idx);
        }
    }
}
