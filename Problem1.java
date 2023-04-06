// Time Complexity : n!
// Space Complexity : n^2
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*We place queens in different places and check if there is a queen in the row above it. 
If yes, we backtrack and change the queens position. 
To check if a queen can be places, we try the rows above it, at the same column and diagonally. 
 * 
 */


class Problem1 {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) 
    {
        result = new ArrayList();
        boolean grid[][] = new boolean[n][n];
        backtrack(grid,0);
        return result;
    }
    private void backtrack(boolean grid[][], int r){
        if(r == grid.length){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < grid.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < grid.length; j++){
                    if(grid[i][j])
                        sb.append('Q');
                    else 
                        sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        for(int j = 0; j < grid.length; j++){
            if(isSafe(grid, r, j)){
                grid[r][j] = true; 
                backtrack(grid, r+1);
                grid[r][j] = false;
            }
        }
    }
    private boolean isSafe(boolean grid[][], int r, int c){
        for(int i =0; i < r; i++){
            if(grid[i][c])
                return false;
        }
        int i = r; 
        int j = c; 
        while(i >= 0 && j < grid.length){
            if(grid[i][j])
                return false; 
            i--;
            j++;
        }
        i = r; 
        j = c; 
        while(i >= 0 && j >= 0){
            if(grid[i][j])
                return false;
            i--; 
            j--;
        }
        return true;
    }

}