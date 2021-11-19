// N queens
// time - O(n!)
// space - O(n2)

class Solution {
    List<List<String>> result;
    boolean[][] board;
    int n;
    
    public List<List<String>> solveNQueens(int n) {
        
            this.n = n;
            board = new boolean[n][n];
            result = new ArrayList();
            backTrack(0);
        
            return result;
    }
    
    private void backTrack(int row){
        // base
        
        if (row == n){
           
            List<String> state = new ArrayList();
            for(int i = 0; i < board.length; i ++ ){
                
                StringBuilder sb = new StringBuilder();
                
                for (int j = 0; j < board[0].length; j ++ ){
                    
                    if (board[i][j]){
                        sb = sb.append("Q");
                    }else{
                        sb = sb.append(".");
                    }
                    
                }
                state.add(sb.toString());
            }
            
            result.add(state);
            return;
        }
        
        for (int j = 0; j < n; j++ ){
            
            if(isSafe(row,j)){
                // action
                board[row][j] = true;
                // recursion;
                backTrack(row + 1);
                // backtrack
                board[row][j] = false; 
            }
        }
        
    }
    
    private boolean isSafe(int i, int j){
        
        // upper colmn
        for (int row = 0; row < i; row ++){
            if (board[row][j] == true) return false;
        }
        
        int row = i;
        int col = j;
        
        // upper left diagnol
        while (row >= 0 && col >= 0){
            
            if (board[row][col]){
                return false;
            }
            row = row - 1;
            col = col - 1;
            
     
        }
        
         row = i;
         col = j;
        
        // upper right diagnol
        while (row >= 0 && col < board[0].length){
            
            
            if (board[row][col] == true){
                return false;
            }
            row = row - 1;
            col = col + 1;  

        }
        
        
        return true;
    }
}