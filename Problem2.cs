public class WordSearch
    {
        // Time Complexity : O((m * n) 3^L)- where m * n is for iterating the board to find first character and 3^L is for having 3 options for each character in string of length L
        // Space Complexity : O(m * n) -  recursion stack space
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        int[][] directions;
        public bool Exist(char[][] board, string word)
        {
            if (board == null) return false;

            directions = new int[][] {
                new int[] { 0, 1 }, //right
                new int[] { 0, -1 }, //left
                new int[] { 1, 0 }, //down
                new int[] { -1, 0 } //up
            };

            int m = board.Length;
            int n = board[0].Length;
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if (board[i][j] == word[0])
                    {
                        if(backtrack(board, word, 0, i, j))
                        {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private bool backtrack(char[][] board, string word, int idx, int i, int j)
        {
            //base case
            if (idx == word.Length)
                return true;

            if (i < 0 || j < 0 || i == board.Length || j == board[0].Length)
                return false;

            //logic
            if (board[i][j] == word[idx])
            {
                //action
                board[i][j] = '#';
                //recurse
                foreach (var dir in directions)
                {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if (backtrack(board, word, idx + 1, r, c))
                        return true;
                }
                //backtrack
                board[i][j] = word[idx];
            }
            return false;
        }
    }
