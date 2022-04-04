// Time Complexity : O(n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a boolean board of n*n size to track the placement of queens
// Now place the queen a position in a given row and check if its the right one
// Backtrack to original state, this way we would explore the possibilities
// We would check our placement is correct by checking if the top positions are 
// not having any queens or is safe by checking top leftDiagonal, top right diagonal and top of current column
// When we see row is equal to n, we would have a solution, and store it in result array.
class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        nQueens(board, 0);
        return result;
    }
    private void nQueens(boolean[][] board, int row){
        //base
        if(row == board.length){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < board.length; j++){
                    if(board[i][j]){
                        str.append("Q");
                    } 
                    else{
                        str.append(".");
                    }    
                }
                list.add(str.toString());
            }
            result.add(list);
            return;
        }
        //recurse
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                nQueens(board, row+1);
                board[row][col] = false;
            }
        }
    }
    private boolean isSafe(boolean[][] board, int row, int col){
        //topcolumn
        int i = row, j = col;
        for(i = row; i >=0; i--){
            if(board[i][j])
                return false;
        }
        //topleftDiagonal
        i = row - 1;
        j = col - 1;
        while(i >= 0 && j >= 0){
            if(board[i--][j--])
                return false;
        }
        //toprightDiagonal
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < board.length){
            if(board[i--][j++])
                return false;
        }     
        return true;
    }
}