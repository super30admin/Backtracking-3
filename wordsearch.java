//Time complexity:O(N*3^L)
//Space complexity:O(L)

class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        if(board==null || board.length==0){
            return false;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int i,int j,int index){
        //base
        if(i<0 || j<0 || i==m || j==n || board[i][j]=='#' || board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        //logic
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        char temp=board[i][j];
        board[i][j]='#';
        for(int[] dir:dirs){
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(dfs(board,word,r,c,index+1)){
                return true;   
            }
        }
        board[i][j]=temp;
        return false;
        
    }
}