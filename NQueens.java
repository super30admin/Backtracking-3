// Time Complexity :O(n factorial) so all permutations 
// Space Complexity :O(n)
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res= new ArrayList<>();
        boolean [][] board= new boolean[n][n];
        helper(board, 0, n);
        return res;

    }
    private void  helper(boolean[][]board, int r , int n)
    {

        // base condition

        if(r==n)
        {    
            ArrayList<String> temp = new ArrayList<>();
            for( int i =0;i<n;i++)
            {   StringBuilder row = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(board[i][j])
                        row.append('Q');
                    else
                        row.append('.');
                }
             temp.add(row.toString());
            }
            res.add(temp);
            return;




        }


        for(int i=0;i<n;i++)
        {
            if(isSafe(board, r, i))
            {
                board[r][i]=true; //action

                helper(board, r+1,n); //recursion

                board[r][i]=false; //backtrack
            }


        }


    }

    private boolean isSafe(boolean[][]board,int i , int j)
    {

        for(int t=0;t<i;t++)
        {
            if(board[t][j])
                return false;
        }

        int r = i, c=j;

        while(r>=0 && c>=0)
        {
            if(board[r][c])
                return false;
            r--;
            c--;
        }
        r=i; c=j;
        while(r>=0 && c<board.length)
        {
            if(board[r][c])
                return false;
            r--;
            c++;
        }

        return true;



    }

} 