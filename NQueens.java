import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(N!) - factorial
 * Space Complexity: O(N) for recursive stack
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Place queens row by row, ensuring that each queen is placed safely without conflicting with other queens.
 * 2. If all queens are successfully placed (i.e., when row == n), the current configuration is added to the result.
 * 3. Check horizontally, vertically, diagonally to see if queen can be placed.
 * 4. Backtrack to see what other positions are possible.
 */

public class NQueens {
    boolean[][] grid;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        grid = new boolean[n][n];
        backtrack(0, n);
        return result;        
    }
    private void backtrack(int row, int n) {
        //base
        if(row == n) {
            List<String> answer = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == true) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;            
        }

        //logic     
        for(int i = 0; i < n; i++) {
            if(isSafe(row, i, n)) {
                //action
                grid[row][i] = true;
                //recurse
                backtrack(row + 1, n);
                //backtrack
                grid[row][i] = false;                
            }
        }

    }
    private boolean isSafe(int row, int col, int n) {
        //check for any queens above the current cell
        for(int i = row; i >= 0; i--) {
            if(grid[i][col] == true) {
                return false;
            }
        }
        //check for any queens in the upper left diagonal
        int i = row;
        int j = col;
        while(i >= 0 && j >= 0) {
            if(grid[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while(i >= 0 && j < n) {
            if(grid[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    public static void main(String[] args) {
        // Your code here
        NQueens obj = new NQueens();
        List<List<String>> solveNQueens = obj.solveNQueens(4);
        System.out.println(solveNQueens);
    }
}