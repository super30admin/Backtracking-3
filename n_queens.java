class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        boolean board[][]=new boolean[n][n];
        res = new ArrayList<>();
        helper(board,0,n);

        return res;
    }

    private void helper(boolean[][] board, int r,int n)
    {
        if(r==n)
        {
            List<String>li = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(board[i][j]==false)
                    {
                        sb.append('.');
                    }
                    else
                    {
                        sb.append('Q');
                    }
                }
                li.add(sb.toString());
            }

            res.add(li);
        }
        for(int c=0;c<n;c++)
        {
            if(isSafe(board,r,c,n))
            {
                board[r][c]=true;
                helper(board,r+1,n);
                board[r][c]=false;

            }
        }
    }

    private boolean isSafe(boolean board[][],int r, int c,int n)
    {
        for(int i=0;i<r;i++)
        {
            if(board[i][c]==true)return false;
        }
            int i=r;int j=c;
            while(i>=0 && j>=0)
            {
                if(board[i][j])
                {
                    return false;
                }
                else
                {
                    i--;
                    j--;
                }
            }
            i=r;j=c;
            while(i>=0 && j<n)
            {
                if(board[i][j])
                {
                    return false;
                }
                else
                {
                    i--;
                    j++;
                }
            }
        return true;
        }
    }
