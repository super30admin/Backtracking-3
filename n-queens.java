class Solution {
    int[][] board ;
    int m ;
  List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
      result = new ArrayList<>();
      board= new int[n][n];
      m = n;
      backtrack(0);
      return result;
    }
  
    public void backtrack(int r)
    {
      //base case
      if(r == m)
      {
        List<String> temp = new ArrayList<>();
        for(int i = 0 ; i <m ; i ++)
        {
          StringBuilder sb = new StringBuilder();
          for(int j = 0 ; j< m ;j++)
          {
            if(board[i][j]==0)
            {
              sb.append('.');
            }
            else
            {
              sb.append('Q');
            }
            
          }
          temp.add(sb.toString());
        }
        result.add(temp);
          return;
      }
      //logic
      for(int j  = 0 ; j <m ; j++)
      {
        if(isSafe(r,j))
        {
          board[r][j]=1;
          backtrack(r+1);
          board[r][j]=0;
        }
      }
    }
  
    public boolean isSafe(int r , int c )
    {
      for(int i=0;i<=r;i++ )
      {
        if(board[i][c]==1)
        {
          return false;
        }
      }
      
      int i = r;
      int j = c;
      while(i>=0 && j <m)
      {
        if(board[i][j]==1)
        {
          return false;
        }
        i--;
        j++;
      }
      
      i=r;
      j=c;
      while(i>=0 && j >=0)
      {
        if(board[i][j]==1)
        {
          return false;
        }
        i--;
        j--;
      }
      return true;
    }
  
}