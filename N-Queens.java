//time - O(Exponential)
//space - O(n^2)
class Solution {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        grid = new boolean[n][n];
        helper(0);
        return result;
    }
    private void helper(int row){

        if(row==grid.length){
            List<String> newList = new ArrayList<>();
            for(int i=0; i<grid.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<grid.length; j++){
                    if(grid[i][j]==true){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                newList.add(sb.toString());
            }
            result.add(newList);
        }

        for(int i=0; i<grid.length; i++){
            if(isSafe(row, i)){
                grid[row][i] = true;
                helper(row+1);
                grid[row][i] = false;
            }
        }
    }
    private boolean isSafe(int r, int c){

        for(int i=0; i<r; i++){
            if(grid[i][c]==true) return false;
        }
        //Up left
        int i=r; int j=c;
        while(i>=0 && j>=0){
            if(grid[i][j]==true) return false;
            i--;
            j--;
        }
        //Up right
        i=r;
        j=c;
        while(i>=0 && j<grid.length){
            if(grid[i][j]==true) return false;
            i--;
            j++;
        }
        return true;
    }
}
