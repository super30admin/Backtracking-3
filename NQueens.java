/*
* Approach:
*  1. Maintain a boolean array to keep track of queens placement.
        Place the queens in each column. 
* 
*  2.  Iterate over first column, 
            check the cell is safe or not:
                check the cells left to the curr cell,
                check top-left and bottom-left cells from curr cell.
            add place queen in one of the cells,
            and proceed to another column.
* 
*  3. If any of the cells are not safe, backtrack and explore other paths.
        once all the queens are placed without conflicts, 
            append the sol to result.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n^n)
* 
* Space Complexity: O(n^2)
    n^2 boolean grid
* 
*/

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    boolean[][] grid;

    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.grid = new boolean[n][n];

        this.result = new ArrayList<>();

        backtrack(0, n);

        return result;        
    }

    private void backtrack(int col, int n){
        if(col == n){
            List<String> sol = new ArrayList<>();

            for(int rowIndex = 0; rowIndex < n; rowIndex++){

                StringBuilder rowStr = new StringBuilder();

                for(int colIndex = 0; colIndex < n; colIndex++){
                    if(grid[rowIndex][colIndex])
                        rowStr.append('Q');
                    else
                        rowStr.append('.');
                }

                sol.add(rowStr.toString());
            }

            result.add(sol);
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafe(row, col, n)){
                grid[row][col] = true;

                backtrack(col+1, n);

                grid[row][col] = false;
            }
        }
    }

    private boolean isSafe(int row, int col, int n){
        // left direction
        for(int colIndex = col; colIndex >=0; colIndex--){
            if(grid[row][colIndex])
                return false;
        }

        //top-left
        for(int i = row, j = col; i>=0 && j>=0; i--,j--){
            if(grid[i][j])
                return false;
        }

        //bottom-left
        for(int i = row, j = col; i<n && j>=0; i++,j--){
            if(grid[i][j])
                return false;
        }

        return true;
    }
}
