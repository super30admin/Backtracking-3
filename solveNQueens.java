// Runtime complexity - O(N!) where N is the given n (each row we will have n-1, n-2, n-3 ... to search)
//space complexity - O(N) where N is the given n

class Solution {
    int m;
    List<List<String>> res;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        if(n==0)
            return res;
        m=n;
        board=new int[m][m];
        backtrack(0);
        return res;
    }
    
    public void backtrack(int r)
    {
        //base
        if(r==m)
        {
            List<String> l1=new ArrayList<String>();
            for(int i=0;i<m;i++)
            {
                StringBuilder str=new StringBuilder();
                for(int j=0;j<m;j++)
                {
                    if(board[i][j]==1)
                        str.append('Q');
                    else
                        str.append('.');
                }
                l1.add(str.toString());
            }
            res.add(l1);
            return;
        }
        //condition
        for(int c=0;c<m;c++)
        {
            if(issafe(r,c))
            {
                board[r][c]=1;
                //recurse
                backtrack(r+1);
                //backtrack
                board[r][c]=0;
            }
        }
    }
    
    private boolean issafe(int r,int c)
    {
        //upper column
        for(int i=0;i<r;i++)
        {
            if(board[i][c]==1)
                return false;
        }
        
        // upper left diagonal
        int k=r-1;
        int j=c-1;
        while(k>=0 && j>=0)
        {
            if(board[k][j]==1)
                return false;
            k--;
            j--;
        }
        
        //upper right diagonal
        k=r-1;
        j=c+1;
        while(k>=0 && j<m)
        {
            if(board[k][j]==1)
                return false;
            k--;
            j++;
        }
        return true;
    }
}
