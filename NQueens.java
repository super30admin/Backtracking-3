import java.util.ArrayList;
import java.util.List;

public class NQueens {

    List<List<String>> result;
    boolean[][] grid;


    // TC: O(n!) n - number of queens
        // First row will have n options to place the queen
        // Second row - (n - 2)
        // Third row - (n - 4)
        // In total, n * (n - 2) * (n - 4) , and so on. in short n!
    // SC: O(n) for each queen we will be putting the recursion frame into the recursive stack
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        grid = new boolean[n][n];

        if(n == 0) return result;
        backtrack(0);

        return result;
    }

    private void backtrack(int row) {
        //base
        if(row == grid.length) {
            List<String> temp = new ArrayList<>();
            for(int i=0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j < grid.length; j++) {
                    if(grid[i][j]){
                        sb.append('Q');
                    }else
                        sb.append('.');
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }

        //logic
        for(int i=0; i < grid.length; i++) {
            if(isSafe(row, i)) {
                // action
                grid[row][i] = true;

                // recurse
                // try to explore the next row
                backtrack(row + 1);

                // backtrack
                // Backtracking the last activity we did & try to explore other possibilities
                grid[row][i] = false;
            }
        }
    }

    /*
    This method will check whether is it safe to place the queen at the current row & column
    We'll be searching in upper right and upper left directions to check if we already placed any queen over there
     */
    private boolean isSafe(int row, int column) {
        // first check whether in the current column, did we already place a queen
        for(int i=0; i < row; i++) {
            if(grid[i][column]) return false;
        }

        // check the upper right
        int i = row, j = column;
        while(i >=0 && j < grid.length) {
            if(grid[i][j]) return false;
            i--;
            j++;
        }

        // check the upper left
        i = row; j = column;
        while (i >=0 && j >= 0){
            if(grid[i][j]) return false;
            i--;
            j--;
        }

        return true;
    }
}
