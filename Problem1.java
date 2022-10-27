import java.util.*;
class Problem1{



    boolean [][] board;
    List<List<String>> ans= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
      this.board= new boolean[n][n];
        helper(0,n,board);
     return ans;   
    }
    
   public void helper(int level,int n, boolean board[][]){
    if(n==0){
            List<String>ans1= new ArrayList<>();
            StringBuilder sb= new StringBuilder();
            for(boolean[] row:board){
                sb= new StringBuilder();
                for(boolean val:row){
                    if(val==true){sb.append('Q');}else{sb.append('.');}
                }
                ans1.add(sb.toString());
            }
            ans.add(new ArrayList(ans1));    
        }
        
        if(level>board.length-1){return;}
        for( int i=0;i<board[0].length;i++){
            if(issafe(level, i,board)){
                board[level][i]=true;
                helper(level+1,n-1,board);
                board[level][i]=false;
            }} }
    
    boolean issafe(int x, int y,boolean board [][]){
     for( int i=x;i>=0;i--){ if(board[i][y]){return false;}}
        for(int i=0;i<=y;i++){if(board[x][i]) return false;}
        int xx=x;
        int yy=y;
        
        while(xx>=0 && yy>=0){  if(board[xx][yy]){return false;}xx--; yy--;  }
         xx=x;
         yy=y;
         while(xx>=0 && yy<=board[0].length-1){  if(board[xx][yy]){return false;}xx--; yy++;  }
        return true;
        
    }

}