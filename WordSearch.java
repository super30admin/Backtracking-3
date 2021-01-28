// Time Complexity : O(3^n)
// Space Complexity : O(n) , n = length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : For each letter in the word, perform DFS to find the whole word while marking the position on the board as visited, and backtracking if a valid path i.e. the complete word was not found.

public class WordSearch {
    int count = 0;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j])
                    if(helper(board, word, i, j, 0))
                        return true;
            }
        }      
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, int row, int col, int index){

        if(index == word.length()) return true;
        
        if(row < 0 || row == board.length || col < 0 || col == board[0].length ){
            return false;
        } 
        
        if(board[row][col] == word.charAt(index)){
            char temp = board[row][col];
            board[row][col] = '#';

            int[][] dirs = {{1,0}, {0,1}, {0,-1}, {-1,0}};

            for(int i = 0; i < 4; i++){
                int r = row + dirs[i][0];
                int c = col + dirs[i][1];

                if(helper(board, word, r, c, index+1))
                    return true;
            }
            board[row][col] = temp;
        }       
        return false;
    }
}