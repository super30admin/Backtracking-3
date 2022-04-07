//Time Complexity : O(n!)
//Space Complexity : O(n^2)

class Solution {
    
    List<List<String>> result;
    boolean board[][];
    int m;
    
    public List<List<String>> solveNQueens(int n) {
        
        result = new ArrayList<>();
        m = n;
        board = new boolean[n][n];
        
        if(n==0)
        {
            return result;
        }
        
        backtrack(0);
        
        return result;
    }
    
    public void backtrack(int r)
    {
        //base
        if(r==m)
        {
            List<String> lst = new ArrayList<>();
            
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
                
                lst.add(sb.toString());
            }
            
            result.add(lst);
            return;
        }
        
        
        //logic
        
        for(int i=0;i<m;i++)
        {
            if(isSafe(r,i))
            {
                //action
                board[r][i] = true;
                
                //recurse
                backtrack(r+1);
                
                //backtrack
                board[r][i] = false;
            }
        }
        
        return;
    }
    
    public boolean isSafe(int r, int c)
    {
        //up top
        for(int i=0;i<r;i++)
        {
            if(board[i][c])
            {
                return false;
            }
        }
        
        int i = r;
        int j = c;
        
        //left diagonal
        while(i>=0 && j<m)
        {
            if(board[i][j])
            {
                return false;
            }
            
            i--;
            j++;
        }
        
        i=r;
        j=c;
        
        //right diagonal
        while(j>=0 && i>=0)
        {
            if(board[i][j])
            {
                return false;
            }
            
            i--;
            j--;
        }
        
        return true;
    }
}