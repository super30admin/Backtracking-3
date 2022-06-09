//https://leetcode.com/problems/n-queens/
// Time Complexity :O(n factorial) so all permutations 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
     List<List<String>> result;
    boolean[][] board;
    int m;//to keep track of size
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        m=n;
        if(n==0)
            return result;
        board =new boolean[n][n];
        helper(board,0); //row alone is enough column will be taken care
        return result;
    }
    private void helper(boolean[][] board,int r)
    {
        //base condition
        if(r==m){  //when the row number is the number of queens it has reached the end
            List<String> sol=new ArrayList<>();
            for(int i=0;i<m;i++) //every row
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<m;j++)
                {
                    if(board[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                sol.add(sb.toString());
            }
            result.add(sol);
            
        }
        //logic
        for(int i=0;i<m;i++) //to get the column index
        {
            if(isSafe(r,i)){ //for every row column check if the position is safe and recurse if it is
                //action
                board[r][i]=true;
                //recurse
                helper(board,r+1);
                //backtrack
                board[r][i]=false;
            }
        }
    }
    private boolean isSafe(int r,int c)
    {
        //checking the columns
        for(int i=0;i<r;i++)
            if(board[i][c]) return false;
        int i=r, j=c;
        
        //diagonal left
        while(i>=0 && j>=0)
        {
            if(board[i][j]) return false;
            i--;j--;
        }
        i=r;j=c;
        //diagonal right
        while(i>=0 && j<m)
        {
            if(board[i][j]) return false;
            i--;j++;
        }
        return true;
    }
}