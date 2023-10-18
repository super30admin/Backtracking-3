class Solution {
    List<List<String>> result;
    boolean[][] grid;

    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        grid = new boolean[n][n];
        backtrack(0);
        return result;
    }

    private void backtrack(int row){
        if(row == grid.length){
            List<String> answer = new ArrayList<>();
            for(int i =0; i<grid.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j< grid.length; j++){
                    if(grid[i][j] == true){
                        sb.append('Q');
                    }
                    else
                    {
                        sb.append('.');
                    }
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;
        }
        for(int i =0; i < grid.length; i++){
            if(isSafe(row, i)){
                grid[row][i] = true;
                backtrack(row + 1);
                grid[row][i] = false;
            }
        }
    }



    private boolean isSafe(int row, int col){
        for(int i = row; i >= 0; i--){
            if(grid[i][col] == true){
                return false;
            }
        }

        int i = row;
        int j = col;
        while(i >= 0 && j >=0){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while(i >= 0 && j<grid.length){
            if(grid[i][j]==true){
                return false;
            }
            i--;
            j++;
        }
        return true;
}
}
