// Time Complexity :O(m*n)3^l where l is the length of the input word  and 3 is the 3 directions we looks at , in every seach
// Space Complexity :O(l) where l is the lenght of the input word
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we are implementing backtracking which very closely resembles a dfs. We start at a point in the input board and find the first letter of the input word
// in the board. Whenever we see that , we start backtracking and keep checking for three directions if we find the next letter in the input word.
//Everytime we are done with with the current letter , we make it as "." before going to the next step. If we go back a step , we revert that back to what it was 
//by lookign at the index we are currently at in the input string.
class Solution {
 
    public boolean exist(char[][] board, String word) {
      
      if(board==null || board.length==0 || board[0]==null || board[0].length==0 || word==null || word.length()==0)
      {
        return false;
      }
      
      for(int i=0;i<board.length;i++)
      {
        for(int j=0;j<board[0].length;j++)
        {
          if(board[i][j] == word.charAt(0))
          {
            if(dfs(board,i,j,word,0))
            {
              return true;
            }
          }
        }
      }
     
       return false; 
    }
  
  private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
  
  private boolean dfs(char[][] board,int i,int j,String word,int index)
  {
    //base case
    if(index == word.length() -1)
    {
      return true;
    }
    
    //logic
    board[i][j]='.';
    
    for(int[] dir:dirs)
    {
      int r = dir[0]+i;
      int c = dir[1]+j;
      
      if(r >=0 && r < board.length && c >= 0 && c <board[0].length && board[r][c] == word.charAt(index+1))
      {
        if(dfs(board,r,c,word,index+1))
        {
          return true;
        }
      }
    }
    
    //backtracking
    board[i][j] = word.charAt(index);
    return false;
  }
}