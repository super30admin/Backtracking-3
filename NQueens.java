import java.util.ArrayList;
import java.util.List;
//Leetcode - 51
//Time Complexity - O(n!)
//Space Complexity - o(m*n) - grid
public class NQueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        boolean grid[][] = new boolean[n][n];
        backtrack(grid, 0, n);
        return result;
    }
    private void backtrack(boolean grid[][], int i, int n){
        //base
        if(i == n) {
            List<String> li = new ArrayList<>();
            for(int row = 0; row<n; row++) {
                StringBuilder sb = new StringBuilder();
                for(int col = 0; col < n; col++) {
                    if(grid[row][col]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int j = 0; j < grid.length; j++) {
            if(isSafe(grid, i, j)){
                //action
                grid[i][j] = true;
                //recurse
                backtrack(grid, i+1, n);
                //backtrack
                grid[i][j] = false;
            }

        }
    }
    private boolean isSafe(boolean grid[][], int r, int c) {
        //col up
        for(int i=0; i<r; i++) {
            if(grid[i][c]) return false;
        }
        //diag up right
        int i=r, j=c;
        while(i>=0 && j<grid.length){
            if(grid[i][j]) return false;
            i--;j++;
        }
        //diag upleft
        i=r; j=c;
        while(i>=0 && j>=0) {
            if(grid[i][j]) return false;
            i--;j--;
        }
        return true;
    }
}
