using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    class WordSearchLC
    {
        //TC O(m*n * 3^L)
        int m, n;
        int[][] dirs;
        public bool Exist(char[][] board, string word)
        {
            if (board.Length == 0 || board == null)
            {
                return false;
            }
            m = board.Length;
            n = board[0].Length;
            dirs = new int[4][] { new int[]{ 0, 1 }, new int[] { 0, -1 }, new int[] { 1, 0 }, new int[] { -1, 0 } };
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (board[i][j] == word[0])
                    {
                        if (backtrack(board, word, 0, i, j))
                        {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private bool backtrack(char[][] board, string word, int index, int row, int col)
        {
            //base
            if (index == word.Length)
            {
                return true;
            }
            if (row < 0 || col < 0 || row == m || col == n || board[row][col] != word[index])
            {
                return false;
            }
            //logic
            //action
            char ch = board[row][col];
            board[row][col] = '#';
            foreach (int[] dir in dirs)
            {
                int r = row + dir[0];
                int c = col + dir[1];
                //recurse
                if (backtrack(board, word, index + 1, r, c)) return true;
            }
            //backtrack
            board[row][col] = ch;
            return false;
        }


    }
}
