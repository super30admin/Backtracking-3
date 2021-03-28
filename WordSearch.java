// Time Complexity : O(n*3m) n - matrix size, m- length of the word to be matched
// Space Complexity : O(m)  m - Length of the word to be matched
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int count;
        for(int r=0;r<row;r++)
        {
            for(int c=0;c<col;c++)
            {
                if(board[r][c] == word.charAt(0) && dfs(board,r,c,0,word))
                {
                    return true;
            }}
        }
        return false;
    }
        
  // dfs for checking if the next char exits in other three directions, and traverse till last char found
  // If not found backtrack by replacing the value back by storing in a temporary variable
    public boolean dfs(char[][] board,int row, int col,int count, String word)
    {
        if(count == word.length())
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length|| board[row][col]!= word.charAt(count))
            return false;
        char temp =board[row][col];
        board[row][col] = ' ';
        boolean flag = dfs(board,row+1,col,count+1,word) || dfs(board,row-1,col,count+1,word) || dfs(board,row,col+1,count+1,word) || dfs(board,row,col-1,count+1,word);
        board[row][col] = temp;
        return flag;
    
    }
}
