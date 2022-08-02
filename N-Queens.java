//tc: n!
// sc: o(n2) given  grid is n*n

class Solution {
    List<List<String>> result;
    boolean[][] grid;
    int n;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        grid = new boolean[n][n];
        this.n = n;

        backtrack(0);

        return result;
    }

    private void backtrack(int row){
        // base case
        if(row == n){
            List<String> ans = new ArrayList<>();
            for(int i = 0; i< n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<n; j++){
                    if(grid[i][j] == true){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;
        }

        // logic
        for(int i = 0; i <n; i++){
            if(issafe(row, i)){
                // action
                grid[row][i] = true;
                // recurse
                backtrack(row + 1);
                // backtrack
                grid[row][i] = false;
            }
        }

    }

    private boolean issafe(int r, int c){
        // check the column first

        for(int i = r-1; i>=0; i--){
            if(grid[i][c] == true){
                return false;
            }
        }

        // check the left diagonal
        int i = r, j = c;
        while(i >= 0 && j >= 0){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j--;

        }

        // check the right diagonal
        i = r; j = c;

        while(i >= 0 && j< n){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j++;
        }

        return true;
    }


}
