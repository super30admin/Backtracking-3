// Time Complexity : O(m*n) where m and n are dimensions of board
// Space Complexity : O(k) where k is length of the string to be searched
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
public class WordSearch {
    class Solution {
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        public boolean exist(char[][] board, String word) {
          
            int m = board.length;
            int n = board[0].length;
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(backtrack(board,word,i,j,0))
                    {
                        return true;
                    }
                }
            }
            
            return false; 
        }
        
        public boolean backtrack(char[][] board, String s, int r, int c, int index)
        {
            if(index == s.length())
            {
              return true;
            }
            
            if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!=s.charAt(index)) return false;
            
            if(board[r][c]==s.charAt(index))
            {   
                char temp = board[r][c];
                board[r][c] = '#';
                for(int [] dir : dirs)
                {
                    int i = r+dir[0];
                    int j = c+dir[1];
                    if(backtrack(board,s,i,j,index+1))
                    {
                        return true;
                    }
                }
                board[r][c]=temp;
            }
            
            return false;
        }
    }
    
     
    
    
}
