//time complexity: O(n*m)
//space complexity:
//with recursive stack : O(n*m)
//without recursive stack: O(1)

class Solution {
    int[][] dirs=new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (board[i][j]==word.charAt(0))
                {
                    if(helper(board, word, 0, i, j))
                    {
                        return true;
                    }
                }
            }
        }        
        return false;
    }
    
    public boolean helper(char[][]board, String word, int start, int r, int c)
    {
        if(start==word.length()-1)
            return true;

        char temp=board[r][c];
        board[r][c]='#';

        for(int[] dir: dirs)
        {
            int x=r+dir[0];
            int y=c+dir[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && (start+1 < word.length()) && word.charAt(start+1)==board[x][y])
            {
                if(helper(board, word, start+1, x, y))
                
                return true;
            }
        }
        
         board[r][c] = temp;
       
        return false;
            
    }
}