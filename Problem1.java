class Solution {
    //TC: O(N!)
    List<List<String>> result;
    boolean [][] grid;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.grid = new boolean[n][n];
        backtrack(0,n);
        return result;
    }

    private void backtrack(int r, int n){
        //base
        if(r == n){
            List<String> re = new ArrayList<>();
            for(int i = 0 ;i < n ;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(grid[i][j]){
                        sb.append('Q');
                    }else sb.append('.');
                }
                re.add(sb.toString());
            }
            result.add(re); 
            return;
        }

        //logic
        for(int c = 0; c < n; c++){
            if(isSafe(r,c,n)){
                //action
                grid[r][c] = true;
                //recurse
                backtrack(r+1,n);

                //backtrack
                grid[r][c] = false;
            }
        }
    }

    private boolean isSafe(int r, int c, int n){
     //coumn up
        for(int i = 0; i< r; i++){
            if(grid[i][c]) return false;
        }

        //diag up right
        int  i = r, j = c;
        while(i >=0 && j < n){
            if(grid[i][j]) return false;
            i--;
            j++;
        }

        //diag up left
          i = r; j = c;
        while(i >=0 && j >= 0){
            if(grid[i][j]) return false;
            i--;
            j--;
        }

        return true;
    }
}