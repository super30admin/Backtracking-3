// Time Complexity : O(m*n*4^L) where m and n are the dimensions of the board and L is the length of the word. In the worst case, we might have to explore all possible paths from each cell.
// Space Complexity : O(L) where L is the length of the word. This is the maximum depth of the recursion stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : thinking about backtracking.


// Your code here along with comments explaining your approach
 class Solution {
    public boolean exist(char[][] board, String word) {
        int rows= board.length;
        int cols=board[0].length;
        if(word.length()>rows*cols) return false;
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(board[r][c]==word.charAt(0))
                {
                    if(dfs(board,word,r,c,0))
                    {
                        return true;
                    }
                }
            }
        } return false;
    }
    private boolean dfs(char[][] board, String word, int r, int c, int idx)
    {
        if(idx== word.length())
        {
            return true;
        }
        if(r>=board.length||c<0||r<0||c>=board[0].length||board[r][c]!= word.charAt(idx))
        {
            return false;
        }
        char temp=board[r][c];
        board[r][c]='#';
        boolean found=dfs(board,word,r+1,c,idx+1)||dfs(board,word,r-1,c,idx+1)||dfs(board,word,r,c+1,idx+1)||dfs(board,word,r,c-1,idx+1);
        board[r][c]=temp;
        return found;
    }
}