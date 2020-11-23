package Nov22;

import java.util.ArrayList;
import java.util.List;

class NQueens {
    
/*
       
     Time Complexity: O(N!)
     First row: N options for placing a queen
     Second row: N-2 options for placing a queen
     Third row: N-4 options for placing a queen
     ...
     ...
     So number of options for placing a queen keep reducing as we move from top row to bottom row of the board => N!
     
     Space Complexity: O(n^2) board complexity + O(n) recursive calls ~= O(n^2)
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
       
*/
    
    List<List<String>> result;
    int[][] board;
    int dimension;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        dimension = n;
        // edge
        if (n == 0) {
            return result;
        }
        // call function for first row of the board
        backtrack(0);
        return result;
    }
    //  backtrack function
    public void backtrack(int row) {
        
        // base
        if (row == dimension)  {
            // implies all rows of the board have been iterated and queens placed successfully in each of them.
            // we can fetch this entire arrangement of the board achieved so far in a list where each element is a string representing the values in each row{
            List<String> temp = new ArrayList<>();
            
            for (int i = 0; i < dimension; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < dimension; j++) {
                    if (board[i][j] == 1) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }
        // logic
        // iterate through all cells of the board's row to find out if it is safe to place a queen there.
        // if yes, place a queen and then call backtrack function recursively for subsequent row. 
        //         revert/backtrack the action of placing the queen.
        for (int i = 0; i < dimension; i++) {
            if (isSafe(row, i)) {
                // action
                board[row][i] = 1;
                // recurse
                backtrack(row+1);
                // backtrack
                board[row][i] = 0;  
            }
        }
    }
    // helper function to check if it is safe to place a queen at (i,j)
    public boolean isSafe(int r, int c) {
        // check in (0 to r-1) rows and Cth column
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 1) {
                return false;
            }
        }
        
        int i = r, j = c;
        // check in diagonal left
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--; j--;
        }
        
        // check in diagonal right
        i = r; j = c;
        while (i >= 0 && j < dimension) {
            if (board[i][j] == 1) {
                return false;
            }
            i--; j++;
        }
        
        return true;
    }    
}