// Time Complexity : O(m * n * m * n) for every character it will explore the whole grid in worst case; m = number of rows, n = number of columns
// Space Complexity : O(m * n) m = number of rows, n = number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        
        boolean [][]visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            
            for(int j = 0; j < board[0].length; j++){
                
                if(word.charAt(0) == board[i][j] &&
                    bfs(board, 0, word, i, j, visited)){
                    return true;
                }
                
            }
            
        }
        return false;
    }
    
    private boolean bfs(char[][] board, int index, String word, int r, int c, boolean[][] visited){
        
        //base case
        if(index >= word.length())  return true;
        
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || word.charAt(index) != board[r][c] || visited[r][c] == true)   return false;
        
            visited[r][c] = true;
        
            for(int dir[]: dirs){
                if(bfs(board, index+1, word, r + dir[0], c + dir[1], visited)){
                    return true;
                }    
            }
            visited[r][c] = false;
        
        return false;
    }
}
