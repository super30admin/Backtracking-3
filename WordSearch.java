// TC: O(3^L * N) -> L : length of word, N -> no. of elements of the grid
// SC: O(L) -> L : length of word
// Did it run sucessfully on Leetcode? : Yes
class Solution {
    int m, n;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                if (backtrack(board, word, i,j, 0))
                  return true;
            }
        }
        return false;
    }
        private boolean backtrack(char[][] board, String word, int i, int j, int index)
        {
            //base
            if (index == word.length())
                return true;
            if ( i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#')
                return false;
            
            //logic
            int[][] dirs = new int[][]{{0,1}, {1,0}, {0, -1}, {-1,0}};
            if (word.charAt(index) == board[i][j])
            {
                char temp = board[i][j];
                //action ( instead of marking  board[i][j] as visited just make the same element to '#' to make it
                //visited. Before changing it to '#' store the actual value in a temp variable so that when we need find the required character going forward, we can backtrack.) 
                board[i][j] = '#';
                for ( int[] dir: dirs)
                {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if (backtrack(board, word, r, c, index+1))
                        return true;
                }
                //backtrack
                board[i][j] = temp;
            }
            return false;
        }

}
