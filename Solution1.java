//N Queens Problem
//TC : O(N!) 
//SC: O(N*N)
class Solution1 {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
       //to specify if queen is present on board or not
        boolean[][] board=new boolean[n][n];
        //dfs or recursion
        helper(board,0,n); //r=0,c=n
        return result;
    }
    private void helper(boolean[][] board,int r,int n)//i->row,j->col
    {
        //base
        if(r==n)
        {
            //add to result
            List<String> output=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(board[i][j]==true)//Queen present
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }//one row completed
                //add row to the output
                output.add(sb.toString());
            }
            //add first list to result
            result.add(output);
        }

        //logic
        //action
        //recurse for every row
        //iterate for every col in that row
        for(int j=0;j<n;j++)
        {
            if(isSafe(board,r,j))
            {
                board[r][j]=true;
                //recurse
                helper(board,r+1,n);//go to next row and recurse
                //backtrack
                board[r][j]=false;
            }
     }
    }

    private boolean isSafe(boolean[][] board,int r,int c)
    {
        //chk column up
        for(int i=0;i<=r;i++)
        {
            if(board[i][c])
            {
                return false;
            }
        }

        //chk diagonal up left
        int i=r;
        int j=c;
        while(i>=0 && j>=0)
        {
            if(board[i][j])
            {
                return false;
            }
            i--;
            j--;
        }
        i=r;
        j=c;
        while(i>=0 && j<board.length)
        {
            if(board[i][j])
            {
                return false;
            }
            i--;
            j++;
        }

        return true;
        //chk diagonal up right
    }
}