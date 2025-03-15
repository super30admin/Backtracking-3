// for based recursion
// TC: O(N^N) or O(n!)
// SC: O(NxN + N)
class Solution {
    boolean[][] grid; //SC > NxN
    int n;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        grid = new boolean[n][n];
        result = new ArrayList<>();
        recurse(0);
        return result;
    }
    //SC > N
    public void recurse(int row){
        //base
        if(row == n){
            List<String> chessboard = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(grid[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                chessboard.add(sb.toString());
            }
            result.add(chessboard);
        }
        //logic
        for(int i = 0; i < n; i++){
            if(canPlace(row, i)){
                //action
                grid[row][i] = true;
                //recurse
                recurse(row + 1);
                //backtrack
                grid[row][i] = false;
            }
        }
    }
    public boolean canPlace(int row, int col){
        //check same column above rows
        for(int i = row - 1; i >= 0; i--){
            if(grid[i][col]) return false;
        }
        // check diagonal to left
        int r = row - 1;
        int c = col - 1;
        while(r >= 0 && c >= 0){
            if(grid[r][c]) return false;
            r--;
            c--;
        }
        // check diagonal to right
        r = row - 1;
        c = col + 1;
        while(r >= 0 && c < n){
            if(grid[r][c]) return false;
            r--;
            c++;
        }
        //check same row left/before rowcolumnss
        for(int i = col - 1; i >= 0; i--){
            if(grid[row][i]) return false;
        }
        return true;
    }
}
