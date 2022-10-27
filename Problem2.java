public class Problem2 {
    public boolean exist(char[][] board, String word) {
        boolean [][]bd= new boolean[board.length][board[0].length];
           boolean ans=false;
          
           for(int i=0;i<board.length;i++){
               for(int j=0;j<board[0].length;j++){
                   
                   if(board[i][j]==word.charAt(0)){ 
                       
                      
                     if(helper(word,i,j,bd,0,board)){return true;} 
                     
                   }
                   
               }
           }
           
        return false;
       }
       
       boolean helper(String word, int x, int y,boolean [][]bd, int p,char[][] board){
          //  System.out.println(x+" "+y);
           if(p>=word.length()){   return true;}
           
           if(x<0||y<0||x>=bd.length||y>=bd[0].length||bd[x][y]){return false;}
           
          
          if(board[x][y]!=word.charAt(p)){return false;}
               
           int[][]dirs={{1,0},{-1,0},{0,1},{0,-1}};
           
           boolean ans= false;
           
           for(int[]dir:dirs){
             
               int xx=x+dir[0];
               
               int yy=y+dir[1];
              
               bd[x][y]=true;
               
               boolean response=helper(word,xx,yy,bd,p+1,board);
               
               bd[x][y]=false;
               
               ans=ans||response;
                }
           
           return ans;
           
       }
}
