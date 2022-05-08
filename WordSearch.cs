using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    public class WordSearch
    {
        /*
         * T.C: 4 power L * m*n where 4 is direction and L is length of word and m* n is matrix
         * S.C: O(N) length of word
         * 
         */
        int m, n;
        int[,] dir;

        public bool Exist(char[][] board, string word)
        {
            if (board == null || board.Length == 0) return false;

            m = board.Length;
            n = board[0].Length;

            dir = new int[,] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; //R,L,D,U

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (helper(board, word, 0, i, j) == true)
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        private bool helper(char[][] board, string word, int index, int r, int c)
        {
            //base
            if (index == word.Length)
            {
                return true;
            }

            if (r < 0 || r == m || c < 0 || c == n || board[r][c] == '#')
            {
                return false;
            }
            //logic

            if (word[index] == board[r][c])
            {
                char ch = board[r][c];
                board[r][c] = '#';

                for (int j = 0; j < dir.GetLength(0); j++)
                {
                    int nr = r + dir[j, 0];
                    int nc = c + dir[j, 1];

                    if (helper(board, word, index + 1, nr, nc) == true)
                        return true;

                }
                //backtracking
                board[r][c] = ch;
            }

            return false;
        }
    }
}
