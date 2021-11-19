// word search
// time - mn * 3^n
// space - len(word)
class Solution {
    public boolean exist(char[][] board, String word) {
        
        

        
        for(int i = 0; i < board.length; i ++){
            
            for(int j = 0; j < board[0].length; j++){
                
                if (helper(i, j, 0, board, word)){
                    
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    private boolean helper(int row, int col, int index, char[][] board, String word){
        
        
        if (index == word.length()){
            
            return true;
        }
        // base
        if (board[row][col] == '#'){
            return false;
        }
        

        // recursive 
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        if (word.charAt(index) == board[row][col])
        {
             char c = board[row][col];
             board[row][col] = '#';
            
             for(int[] dir : directions){

                int nR = row + dir[0];
                int nC = col + dir[1];

                if (nR  >= 0 && nC >= 0 && nR < board.length && nC < board[0].length)
                {

                   if(helper(nR, nC, index+1, board, word)) return true;
                }
            }
            
            board[row][col] = c;
        }
          
        return false;
    }
}