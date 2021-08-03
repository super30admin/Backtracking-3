class Solution {

    boolean[][] board;
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n)
    {
        board = new boolean[n][n];
        helper(n,0);
        return res;
    }

    private void helper(int n , int row)
    {
        if(row == n)
        {
            List<String> curr = new ArrayList<>();

            for(int i=0 ; i<n ; i++)
            {
                StringBuilder sb = new StringBuilder();

                for(int j=0 ; j<n ; j++)
                {
                    if(board[i][j]) sb.append('Q');
                    else sb.append('.');
                }

                curr.add(sb.toString());
            }

            res.add(curr);
        }

        for(int col=0 ; col<n ; col++)
        {
            if(safe(row,col,n))
            {
                board[row][col] = true;
                helper(n,row+1);
                board[row][col] = false;
            }
        }
    }

    private boolean safe(int row , int col , int n)
    {
        //col
        for(int i=0 ; i<n ; i++)
        {
            if(board[i][col]) return false;
        }

        int i = row;
        int j = col;

        while(i>=0 && j>=0)
        {
            if(board[i][j]) return false;

            i--;
            j--;
        }

        i = row;
        j = col;

        while(i>=0 && j<n)
        {
            if(board[i][j]) return false;

            i--;
            j++;
        }

        return true;
    }
}
