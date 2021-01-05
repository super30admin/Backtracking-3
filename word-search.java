// Time - O(MN)
// Space - O(MN)

class Solution {
    int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                if(backtrack(board, word, visited, i, j, 0)){
                   return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index){
        //base case for result
        if(index==word.length()) {
            return true;
        }
            
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || index>word.length()){
            return false;
        }
        
               
        if(board[i][j]==word.charAt(index) && !visited[i][j]) {   
            // mark visited
            visited[i][j] = true;
                
            // explore other directions 
            for(int[] dir: dirs){                 
                int r = i + dir[0];
                int c = j + dir[1];
                
                if(backtrack(board, word, visited, r, c, index+1)) {
                    return true;
                }
            }
            
            //mark unvisited                    
            visited[i][j] = false;
        }
        
        return false;
    }
}
