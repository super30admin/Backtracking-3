/*
 * Time complexity: mn * 3 ^ l (mn for the 'for' loop)
 * Space complexity: l (length of the word since we are not maintaining a visited set)
 */


class Solution {
    
    public boolean exist(char[][] board, String word) {

        //need to loop through all the char on board
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(exists(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean exists(char[][] board, int i, int j, String word, int wordIdx){
        //base case, need to check word length 1st before we check the boundary condition
         if(wordIdx == word.length()){
            return true;
        }
        
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        
        //recursion
        if(board[i][j] == word.charAt(wordIdx)){
            board[i][j] = '#';
            boolean ans = 
                exists(board, i,j-1,word,wordIdx+1) ||
                exists(board, i-1,j,word,wordIdx+1) ||
                exists(board, i,j+1,word,wordIdx+1) ||
                exists(board, i+1,j,word,wordIdx+1);
            
            board[i][j] = word.charAt(wordIdx);
            return ans;
        }
        return false;
    }
}