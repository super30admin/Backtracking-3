public class NQueens
    {
        // Time Complexity : O(n!)- where n is the number of queens
        // Space Complexity : O(n^2) -  for the grid used in computation n * n.
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        IList<IList<string>> result;
        bool[,] grid;

        public IList<IList<string>> SolveNQueens(int n)
        {
            result = new List<IList<string>>();
            grid = new bool[n,n];
            backtrack(0, n);
            return result;
        }

        private void backtrack(int r, int  n)
        {
            //base case
            if(r == n)
            {
                List<string> list = new List<string>();
                for(int i = 0; i < n; i++)
                {
                    StringBuilder strRow = new StringBuilder();
                    for(int j = 0; j < n; j++)
                    {
                        if (grid[i,j])
                        {
                            strRow.Append("Q");
                        }
                        else
                        {
                            strRow.Append(".");
                        }
                    }
                    list.Add(strRow.ToString());
                }

                result.Add(list);
            }

            //logic
            for(int c = 0; c < n; c++)
            {
                if(IsSafe(r, c, n))
                {
                    //action
                    grid[r, c] = true;

                    //recurse
                    backtrack(r + 1, n);

                    //backtrack
                    grid[r, c] = false;
                }
            }
        }

        private bool IsSafe(int r, int c, int n)
        {
            int i = r;
            int j = c;
            //column up
            for (i = 0; i < r; i++)
            {
                if (grid[i, c])
                    return false;
            }
            //diagonal up left
            
            while(i >= 0 && j >=0)
            {
                if(grid[i, j])
                    return false;
                i--;
                j--;
            }
            //diagonal up right
            i = r;
            j = c;
            while(i >= 0 && j < n)
            {
                if (grid[i, j])
                    return false;
                i--;
                j++;
            }
            return true;
        }
    }
