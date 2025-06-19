/*
  Time complexity: O(n!)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes

*/

public class Solution {
    public IList<IList<string>> SolveNQueens(int n) {
        List<IList<string>> result = new();
        bool[][] board = new bool[n][];

        for(int i=0;i<n;i++)
        {
            board[i]= new bool[n];
        }
        helper(board,0,result);
        return result;
    }

    private void helper(bool[][] board, int r, List<IList<string>> result)
    {
        //base
        if(r==board.Length)
        {
            List<string> path = new();
            for(int i=0;i<board.Length;i++)
            {
                StringBuilder sb = new();
                for(int j=0;j<board[0].Length;j++)
                {
                    if(board[i][j])
                        sb.Append("Q");
                    else
                        sb.Append(".");
                }
                path.Add(sb.ToString());
            }
            result.Add(path);
            return;
        }
        //logic
        for(int c=0;c<board.Length;c++)
        {
            if(isSafe(board,r,c))
            {
                board[r][c] = true;
                helper(board,r+1,result);
                board[r][c]=false;
            }
        }
    }

    private bool isSafe(bool[][] board, int r, int c)
    {
        for(int m=0;m<r;m++)
        {
            if(board[m][c])
                return false;
        }

        int i= r, j=c;

        while(i>=0 && j>=0)
        {
            if(board[i][j])
                return false;

            i--;
            j--;
        }

        i= r;
        j=c;

        while(i>=0 && j<board.Length)
        {
            if(board[i][j])
                return false;

            i--;
            j++;
        }

        return true;
    }
}
