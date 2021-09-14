using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    class NQueensLC
    {
        //TC : O(n^n) or O(n!)
        //SC : O(n*n) + recursive stack (O(n))
        bool[][] grid;
        internal List<List<string>> result;
        public List<List<string>> SolveNQueens(int n)
        {
            result = new List<List<string>>();
            if (n == 0) return result;
            grid = new bool[n][];
            backtrack(n, 0);
            return result;
        }

        private void backtrack(int n, int row)
        {
            //base
            if (row == n)
            {
                List<string> li = new List<string>();
                for (int i = 0; i < n; i++)
                {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++)
                    {
                        if (grid[i][j])
                        {
                            sb.Append('Q');
                        }
                        else
                        {
                            sb.Append('.');
                        }
                    }
                    li.Add(sb.ToString());
                }
                result.Add(li);
                return;
            }

            //logic
            for (int i = 0; i < n; i++)
            {
                if (IsSafe(n, row, i))
                {
                    //action
                    grid[row][i] = true;
                    //recurse
                    backtrack(n, row + 1);
                    //backtrack
                    grid[row][i] = false;
                }
            }
        }

        private bool IsSafe(int n, int row, int col)
        {
            //check upper rows
            for (int r = 0; r < row; r++)
            {
                if (grid[r][col])
                {
                    return false;
                }
            }
            //check for upper left diagonal
            int i = row, j = col;
            while (i >= 0 && j >= 0)
            {
                if (grid[i][j]) return false;
                i--;
                j--;
            }
            //check for upper right diagonal
            i = row;
            j = col;
            while (i >= 0 && j < n)
            {
                if (grid[j][j]) return false;
                i--;
                j++;
            }
            return true;
        }
    }
}
