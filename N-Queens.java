// TC - O(n!), SC - O(n^2)

class Solution {
    // Creating a global variable
    List<List<String>> output = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // Take a 2d string array with size n X n
        String[][] board = new String[n][n];
        // Initially fill it with "."
        for(String[] row : board){
            Arrays.fill(row, ".");   
        }
        backtrack(board, n, 0);
        return output;
    }
    
    // backtrack function
    private void backtrack(String[][] board, int n, int curRow){
        // base condition, if curRow >= n, add board to output
        if(curRow >= n){
            output.add(outputHelper(board));
            // printBoard(board);
            // System.out.println();
            return;
        }
        
        // Iterate from 0 to last column in board
        for(int i=0; i<n; i++){
            // check if it is safe to place q in cur position on board
            if(isSafe(board, n, curRow, i)){
                // place queen on board curRow and i index
                board[curRow][i] = "Q";
                // call backtrack function
                backtrack(board, n, curRow+1);
                // remove q and place a "."
                board[curRow][i] = ".";
            }
        }
    }
    
    // isSafe function to check if it is safe to place queen at particular position
    private boolean isSafe(String[][] board, int n, int curRow, int curCol){
        
        // check in column
        for(int i=0; i<n; i++){
            if(board[i][curCol] == "Q"){
                return false;
            }
        }
        
        // check left top diagonally
        for(int i=curRow, j=curCol; i>=0 && j>=0; i--, j--){
            if(board[i][j] == "Q"){
                return false;
            }
        }
        
        // check right top diagonally
        for(int i=curRow, j=curCol; i>=0 && j<n; i--, j++){
            if(board[i][j] == "Q"){
                return false;
            }
        }
        
        return true;
        
    }
    
    // private void printBoard(String[][] board){
    //     for(int i=0; i<board.length; i++){
    //         for(int j=0; j<board[0].length; j++){
    //             System.out.print(board[i][j]);
    //         }
    //         System.out.println();
    //     }
    // }
    
    // Output helper function to add board into list
    private List<String> outputHelper(String[][] board){
        
        List<String> temp = new ArrayList<>();
        
        for(int i=0; i<board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<board[0].length; j++){
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }
}