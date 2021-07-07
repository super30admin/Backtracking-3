// 79.
//time - O(m * n)
//space - O(m * n)

class Solution {
    public boolean exist(char[][] board, String word) {
        //edge
        if(board == null || board.length == 0 || board[0].length == 0)
        {
            return false;
        }
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0)) //find the first char and start dfs
                {
                    if(dfs(board, word, 0, i, j)) //returns true if word is found
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    
    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        //base
        if(index == word.length() - 1)
        {
            return true;
        }
        //logic
        char current = board[row][col];
        board[row][col] = ' ';
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] direction : dirs) 
        {
            int nRow = row + direction[0];
            int nCol = col + direction[1];
            if(nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length)
            {
                //neighbour within bounds
                if(index + 1 < word.length() && word.charAt(index + 1) == board[nRow][nCol])
                {
                    //next index is valid and has same char as that in board
                    if(dfs(board, word, index + 1, nRow, nCol))
                    {
                        return true;
                    }
                }
            }
        }
        board[row][col] = current;
        return false;
    }
}
