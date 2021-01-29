//Time Complexity: o(n*3^l)
//space: o(l) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    int m; int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(helper(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][]board, String word, int index, int r, int c)
    {
        //base
        if(index == word.length())
        {   
            return true;
        }
        if(r<0 || c <0 || r == m || c ==n || board[r][c] == '#') return false;
        
        //logic
        int[][] dirs = {{0,1}, {-1,0}, {1,0},{0,-1}};
        if(board[r][c] == word.charAt(index)){
            char temp = board[r][c];
            board[r][c] = '#';
            for(int [] dir: dirs)
            {
                int row = dir[0] + r;
                int col = dir[1] + c;
                if(helper(board, word, index+1, row, col)) return true;
            }
            board[r][c]  = temp; 
        }
        return false;
    }
}