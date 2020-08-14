public class WordSearch {

    //Time complexity: O(M*N*(4^L)) Matrix is M*n, L is length of the word
    //Space complexity: 

    //Approach:
    /**
     * 1. Traverse through the board and search from every character if the given word starts.
     * 2. Action : For the first character found, replace it with '#'
     * 3. Recurse : For every character in the word found, search the neighbors of the character in the board and search
     * recursively.
     * 4. Backtrack : replace the '#' with original character 
     */

    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0)
            return true;
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(backtrack(board, i, j, word))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, int i, int j, String word) {
        
        //Base
        
        if(word.length() == 0)
            return true;
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
            board[i][j] == '#')
            return false;
        
        //Logic
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        if(board[i][j] == word.charAt(0)) {
            
            char prev = board[i][j];
            board[i][j] = '#';
            
            for(int[] dir: dirs) {
                int r = dir[0] + i;
                int c = dir[1] + j;
                
                if(backtrack(board, r, c, word.substring(1))) {
                    return true;
                }
            }
            
            board[i][j] = prev;
        }
        
        return false;
    }
}