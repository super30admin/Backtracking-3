class Solution {
    //Time O(N*3^L)
    //Space O(N)
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0)
        {
            return true;
        }
        int m = board.length , n = board[0].length;
        for(int i=0 ; i<m ; i++)
        {
            for(int j=0 ; j<n ; j++)
            {
                    if(helper(board , word , 0 , i , j))
                    {
                        return true;
                    }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word , int index , int i, int j)
    {
        //base
        if(index == word.length())
        {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#')
        {
            return false;
        }
        //logic
        if(word.charAt(index) == board[i][j])
        {
            char temp = word.charAt(index);
            board[i][j] = '#';
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] dir : dirs)
            {
                int r = dir[0] + i;
                int c = dir[1] + j;
                if(helper(board , word , index+1 , r , c))
                {
                    return true;
                }
            }
            board[i][j] = temp; // BackTrack
        }
        return false;
    }
}