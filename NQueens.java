import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        backtrack(grid, 0, result);
        return result;
    }

    public void backtrack(boolean[][] grid, int r, List<List<String>> result){
        //base check
        if(r == grid.length){
            List<String> li = new ArrayList<>();
            for(int i=0; i<grid.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j< grid.length; j++){
                    if(grid[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        //logic
        for(int c = 0; c < grid.length; c++){
            if(isSafe(grid, r, c)){
                grid[r][c] = true;
                backtrack(grid, r+1, result);
                grid[r][c] = false;
            }
        }
    }

    public boolean isSafe(boolean[][] grid, int r, int c){
        //column up check
        for(int i=0; i<r; i++){
            if(grid[i][c]){
                return false;
            }
        }

        //column up left check
        int i=r;
        int j=c;

        while(i>=0 && j>=0){
            if(grid[i][j]){
                return false;
            }
            i--;
            j--;
        }

        //column up right check
        i=r;
        j=c;

        while(i>=0 && j<grid.length){
            if(grid[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
