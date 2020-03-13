// Time Complexity : O(N!) n factorial. At each cell we have n(n-1) cells to choose.
// Space Complexity : O(N) -- Use nxn board to place queens but we place only n Queens at any point of time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        
        
        result = new ArrayList<>();
        if(n == 0)
            return result;
        int[][] board = new int[n][n];
        
        placeQueen(board, 0, n);
        // for(int i=0; i<n;i++){
        //     placeQueen(board, i, n);  // Check if Queen can be placed in each cell of first row.
        // }
        return result;
    }
    
    private void placeQueen(int[][] board, int r, int n){
        
        //base
        if(r== n){ // we have to perform the recursive backtracking until we last column in first row is reached.
            // Board[][] is filled with Queens in every row. Fill the result list in the right format and return.
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j] == 1){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
                result.add(li);
            }
        
        
        //logic
        // For each cell in first row, call recursion to validate if Queen can be placed in each row.
        for(int i=0;i<n;i++){
            if(isValidPosition(board, r, i, n)){  // r is row and i is column 
                board[r][i] = 1; // Action
                placeQueen(board, r+1, n); // Recursive action for next ROW.
                
                board[r][i] = 0; // Backtrack - EVen in case of valid position and non- valid position.
            }
        }
        
    }
    
    private Boolean isValidPosition(int[][] board, int r, int c, int n){
        
        // Column Check
        for(int i=0; i< r;i++){  // For the column 'c',from 0th row till the current row check for valid positions.
            if(board[i][c]==1) return false;
        }
        
        //No Row check needed as we are Queen placing in a new ROW
        
        // Diagonal left UP   //Always upward direction since we are dealing with validation above currnt row to place at current row.
        int i = r-1; int j = c-1;
        while(i >= 0 && j >=0){
            if(board[i][j] ==1) return false;
            i--; j--;
        }
        
         // Diagonal RIGHT  UP
         i = r-1; j = c+1;
        while(i >= 0 && j <n){
            if(board[i][j] ==1) return false;
            i--; j++;
        }
        
        return true;
    }
}
