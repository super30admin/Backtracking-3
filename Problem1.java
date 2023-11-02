//Time  Complexity : (n+1)!
//Space Complexity : O(n^2)

class Solution {
    List<List<String>> result;
    boolean [][] grid;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.grid = new boolean[n][n];
        
        backtrack(0, n);
        return result;
    }

    private void backtrack(int r, int n){
        if(r==n){
            List<String> l = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(grid[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                l.add(sb.toString());
            }
            result.add(l);
        }

        for(int c = 0; c < n; c++){
            if(isSafe(r, c, n)){
                grid[r][c]=true;
                backtrack(r+1, n);
                grid[r][c]=false;
            }
        }
    }
    private boolean isSafe(int r, int c, int n){
        for(int i=0; i < r; i++){
            if(grid[i][c]){
                return false;
            }
        }
        int i=r; int j=c;
        while(i>=0 && j>=0){
            if(grid[i][j]){
                return false;
            }
            i--;
            j--;
        }
        i=r; j=c;
        while(i>=0 && j<n){
            if(grid[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}
