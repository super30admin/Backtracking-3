/*
This solution utilises DFS with backtracking. We first search for the starting character of the word in the board. If found,
we initiate a DFS by successively checking the next characters by comparing them to the neighbouring characters on the board,
from the location where it matched originally. If we are able to successively match all the characters of the word to those on
the board, we have found the word.

Did this code run on leetcode: Yes
*/
class Solution {
    int[][] dirs;
    //Time Complexity: O(3^N) N = length of string, and raised to 3 because at any point during the path, we have only 3 choices to go to
    //Space Complexity: O(mn)
    public boolean exist(char[][] board, String word) {
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0,- 1}};
        int m = board.length;
        int n = board[0].length;
        
        //Searching for the first character of the word on the board
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word.charAt(0))
                    if(helper(board, i, j, 0, word, m, n))
                        return true;
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, int i, int j, int index, String word, int m, int n)
    {   //If we have been able to successively check all the letters of the word, we return true
        if(index == word.length())
            return true;
        
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '.')
            return false; 
        
        if(board[i][j] == word.charAt(index))
        {   //We modify the location at where the character was found so that we do not revisit it again
            board[i][j] = '.';
            
            for(int[] dir: dirs)
            {
                int r = i + dir[0];
                int c = j + dir[1];
                
                if(helper(board, r, c, index + 1, word, m, n))
                    return true;
                
            }
            //We change it back to its original character once we are done searching through that path
            board[i][j] = word.charAt(index);
        }
        
        return false;
    }
}