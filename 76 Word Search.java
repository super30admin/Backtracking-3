
// Time Complexity : 0(m*n)
// Space Complexity : 0(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    //aesha
    int m,n;
    int[][] dirs;
    boolean flag; 
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i = 0;i <m; i++)
        {
            for(int j = 0;j <n ;j++)
            { 
                if(!flag)
                {
                    helper(board, i,j, word, 0);
                }else
                    break;
            }
        }
        return flag;
    }
    public void helper(char[][] board, int i, int j, String word, int idx)
    {
        //base case
         if(idx == word.length())
        {
            flag = true;
            return;
        }
        if(i<0 || j<0 || i==m || j==n || board[i][j] == '#')
        {
            return;
        }
        //logic
        if( word.charAt(idx)==board[i][j])
        {
            board[i][j] = '#';
            for(int[] dir : dirs )
            {
                int r = dir[0] + i;
                int c = dir[1] + j;
                if(!flag)
                helper(board, r, c, word, idx+1);
            }
            board[i][j] =  word.charAt(idx);
        }

    }
}