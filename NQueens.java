class NQueens {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return result;
        boolean[][] grid = new boolean[n][n];
        backtracking(grid, 0, n);
        return result;
    }
    //TC is O(n*n)
    //SC is O(n*n)
    private void backtracking(boolean[][] grid, int r, int n){
        // base
        if(r==n){
            List<String> sub = new ArrayList<>();
            for(int i=0; i<n;i++){
                StringBuilder str = new StringBuilder();
                for(int j=0; j<n;j++){
                    if(grid[i][j]){
                        str.append('Q');
                    }else{
                        str.append('.');
                    }
                }
                sub.add(str.toString());
            }
            result.add(sub);
            return;
        }
        
        // logic
        for(int j=0; j<n ; j++){
            if(isSafe(grid, r,j, n)){
                // action
                grid[r][j] = true;
                
                //recurse
                backtracking(grid, r+1, n);
                
                // backtrack
                grid[r][j] = false;
                
            }
        }
    }
    
    private boolean isSafe(boolean[][] grid,int r, int c, int n){
        // column check
        for(int i=0; i< r;i++){
            if(grid[i][c]) return false;
        }
        
        // left diagonal
        int i=r, j=c;
        while(i>=0 && j>=0){
            if(grid[i][j]) return false;
            i--;
            j--;
        }
        
        // right diagonal
        i=r;
        j=c;
        while(i>=0 && j<n){
            if(grid[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}