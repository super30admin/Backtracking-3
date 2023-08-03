package BackTracking;
// Time Complexity : O(m*n (3^L))) L->Length of the input string
// Space Complexity : O(L) ->Recursive stack space which will be the length of the input string
// Did this code successfully run on Leetcode : Yes
public class WordSearch {
    boolean flag;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!flag)
                {
                    helper(board, word, i, j, 0);
                }
            }
        }
        return flag;
    }

    private void helper(char[][] board, String word, int i, int j, int idx)
    {
        if(idx == word.length())
        {
            flag = true;
            return;
        }
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]=='#')return;
        if(board[i][j] == word.charAt(idx))
        {
            for(int[] dir: dirs)
            {
                int r = dir[0]+i;
                int c = dir[1]+j;
                if(!flag)
                {
                    board[i][j] = '#';
                    helper(board, word, r, c, idx+1);
                    board[i][j] = word.charAt(idx);
                }
                if(flag) break;
            }
        }
    }
}
