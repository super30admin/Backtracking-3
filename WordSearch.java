/*
Time: O(MxN * 4^L) where L is length of string and MxN are matrix row and column size respectively
Space: O(1)
Algorithm:
=========
1. Use dfs to search for the string in the matrix, but the issue is when we mark it as visited, we might actually be missing finding
part of string without backtracking
2. Use backtracking to reverse the changes made to matrix values if string is not found. This lets matrix be intact when already visited and not
matched character is part of string
*/
class Solution {
    int m,n ;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word.length() == 0) return true;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                 if(dfs(board, word, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j) {
        //base
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' ) return false;
        //logic
        if(board[i][j] == word.charAt(0)) {
            board[i][j] = '#';          // action
            
            if(word.length() == 1) return true; // found the string
            
            int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            for(int[] dir: dirs) {              // check for next char in neighbors
                int r = dir[0] + i;
                int c = dir[1] + j;
                
                if(dfs(board, word.substring(1), r, c)) return true;    // dfs on the board for next character
            }
            board[i][j] = word.charAt(0);       // backtrack
        }
        return false;
    }
}