class NQueens {
    
    // Time Complexity: O(n!)   (where n -> no. of queens to place)
    // Space Compexity: O(n)
    
    private List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        // Edge Case Checking
        if(n == 0)
            return result;
        
        // Filling the board with '.'
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = '.';
            }
        }
        
        backtracking(board, n, 0);
        return result;
    }
    
    private void backtracking(char[][] board, int n, int i){
        // If no more queens to place - then add the current board to the output
        if(n == 0){
            result.add(outputHelper(board));
            return;
        }
        
        for(int j = 0; j < board[0].length; j++){
            // If we can place the queen at the current position - place it and then move ahead.
            if(isValid(board, i, j)){
                board[i][j] = 'Q';
                backtracking(board, n-1, i+1);
                board[i][j] = '.';
            }
        }
    }
    
    // Function to add the valid board combination to the output list
    private List<String> outputHelper(char[][] board){
        List<String> temp = new ArrayList();
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }
    
    // Function to check if we can place a queen at a certain position
    private boolean isValid(char[][] board, int i, int j){
        int row = i;
        int col = j;
        
        // UP - Checking if there are no queens placed earlier in the upward direction (in the same column)
        while(row >= 0){
            if(board[row][col] == 'Q')
                return false;
            row--;
        }
        
        // Upper Left Diagnoal - Checking if there are no queens placed earlier in the up-left diagonal (row-1, col-1)
        row = i;
        col = j;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        
        // Upper Right Diagonal - Checking if there are no queens placed earlier in the up-right diagonal (row-1, col+1)
        row = i;
        col = j;
        while(row >= 0 && col < board[0].length){
            if(board[row][col] == 'Q')
                return false;
            row--;
            col++;
        }
        
        // If no queens are placed earlier in up, up-left diagnoal and up-right diagonal then return true
        return true;
    }
}