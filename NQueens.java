// Time Complexity : O((N+1)!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class NQueens
{
    class Solution {
        boolean[][] result;
        int n;
        List<List<String>> ans = new ArrayList();
        public List<List<String>> solveNQueens(int x)
        {
            n = x;
            result = new boolean[n][n];

            dfs(0);

            return ans;
        }

        void dfs(int row)
        {
            // base
            if(row == n)
            {
                List<String> li = new ArrayList();
                for(int i = 0; i < n ; i++)
                {
                    StringBuilder strNode = new StringBuilder();
                    for(int j = 0; j < n ; j++)
                    {
                        if(result[i][j])
                            strNode.append("Q");
                        else
                            strNode.append(".");
                    }
                    li.add(strNode.toString());
                }
                ans.add(li);
                return;
            }

            // action
            for(int col = 0; col < n ; col++)
            {
                if(canPlaceQueen(row, col))
                {
                    result[row][col] = true;
                    dfs(row+1);
                    result[row][col] = false;
                }
            }
        }

        boolean canPlaceQueen(int row, int col)
        {
            // up column check
            for(int i = row-1; i >= 0; i--)
            {
                if(result[i][col] == true)
                    return false;
            }

            // up left top daigonal
            int i = row, j = col;
            while(i >= 0 && j >= 0)
            {
                if(result[i][j] == true)
                    return false;

                i--; j--;
            }

            // up right top daigonal
            i = row; j = col;
            while(i >= 0 && j < n)
            {
                if(result[i][j] == true)
                    return false;

                i--; j++;
            }

            return true;
        }
    }
}
