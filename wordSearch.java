/**

board = [

 ["A","B","C","E"],
 ["S","F","E","S"],
 ["A","D","E","E"]
 
 ]
 
 [
 
 ["A","B","C","E"],
 ["S","F","E","S"],
 ["A","D","E","E"]
 
 ]
 
 word = ABCESEEEFS
 
**/
class Solution {
    
    
    int dirs[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public boolean exist(char[][] board, String word) {
        
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[0].length; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    if (dfsHelper(board, word, i, j, 0, new boolean[board.length][board[0].length]))
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfsHelper(char board[][], String word, int i, int j, int indexInWord, boolean visited[][])
    {
        
        if (indexInWord == word.length())
        {
            return true;
        }
        
        // base case
        if (i<0 || i>= board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(indexInWord) || visited[i][j])
        {
            return false;
        }
        
        visited[i][j] = true;
        
        // explore all the neighbours
        for (int dir[] : dirs)
        {
            int ni = dir[0] + i;
            int nj = dir[1] + j;
            
            if (dfsHelper(board, word, ni, nj, indexInWord + 1, visited))
            {
                return true;
            }
        }
        
        visited[i][j] = false;
        
        return false;
    }
}
