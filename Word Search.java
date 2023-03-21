class Solution {
    public boolean exist(char[][] board, String word) {
        
        //Time: O(N*3^L); L is the length of the word and 3 because at any given point after the 1st letter we explore only 3 directions.
		//Space: O(L) all the letters of the string are pushed on the stack
        
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                
                if(board[i][j] == word.charAt(0) && dfs(board, i, j,0, word) ){
                    return true;
                }
            }
        }
        
        return false;
    }
    
   public boolean  dfs(char[][] board, int i, int j, int count, String word){
        //I think we have to traverse along the string then call the dfs() for each character in the string.
       
       if(count == word.length()){
           return true;
       }
       
       
       //Look for the edges and corners of the board.
       
       if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)){
           
           return false;
           
       }
       
       //make the function calls for all the four neighbors of the cell.
      
       //Replace the visited cell with a blank character.
       char temp = board[i][j];
       board[i][j] = ' ';
       
       boolean found = dfs(board, i - 1, j, count + 1, word) ||
                       dfs(board, i, j + 1, count + 1, word) ||
                       dfs(board, i + 1, j, count + 1, word) ||
                       dfs(board, i, j - 1, count + 1, word);
       
       //put back the cell value after traversal is over
       
       board[i][j] = temp;
       return found;
       
    }
}