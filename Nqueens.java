public class Nqueens {
    
    //Time complexity: O(N!) N is size of the board
    //Space complexity: O(N^2) 

    //Approach:
    /**
     * 1. Traverse the row wise.
     * 2. Action : Try for placing queen at each position in a row if it is safe to place and mark the position
     * as 1 -> safe to place
     * 3. Recurse:  recurse for all the safe positions for each row considering the earlier row's position is safe
     * 3. Backtrack: Replace the value in that position as 0
     */

    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        
        result = new ArrayList<>();
        int[][] board = new int[n][n];
        
        placeQueen(board, 0);
                
        return result;
        
    }
    
    private void placeQueen(int[][] board, int r) {
        
        //base
        if(r == board.length) {
            List<String> list = new ArrayList<>();
            for(int i=0; i<board.length; i++) {
                
                StringBuilder sb = new StringBuilder();
                
                for(int j=0; j<board.length; j++) {
                    if(board[i][j] == 0) {
                        sb.append(".");
                    }
                    else
                        sb.append("Q");
                }
                list.add(sb.toString());
            }
            
            result.add(list);
        }
        
        //Logic
        //Check for column
        for(int i=0; i<board.length; i++) {
            
            if(isSafe(board, r, i)) {
                //action
                board[r][i] = 1;
            
                //recurse
                placeQueen(board, r+1);
                
                //backtrack
                board[r][i] = 0;
            }
        }
        
        
    }
    
    private boolean isSafe(int[][] board, int r, int c) {
        
        //Check column
        for(int i=0; i<=r; i++) {
            if(board[i][c] == 1)
                return false;
        }
        
        //Check diagonal up right
        int i = r-1, j = c+1;
        while(i >= 0 && j < board.length) {
            if(board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        
        //Check diagonal left
        i = r-1;
        j = c-1;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        
        return true;
    }

}