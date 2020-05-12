class Solution {
    Character temp;
    public boolean exist(char[][] board, String word) {
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (backtrack(board,i,j,0,word)){
                        return true;
                    }
                }
            }
        }
        
        return false;
        
    }
    
    
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    
    private boolean backtrack(char[][] board, int i, int j, int index, String word){
        // base case
        if (index == word.length() - 1){
            return true;
        }
        
        char temp = board[i][j];
        board[i][j] ='$';
        // recursive case
        
        for (int[] direction : dirs){
            int r = i + direction[0];
            int c = j + direction[1];
            
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && (index + 1 < word.length()) && word.charAt(index + 1) == board[r][c]){
                if (backtrack(board,r,c,index + 1,word)){
                    return true;
                }
            }
        }
        board[i][j] = temp;
        return false;
    }
    
}