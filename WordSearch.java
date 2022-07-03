//Time Complexity=O(mn*3^L)
//Space Complexity=O(L)
public class WordSearch {
    int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};
    int m,n;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    dfs(board,word,i,j,0);
                    if(flag) return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, String word,int i,int j,int index){
        //base
        if(index==word.length()){
            flag=true;
            return;
        }

        if(i<0 || j<0 || i==m || j==n || board[i][j]=='0') return ;

        //logic
        if(board[i][j]==word.charAt(index)){
            board[i][j]='0';
            for(int[] dis:dir){
                int nr=i+dis[0];
                int nc=j+dis[1];
                dfs(board,word,nr,nc,index+1);
            }
            //backtrack
            board[i][j]=word.charAt(index);
        }
    }
}
