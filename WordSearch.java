// Time complexity: O(m*n*3^w) where m * n is matrix size and w is word length
// Space complexity: O(w) where w is word length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    // private static final int[][] dirs = {
    //     {0, -1},
    //     {0, 1},
    //     {-1, 0},
    //     {1, 0},
    // };
    
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, String word, int wordIndex) {
        // base
        if (wordIndex == word.length()) {
            return true;
        }
        
        //i, j
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return false;
        }
        
        if (word.charAt(wordIndex) == board[i][j]) {
           
            board[i][j] = '#';
            
            boolean found = exist(board, i, j-1, word, wordIndex+1) || // left
                                            
                            exist(board, i-1, j, word, wordIndex+1) || // up
                                            
                            exist(board, i+1, j, word, wordIndex+1) || // down
                
                            exist(board, i, j+1, word, wordIndex+1); // right
            
            if (!found) {
                board[i][j] = word.charAt(wordIndex);
            }
            return found;
        }
        
        return false;
    }
}

// for (int[] dir : dirs) {
//     inf newI = i + dir[0];
//     int newJ = j + dir[1];
//     if (exist(board, newI, newJ, word, wordIndex+1)) {
//         return true'
//     }
// }