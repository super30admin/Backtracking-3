// Time Complexity : O(n!) -- for first row choice = n for second row => n-2, for third = > n-4 , for third row => n-8 ------> n!
// Space Complexity :O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not sure about space complexity


// Your code here along with comments explaining your approach
//1 using recursion in for loop along with backtracking

class Solution {
    boolean[][] board;
   
    List<List<String>> result ;
  
    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
       
        result = new ArrayList<List<String>>();
        placeQueen(n, 0);
        return result;
        
    }
    
    private void placeQueen(int n,int r)
    {
        // base
        if(r == board.length)
        {
          result.add(readBoard());
            return ;
        }
        
              for(int c = 0 ; c < n ; c++)
                 {
                    // action- check
                      boolean isSafe = isSafe(n,r,c);

                     if(isSafe == true)
                     {  // action
                         board[r][c] = true;
                         // recursion
                         placeQueen(n, r+1);
                         // backtrack
                         board[r][c] = false;
                     }


                 }
            
    
    }
    
    private List<String> readBoard()
    {  List<String> ls = new ArrayList<String>();
         for(int r = 0 ; r < board.length ; r++)
           {  StringBuilder sb = new StringBuilder(); 
             for(int c = 0 ; c < board.length ; c++)
             {
                 if(board[r][c] == true)
                     sb.append('Q');
                 else
                     sb.append('.');
             }
            ls.add(sb.toString());
            }  
     return ls;
    }
    
    private boolean isSafe(int n , int r , int c )
    {
       
        int i = r ; int j = c;
        while(i>=0 && i < n &&  j < n && j >=0)
        {
              if(board[i][j] == true)  return false;
              i--;
        }
        
        i  = r;  j = c;
        while(i>=0  && i < n &&  j < n && j >=0)
        {
            if(board[i][j] == true)  return false ;
             i--;j--;
        }
                            
        i = r;
        j = c;
        while( i >=0 && i< n && j >=0 && j < n )
        {
           if(board[i][j] == true) return false;
           i--;  j++;
        }
      
        return true;
     }
    
}