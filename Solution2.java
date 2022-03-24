class Solution {
    
    private static final int[][] directions = {
        {-1, 0}, //up
        {1, 0}, //down
        {0, -1}, //left
        {0, 1} //right
    };
    
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(exist(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, String word, int wordIndex){
        if(wordIndex==word.length()){
            return true;
        }
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == '#'){
            return false;
        }
        
        if(word.charAt(wordIndex) == board[i][j]){
            board[i][j] = '#';
            for(int[] dir : directions){
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if(exist(board, newI, newJ, word, wordIndex + 1)){
                    return true;
                }
        }
            board[i][j] = word.charAt(wordIndex);
        }
        
        return false;
    }
    
    
}
