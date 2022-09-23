/*
## Problem2: Word Search(https://leetcode.com/problems/word-search/)

Time Complexity :   O ((M*N) 3^L )       where L - length of the word
Space Complexity :  O (L)     where L - length of the word
Did this code successfully run on Leetcode :    Yes (79. Word Search)
Any problem you faced while coding this :       No

 */
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true


// DFS Approach - connected components
class WordSearch_DFS_BackTrack {
    private int[][] dirs;
    int m, n;
    public boolean exist(char[][] board, String word) {
        dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        
        m = board.length;
        n = board[0].length;
        
        for (int i=0; i< m; i++){
            for (int j=0; j< n; j++){
                if(backtrack(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int index){
        // base
        if(index == word.length())
            return true;
        
        if(i< 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;
        
        
        // logic
        if(board[i][j] == word.charAt(index)){
            // action
            char c = board[i][j];
            board[i][j] = '#';
            
            // recurse
            for(int[] dir: dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                
                if(backtrack(board, word, nr, nc, index+1))
                    return true;
            }
            
            // backtrack
            board[i][j] = c;
        }
        
        return false;
    }
}