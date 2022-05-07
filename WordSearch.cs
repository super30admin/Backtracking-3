// Time Complexity : O(m*n*4^w), w is world length, we are making 4 choices for eahc charater in word and doing this for complete grid.
// Space Complexity : O(w),  we are calling maximum word length in for loop, that’s the maximum characters we have, because if doesn’t match, we don’t move to that path.so maximum path can be length of target word length.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

 int m, n;
int[][] dirs;
public bool Exist(char[][] board, string word) {
    if(board == null || board.Length == 0)
        return false;
    
    m = board.Length;
    n = board[0].Length;
    
    dirs = new int[][]{new int[]{0,1}, new int[]{0,-1}, new int[]{1,0}, new int[]{-1,0}};
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(backtracking(board, word, i, j, 0))
                return true;
        }
    }
    return false;
}

private bool backtracking(char[][] board, string word, int row, int col, int index)
{
    //base
    if(index == word.Length)
        return true;
    
    if(row < 0 || col < 0 || row >= m || col >= n || board[row][col] == '#')
        return false;
    
    //logic        
    if(board[row][col] == word[index])
    {
        //action
        char ch = board[row][col];
        board[row][col] = '#';
        
        //recursion
        foreach(var dir in dirs)
        {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(backtracking(board, word, nr, nc, index+1))
                return true;
        }
        
        //backtrack
        board[row][col] = ch;
    }
    
    return false;
}