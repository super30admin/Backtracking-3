//TC:O(4*N^2)
//SC:o(length of string)
class Solution {
    
    //HashMap<Character,List<int[]>> map = new HashMap<>();
    public boolean exist(char[][] board, String word) 
    {
      
    for(int i=0;i<board.length;i++)
      {
       for(int j=0;j<board[0].length;j++)
        {
          // System.out.println("-----------");
           if(dfs(word,0,i,j,board))
               return true;
        }
       } 
        return false;
    }
    
    
    public boolean dfs(String word,int idx,int row,int col,char[][]board)
    {     
       if(idx==word.length())
           return true;
        
        
       if(row>=0 && col>=0 && row<board.length && col<board[0].length) 
       {
               if(board[row][col]==word.charAt(idx)) 
                  {
                   char temp = board[row][col];
                   board[row][col]='#';
                  // System.out.println("row is "+row+" col is "+col);
                   if(dfs(word,idx+1,row+1,col,board)||dfs(word,idx+1,row-1,col,board)||dfs(word,idx+1,row,col+1,board)||dfs(word,idx+1,row,col-1,board))
                      return true;
                       
                    board[row][col]=temp; 
                  }
                 else
                     return false;
       }
        
       return false; 
        
        
    }
    
    
    
    
    
    
    
    
    
}