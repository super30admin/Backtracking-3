class Solution {
    
    //making result and grid class var cuz it's affected in every recursive call
    List<List<String>> result;
    boolean[][] grid;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) {
            return result;
        }
        
        grid = new boolean[n][n];
        backtracking(0);
        
        return result;
    }
    // we take row as arguement, while we iterate through columns in for loop
    private void backtracking(int row) {
        //base
        if(row == grid.length) {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < grid.length; j++) {
                    if(grid[i][j] == true) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        //logic
        for(int i = 0; i < grid[0].length; i++) {
            if(isSafe(row, i)) {
                //action
                grid[row][i] = true;
                //recurse
                backtracking(row + 1);
                //backtrack
                grid[row][i] = false;
            }
        }
    }
    private boolean isSafe(int r, int c) {
        //check column
        for(int i = 0; i < r; i++) {
           if(grid[i][c] == true) return false;  
        }
           
         //check upper right diagonal
        int i = r, j = c;
        while(i >= 0 && j < grid.length) {
            if(grid[i][j] == true) return false;
            j++;
            i--;
        }
        
        //check upper left diagonal
        i = r; j = c;
        while(i >= 0 && j >= 0) {
            if(grid[i][j] == true) return false;
            i--;
            j--;
        }
        return true;
    }
}
            
        
        
    