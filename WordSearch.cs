using System;
namespace Algorithms
{
    /// Time Complexity : O(M*N 3^L)
    // Space Complexity :O(m)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class WordSearch
    {
        int[,] dirs;
        int m, n;
        public bool Exist(char[][] board, string word)
        {
            // check the first occurance of the character in the matrix 
            //find the next char in 4 direction 
            //keep the track of visited 
            //when recursion is going back default the visited element 
            // Time m * n 3^L
            //Space m*n (if vistited array ), otherwise number of rows 
            if (board == null || word == null) return false;
            dirs = new int[4, 2] { { 0, 1 }, { 0, -1 }, { 1, 0, }, { -1, 0 } };
            m = board.Length;
            n = board[0].Length;
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (backtrack(board, word, i, j, 0)) return true;
                }
            }
            return false;
        }

        private bool backtrack(char[][] board, string word, int i, int j, int index)
        {
            //base
            if (index == word.Length) return true;
            if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
            //logic
            if (board[i][j] == word.ToCharArray()[index])
            {
                //action
                char temp = board[i][j];
                board[i][j] = '#';

                //recurse
                for (int k = 0; k < dirs.GetLength(0); k++)
                {
                    int nr = i + dirs[k, 0];
                    int nc = j + dirs[k, 1];
                    if (backtrack(board, word, nr, nc, index + 1)) return true;
                }

                //back track
                board[i][j] = temp;
            }
            return false;
        }
    }
}
