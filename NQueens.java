package BackTracking;

// Time Complexity : O(N*N!) ->N is the number of rows or columns
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        board = new boolean[n][n];
        helper(board,0,n);
        return result;
    }

    private void helper(boolean[][] board, int r, int n)
    {
        if(r == n)
        {
            List<String> temp = new ArrayList<>();

            for(int i=0; i<n; i++)
            {
                StringBuilder s = new StringBuilder();
                for(int j=0; j<n; j++)
                {
                    if(board[i][j] == true)
                        s.append("Q");
                    else
                        s.append(".");
                }
                temp.add(s.toString());
            }
            result.add(temp);
        }
        for(int j=0; j<n; j++)
        {
            if(isValid(r,j,n))
            {
                board[r][j] = true;
                helper(board, r+1, n);
                board[r][j] = false;
            }
        }
    }

    private boolean isValid(int r, int c, int n)
    {
        //check for the entire column
        for(int i=0; i<r; i++)
        {
            if(board[i][c])
            {
                return false;
            }
        }

        //chech up diagonal right
        int i = r, j = c;

        while(i>=0 && j<n)
        {
            if(board[i][j])
                return false;

            i--; j++;
        }

        //chech up diagonal left
        i = r; j = c;

        while(i>=0 && j>=0)
        {
            if(board[i][j])
                return false;

            i--; j--;
        }

        return true;
    }
}
