class Solution {
    int m,n;
    int[][] dirs;
   // boolean flag;
    public boolean exist(char[][] board, String word) {
        this.m=board.length;
        this.n=board[0].length;
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        //this.flag=false;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(helper(board,i,j,word,0)){
                   return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board,int i, int j, String word,int idx){
         
        if(idx==word.length()){
            return true;
        }
        
        if(i<0 || j<0|| i==m || j  ==n || board[i][j] =='#'){
            return false;
        }
       
        
        
        
        if(word.charAt(idx)==board[i][j]){
            board[i][j]='#';
            for(int[] dir:dirs){
                int r=dir[0]+i;
                int c=dir[1]+j;
                if(helper(board,r,c,word,idx+1)){
                    return true;
                }
                
            }
            board[i][j]=word.charAt(idx);
            
        }
        return false;
    }
}