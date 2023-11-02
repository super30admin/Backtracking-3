// Time Complexity : O(M*N3^L) where L is length of word and M & N is matrix length & breadth.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class WordSearch
{
    class Solution {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        int m , n;
        boolean result = false;
        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;

            for(int i = 0;i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(result == true)
                        return true;
                    if(board[i][j] == word.charAt(0))
                    {
                        board[i][j] = '#';
                        dfs(board, i, j, 1, word);
                        board[i][j] = word.charAt(0);
                    }
                }
            }

            return result;
        }

        void dfs(char[][] board, int curRow, int curCol, int idx, String word)
        {

            if(idx == word.length())
            {
                result = true;
                return;
            }

            for(int[] dir : dirs)
            {
                int nr = curRow + dir[0];
                int nc = curCol + dir[1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n)
                {
                    continue;
                }

                if(!result && board[nr][nc] == word.charAt(idx))
                {
                    board[nr][nc] = '#';
                    dfs(board, nr, nc, idx+1, word);
                    board[nr][nc] = word.charAt(idx);
                }
            }
        }
    }
}
