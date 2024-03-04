//TC:n^n
class Solution {
    List<List<String>> result;
    boolean[][] board;
    
    public List<List<String>> solveNQueens(int n) {
        this.result=new ArrayList<>();
        this.board=new boolean[n][n];
        helper(0,n);
        return result;

        
    }
    private void helper(int r,int n)
    {
        if(r==n)
        {
            List<String> li=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                
                StringBuilder s=new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(board[i][j]==true)
                    {
                      s.append('Q');
                    }
                    else
                    {
                       s.append('.');
                    }
                }
               li.add(s.toString());
            }
            result.add(li);
            return;
        }

for(int c=0;c<n;c++)
{
if(isSafe(r,c,n))
{
    board[r][c]=true;
    helper(r+1,n);
    board[r][c]=false;
}
}
    }
    private boolean isSafe(int r, int c,int n)
   {
      int i=r;
      int j=c;
      while(i>=0&&j>=0)
      {
          if(board[i][j])
          return false;
          i--;
          j--;
      } 
       i=r;
       j=c;
      while(i>=0&&j<n)
      {
          if(board[i][j])
          return false;
          i--;
          j++;
      }
         
        
     
     for(int r2=0;r2<r;r2++)
     {
         if(board[r2][c]==true)
         return false;
     }
     return true;
    }

}