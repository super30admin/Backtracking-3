class Solution {
    //code not executed on leet code
    //sc-n!
    //tc - n2
    int m;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n==0) return result;
        int m=n;
        boolean[][]board = new boolean[n][n];
        
        backtrack(board,0);
        return result;

    }
    private void backtrack(boolean[][]board,int r)
    {
        //basecase
        if(r == m)
        {
            List<String> li = new ArrayList<>();
            
            for(int i=0;i<m;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++)
                {
                    if(board[i][j])
                    {
                        sb.append('Q');
                        
                    }
                    else
                    {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        
        //logic
        for(int c=0;c<m;c++)
        {
            if(isSafe(r,c,board))
            {
                //action
                board[r][c] = true;
                //recurse
                backtrack(board,r+1);
                //backtrack
                board[r][c] = false;
            }
        }
    }
    private boolean isSafe(int r,int c,boolean[][]board)
    {
        //top column
        for(int i = 0;i<r;i++)
        {
            if(board[i][c]) return false;
        }
         //top left diagonal
        int i=r;
        int j=c;
        while(i>=0 && j >= 0)
        {
            if(board[i][j]) return false;
            i--;j--;
            
        }
        //top right diagonal
        i=r;
        j=c;
        while(i>=0 && j<m)
        {
            if(board[i][j]) return false;
            i--;j++;
            
        }
       
        return true;
    }
}