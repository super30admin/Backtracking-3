class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean [][] board = new boolean[n][n];
         backtrack(board,0,n,res);
         return res;
    }

    private void backtrack(boolean[][] board,int r, int n, List<List<String>> res)
    {
        
        //base
        if(r==n)
        {
            //all are placed
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++)
                {
                    if(board[i][j])
                    sb.append("Q");
                    else
                    sb.append(".");
                }
                li.add(sb.toString());
            }
            res.add(li);
        }
        //logic
        for(int c=0;c<n;c++)
        {
            if(isSafe(board,r,c))
            {
                //action
                board[r][c]=true;
                //recurse
                backtrack(board,r+1,n,res);
                //backtrack
                board[r][c]=false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c)
    {
        //check up in the same column
        for(int i=0;i<r;i++)
        {
            if(board[i][c])
            return false;
        }

        //left diagnol
        int i=r;
        int j=c;
       while(i>=0 && j>=0)
       {
        if(board[i][j])
        return false;
        i--;
        j--;
       }
       //right diagnol
       i=r;
       j=c;
       while(i>=0 && j<board.length)
       {
        if(board[i][j])
        return false;
        i--;
        j++;
       }
       return true;
    }
}

//Time Complexity: O(n^n+1)
//Space Complexity: O(n X n!)