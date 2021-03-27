//TC: O(n*m* 3^l) n-->rows and columns, l is length of word.
//SC: O(l)
//Executed on leetcode.
class Solution {
    String wordGiven = "";
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        if(board.length==0)
            return false;
        wordGiven = word;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(backtracking(board,0, i,j))	//When ever you find a first character of the word searching in the board call dfs 
                        return true;
                }
            }
        }
         
        return flag;
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean backtracking(char[][] board, int index, int r, int c)
    {
        if(index==wordGiven.length()-1)
        {
            return true;			//On finding the next character of searching word in the board, call the dfs again.
        }
        char temp = board[r][c];	//Once the index of the search word goes out of bound, returning that the word exists.
        board[r][c] = '*';
        for(int[] dir:dirs)
        {
            int x = r + dir[0];
            int y = c + dir[1];
            
            if(x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y] == wordGiven.charAt(index+1))
            {
                if(backtracking(board, index+1, x, y))
                    return true;
            }
        }
        
        board[r][c] = temp;
        return false;
    }
}