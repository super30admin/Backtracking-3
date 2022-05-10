using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    public class NQueen
    {
        /*
         * T.C: O(N!) n factorial as we are reducing the choices as we move further from first row to sebsequent rows 
         * S.C: O(M*N)
         */
        List<IList<string>> result = new List<IList<string>>();
        bool[,] board;
        public IList<IList<string>> SolveNQueens(int n)
        {

            if (n == 0)
                return result;

            board = new bool[n, n];

            backtracking(0);
            return result;
        }

        private void backtracking(int row)
        {
            //base
            if (row == board.GetLength(0))
            {
                List<string> newList = new List<string>();
                for (int i = 0; i < board.GetLength(0); i++)
                {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < board.GetLength(0); j++)
                    {
                        if (board[i, j] == true)
                        {
                            sb.Append('Q');
                        }
                        else
                        {
                            sb.Append('.');
                        }
                    }
                    newList.Add(sb.ToString());
                }
                result.Add(newList);
                return;
            }

            //logic
            for (int i = 0; i < board.GetLength(0); i++)
            {
                Console.WriteLine("row: " + row);
                Console.WriteLine("col: " + i);
                if (isSafe(row, i))
                {
                    board[row, i] = true;
                    backtracking(row + 1);
                    board[row, i] = false;
                }
            }
        }

        private bool isSafe(int r, int c)
        {
            for (int k = 0; k < r; k++)
            {
                Console.WriteLine(k + ":" + c);
                if (board[k, c] == true)
                    return false;
            }

            int i = r;
            int j = c;
            while (i >= 0 && j < board.GetLength(0))
            {
                if (board[i, j] == true)
                    return false;

                i--;
                j++;
            }

            i = r;
            j = c;
            while (i >= 0 && j >= 0)
            {
                if (board[i, j] == true)
                    return false;

                i--;
                j--;
            }

            return true;
        }
    }
}