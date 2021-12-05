// Time Complexity : O(n!)
// Space Complexity : O(n^2) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    List<List<String>> result;
    boolean[][] board;
    int N;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        N = n;
        board = new boolean[n][n];
        backtrack(0);
        return result;       

    }

    private void backtrack(int r)
    {
        //base
        if(r == N)
        {
            //convert boolean to string list
            List<String> li = new ArrayList<>();

            for(int i = 0; i < N; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < N; j++)
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
            return;
        }

        for(int j = 0; j < N; j++)
        {

            if(isSafe(r,j))
            {
                //Action
                board[r][j] = true;
                //recurse
                backtrack(r+1);
                //Backtrack
                board[r][j] = false;
            }

        }
    }

    private boolean isSafe(int r, int c)
    {
        //column up
       for(int k = 0; k < r; k++)
       {
           if(board[k][c]) return false;         
       }

        //diagonal up left
        int i = r; int j = c;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j]) return false;
                i--;
                j--;
        }
        
        //up right
        i=r; j=c;
        while(i >= 0 && j < N)
        {
            if(board[i][j]) return false;
                i--;
                j++;
        }      
        return true;
    }
}