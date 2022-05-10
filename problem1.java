class nQueen {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        grid = new boolean[n][n];
        backTracking(0);
        return result;
    }
    
    private void backTracking(int row){
        if(row == grid.length){
            List<String> str = new ArrayList<>();
            for(int i = 0; i < grid.length; i++){
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < grid.length; j++){
                    if(grid[i][j] == true){
                        newStr.append('Q');
                    }
                    else{
                        newStr.append('.');
                    }
                }
                str.add(newStr.toString());
            }
            result.add(str);
            return;
        }
        
        for(int i = 0; i < grid.length; i++){
            if(isSafe(row, i)){
                grid[row][i] = true;
                backTracking(row + 1);
                grid[row][i] = false;
            }
        }
    }
    
    private boolean isSafe(int r, int c){
        
        for(int i = 0; i < r; i++){
            if(grid[i][c] == true) return false;
        }
        
        int i = r;
        int j = c;
        
        while(i >= 0 && j < grid.length){
            if(grid[i][j] == true) return false;
            i--;
            j++;
        }
        
        i = r;
        j = c;
        
        while(i >= 0 && j >=0){
            if(grid[i][j] == true) return false;
            i--;
            j--;
        }
        return true;
    }
}

//time complexity O(n!) because of everytime once I put queen in row then it reduce my option
//space complexity O(n) because everytime it will go in recursive stack for row means n is number of row