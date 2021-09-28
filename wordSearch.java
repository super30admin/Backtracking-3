// Time Complexity : O(N * 3^M), m is the length of the word 
// Space Complexity : O(M), m is the length of the word 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class wordSearch {
    public boolean exist(char[][] board, String word) {
        
        for(int x = 0; x < board.length; x++){
		    for(int y = 0; y < board[0].length; y++){
                if(check(board, x, y, word, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean check(char[][] board, int x, int y, String word, int wordIndex){

        if(wordIndex == word.length()) return true;
        
        if( x < 0 || x >= board.length ||  y < 0 ||  y >= board[0].length) return false;
		
		char charCurr =  board[x][y];

		if(charCurr == '*') return false;

		if(charCurr != word.charAt(wordIndex)) return false;

        board[x][y] = '*'; //marked as visited
        
        boolean isExist = check(board, x + 1, y, word, wordIndex + 1) ||    
        check(board, x - 1, y, word, wordIndex + 1) ||    
        check(board, x, y + 1, word, wordIndex + 1) ||   
        check(board, x, y - 1, word, wordIndex + 1);     
            
	
        board[x][y] = charCurr;
        
        return isExist;
    }
    
}
