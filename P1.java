class Solution {
    int[][] board;
    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        board = new int[n][n];
        result = new ArrayList<>();
        
        if(n==0) return result;
        helper(0,n);
        return result;
    }
    
    public void helper(int row, int n)
    {
        
        //base
        if(row == n) // reached end of rows add to result
        {
            List<String> list = new ArrayList<>();
            for(int r=0; r<n; r++)
            {                 
               StringBuilder sb = new StringBuilder();
                 for(int c=0; c<n; c++)
                 {
                      if(board[r][c] == 1)
                      {
                          sb.append('Q');
                      }
                     else
                     {
                         sb.append('.');
                     }                          
                 }
                list.add(sb.toString());
            }
            
            result.add(list);
        }
       
            
        for(int col=0; col<n;col++)
        {
            if(isValid(row,col,n))
            {
                board[row][col] = 1;
                
                helper(row+1,n);
                
                board[row][col]=0;
            }
        }
        
        
    }
    
    public boolean isValid(int row, int col, int n)
    {
        //check col up
        for(int r=0;r<row;r++)
        {
            if(board[r][col]==1)
            {
                return false;
            }
        }
        
        //check diagnol left
        int r=row;
        int c=col;
        while(r>=0 && c>=0)
        {
            if(board[r][c]==1)
            {
                return false;
            }
            r--;
            c--;
        } 
        
        //check diagnol right
        r=row;
        c=col;
        while(r>=0 && c<n)
        {
            if(board[r][c]==1)
            {
                return false;
            }
            r--;
            c++;
        }
        
        return true;
    }
}