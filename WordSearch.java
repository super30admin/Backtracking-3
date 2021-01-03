class Solution {
    public boolean exist(char[][] board, String word) {
        
        // Iterate over the board row-by-row
        for(int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length ; j++) {
                // check whether the input word exists on the given board with the current postion on the board as the starting position
                if(checkTheWordExist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        // word does not exist on the board
        return false;
    }

    public boolean checkTheWordExist(char[][] board, String word, int currentRow, int currentColumn, int index) {
        // word has been found
        if(index >= word.length()) {
            return true;
        }

        // check current position is within the board dimensions and current character matches
        if(currentRow < 0 || currentRow >= board.length || currentColumn < 0 || currentColumn >= board[0].length || word.charAt(index) != board[currentRow][currentColumn]) {
            return false;
        }
        
        // store the original character in a variable
        char originalCharacter = board[currentRow][currentColumn];
        
        // mark the current postion on the board as visited
        board[currentRow][currentColumn] = '-';
        
        // Array to help move  right, down, left, up
        int[] rowDirection = {0, 1, 0, -1};
        int[] columnDirection = {1, 0, -1, 0};

        // move right, down, left, up from the current position on the board
        for(int i = 0 ; i < 4 ; i++) {
            
            if(checkTheWordExist(board, word, currentRow + rowDirection[i], currentColumn + columnDirection[i], index + 1)) {
                // if you found the pattern restore the original character on the board and return true
                board[currentRow][currentColumn] = originalCharacter;
                return true;
            }
        }
        
        // if none of the characters matched then restore the original character and return false
        board[currentRow][currentColumn] = originalCharacter;
        return false;

    }
}
