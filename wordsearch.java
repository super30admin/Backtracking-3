// DFS + backtrack 
// TC m * n * (3 ^ L)
// SC O(L) recursive stack space

class Solution {
    
    String inword;
    int m;
    int n; 
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || word.isEmpty()) return false; 
        m = board.length;
        n = board[0].length; 
        inword = word;
        
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if(backtrack(board, i, j, 0)) return true;
            }
        }
        return false; 
    }
    
    public boolean backtrack(char[][] board, int r, int c, int index){
        // base
        if(index == inword.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length ) return false;  
        
        
        
        // logic 
        if(board[r][c] == inword.charAt(index)){
            
            // action
            char temp = board[r][c];
            board[r][c] = '#';
            
            
            // recurse 
            // go up
            if(backtrack(board, r-1, c, index+1)) return true; 
            
            
            // go down
           if(backtrack(board, r+1, c, index+1)) return true; 
                
           
                
            
            // go left
           if(backtrack(board, r, c-1, index+1)) return true;
            
            
            // go right
            if(backtrack(board, r, c+1, index+1)) return true;
            
            
            
            // bactrack
            board[r][c] = temp;
            
            
            
        }
        return false; 
        
        
        
        
    }
}
