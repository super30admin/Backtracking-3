// Time Complexity : O(m*n*(3^L); where m = number of rows, n= number of columns and L = length of the word
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, i, j, 0, word)) return true;

            }
        }
        return false;
    }
                   
    private boolean backtrack(char[][] board, int i, int j, int index, String word){
        // base
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
        
        // logic
        if(board[i][j] == word.charAt(index)){
            // action
            char ch = board[i][j];
            board[i][j] = '#';
            
            for(int[] dir : dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                
            //recurse
            if(backtrack(board, r, c, index + 1, word)) return true;

            }      
            // backtrack
            board[i][j] = ch;
        }
        return false;
    }
}