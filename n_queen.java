// Time Complexity : O(n!), where n is the number of queens
// Space Complexity : O(n^2), where n is the number of queens (space for board)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Three liner approach of your code in plain english
//1. Create a chess board of(n*n), at each row find the valid column to place the queen.
//2. once the board in filled, create a list from the board matrix converting 1's to 'Q' and 0's to '.', and add the list in the result
//3. Keep searching all the valid paths to place the queen in the board till all the cells in the board are explored

// Your code here along with comments explaining your approach
class Solution {
    
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        //to store the final result
        result = new ArrayList<>();
        m =n;
        //create a n*n chess board
        int[][] board = new int[n][n];
        //call the dfs
        backtrack(board, 0);
        return result;
    }
    
    private void backtrack(int[][] board, int row){
        //base
         if(row == m){
             //create a temp list
             List<String> temp = new ArrayList<>();
             StringBuilder sb;
             for(int i=0; i<m; i++){
                 //intialize the StringBuilder for each row
                 sb = new StringBuilder();
                 for(int j=0; j<m; j++){
                     if(board[i][j] == 1){
                         sb.append('Q');
                     }
                     else{
                         sb.append('.');
                     }
                 }
                 temp.add(sb.toString());
             }
             result.add(temp);
         }
        
        //logic
        //check if a cell is valid spot to place the queen and call recursion on the next row
        for(int i=row; i<m; i++){
            for(int j=0; j<m; j++){
                if(isValid(board, i, j)){
                    //action
                    board[i][j] = 1;
                    //recurse
                    backtrack(board, row+1);
                    //backtrack
                    board[i][j] = 0;
                }
            }
            return;
        }
    }
    
    private boolean isValid(int[][] board, int r, int c){
        //same column
        for(int i=0; i<r; i++){
            if(board[i][c]==1) return false;
        }
        
        //left upper diagonal
        int i=r; int j=c;
        while(i>=0 && j>=0){
            if(board[i][j] == 1) return false;
            i--; j--;
        }
        
        //right upper diagonal
        i=r; j=c;
        while(i>=0 && i<m && j<m){
            if(board[i][j] == 1) return false;
            i--; j++;
        }
        return true;
    }
}