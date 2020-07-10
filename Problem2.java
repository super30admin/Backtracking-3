
//Problem2
// Word Search(https://leetcode.com/problems/word-search/)

// Time - O(n*4^l) l is the length of the word and n is the number of cells
// Space - O(l) - recursive stack
class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0 || word == null || word.length() == 0) return false;
        
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, i, j, word)) return true;
            }
        }
        
        return false;
        
    }
    
    private boolean dfs(char[][] board, int i, int j, String word){
        // base
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '*')
            return false;
        
        // logic
        
        if(word.charAt(0) == board[i][j]){
            if(word.length() == 1) return true;
           
            board[i][j] = '*';
        
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(dfs(board, r, c, word.substring(1))) return true;
            }

            board[i][j] = word.charAt(0);
        }
        
        
        return false;
        
    }
}