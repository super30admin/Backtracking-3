class Solution {
    //Time O(N!)
    //Space O(N)
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0)
        {
            return result;
        }
        board = new int[n][n];
        helper(board , 0 , 0);
        return result;
    }
    private void helper(int[][] board, int r , int c)
    {
        //base
        if(r == board.length)
        {
            List<String> lis = new ArrayList<>();
            for(int i=0 ; i<board.length ; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0 ; j<board[0].length ; j++)
                {
                    if(board[i][j] == 1)
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }
                lis.add(sb.toString());
            }
            result.add(lis);
            return;
        }
        //logic
        for(int i=0 ; i<board[0].length ; i++)
        {
            if(isSafe(board , r, i))
            {
                board[r][i] = 1; // Action
                helper(board, r+1, i);
                board[r][i] = 0;
            }
        }
    }
    private boolean isSafe(int[][] board, int r , int c)
    {
        //Top
        for(int i=0 ; i<r ; i++)
        {
            if(board[i][c] == 1)
            {
                return false;
            }
        }
        
        //Up Left
        int i=r , j = c;
        while(i >=0 && j>=0)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
            i--;j--;
        }
        
        //Up Right
        i = r ; j = c;
        while(i >= 0 && j < board[0].length)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
            i--;j++;
        }
        return true;
    }
}