class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.result=new ArrayList<>();
        this.board= new boolean[n][n];
        helper(0,n);
        return result;
        
    }
    public void helper(int row, int n)
    {
        //base
        if(row==n)
        {
            List<String> list =new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                   
                    if(board[i][j]==true)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for(int j=0;j<n;j++)
        {
            if(isSafe(board,row,j,n))
            {
                board[row][j]=true;
                helper(row+1,n);
                board[row][j]=false;
            }
        }
    }

    public boolean isSafe(boolean[][] board,int i, int j,int n)
    {
        int r=i;
        int c=j;
        while(r>=0)
        {
            if(board[r][c]==true)   return false;
            r--;
        }
        r=i;c=j;

        while(r>=0 && c>=0)
        {
            if(board[r][c]==true)   return false;
            r--;
            c--;
        }
        r=i;c=j;
        while(r>=0 && c<n) 
        {
            if(board[r][c]==true)   return false;
            r--;
            c++;
        }
        return true;
    }
}