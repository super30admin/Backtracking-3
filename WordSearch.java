/*
 * Time Complexity = m*n*4^L
 * Space Complexity = m*n+L where L is the length of word
 * 
 *  Executed successfully on Leetcode : Yes
 */
class Solution {
    
    int m;
    int n;
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
    
        m = board.length;
        if(board == null || m == 0){
            return false;
        }
        
        n = board[0].length; 
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, word, i, j))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int  c){
        
        //Base case
        if(r < 0 || r >= m || c < 0 || c >= board[0].length || visited[r][c]){
            return false;
        }
        
        
        //Logic
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        if(board[r][c] == word.charAt(0)){
            if(word.length() == 1){
                return true;
            }    
            
            visited[r][c] = true;
           
            for(int[] dir : dirs){
                int i = r + dir[0];
                int j = c + dir[1];
                
                if(dfs(board, word.substring(1), i, j)){
                    return true;
                }
            }
           
            visited[r][c] = false;
            
        }
        
        return false;
        
        
    }
}