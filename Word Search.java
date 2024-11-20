/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

// T: O(4 ^ (m * n))

class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                
                if(dfs(board, word, i, j, visited))   return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited){
        
        int n = board.length;
        int m = board[0].length;
        
        //base
        
        if(word.length() == 0) return true;
        
        if(word.charAt(0) == board[i][j]){
            
            visited[i][j] = true;
            
            if(word.length() == 1)  return true;
            
            // moving right
            if(j < m - 1 && !visited[i][j + 1]){
                if(dfs(board, word.substring(1), i, j + 1, visited)) return true;
            }
            // moving left 
            if(j > 0 && !visited[i][j - 1]){
                if(dfs(board, word.substring(1), i, j - 1, visited)) return true;
            }
            // moving top
            if(i > 0 && !visited[i - 1][j]){
                if(dfs(board, word.substring(1), i - 1, j, visited)) return true;
            }
            // moving bottom
            if(i < n - 1 && !visited[i + 1][j]){
                if(dfs(board, word.substring(1), i + 1, j, visited)) return true;
            }
        }
        
        visited[i][j] = false;
        
        return false;
    }
}


// Faster Solution

// No extra space use the same board matrix to keep track of the visited (Just change the value to some thing out of a - z range)

class Solution {
    public boolean exist(char[][] board, String word) {
        
        char[] wordSearch = word.toCharArray();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                
                if(wordSearch(board, wordSearch, i, j, 0)) return true;
            }
        }
        
        return false;
    }
    
    public boolean wordSearch(char[][] board, char[] wordSearch, int i, int j, int pos){
        
        if(pos == wordSearch.length)    return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length)  return false;
        if(board[i][j] != wordSearch[pos]) return false;
        
        board[i][j] ^= 256;
        
        boolean wordFound = wordSearch(board, wordSearch, i + 1, j, pos + 1) ||
            wordSearch(board, wordSearch, i, j + 1, pos + 1) || wordSearch(board, wordSearch, i - 1, j, pos + 1) 
            || wordSearch(board, wordSearch, i, j - 1, pos + 1);
        
        board[i][j] ^= 256;
        
        return wordFound;
        
    }
}