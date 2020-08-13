//Time Complexity: O(N!)
//Space Complexity: O(N^2)

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        backtrack(new int[n][n], n, 0);
        return result;
    }
    
    private void backtrack(int[][] board, int n, int row) {
         //base
        if(row == n) {
            List<String> state = new ArrayList<>();
            for(int i = 0; i < n; i++) {                
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 1) 
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                state.add(sb.toString());
            }
            result.add(state);
        }
        //logic 
        for(int i = 0; i < n; i++) {    
            if(isValid(board, row, i)) {
                board[row][i] = 1;  //action
                backtrack(board, n, row+1); //recurse (increment row)
                board[row][i] = 0; //backtrack
            }
        }
    }
        
    private boolean isValid(int[][] board, int row, int col) {        
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 1) return false;
        }        
        int i = row - 1, j = col - 1;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }       
        i = row - 1; j = col + 1;
        while(i >= 0 && j < board.length) {
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }
}