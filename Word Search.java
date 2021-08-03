class Solution {

    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

    public boolean exist(char[][] board, String word) {

        for(int i=0 ; i<board.length ; i++)
        {
            for(int j=0 ; j<board[0].length ; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(helper(board,word,i,j,0)) return true;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word , int r , int c , int index)
    {
        if(index == word.length()) return true;
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!=word.charAt(index)) return false;

        char temp = board[r][c];
        board[r][c] = '.';

        for(int[] dir:dirs)
        {
            int nr = r+dir[0];
            int nc = c+dir[1];
            if(helper(board,word,nr,nc,index+1)) return true;
        }

        board[r][c] = temp;
        return false;
    }
}
