TC: O(n**n)
SC: O(n)

class Solution {
    List<List<String>> result;
    int m;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.m = n;
        this.n = n;
        result = new ArrayList<>();
        if(n == 0) return result;
        
        boolean[][] grid = new boolean[n][n];
        backtrack(grid, 0);
        return result;
    }
    
    private void backtrack(boolean[][] grid, int row) {
        if(row == n) {
            ArrayList<String> al = new ArrayList<>();
            for(int i=0;i<n;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++) {
                    if(grid[i][j] == false) {
                        sb.append(".");
                    } else{
                        sb.append("Q");
                    }
                }
                al.add(sb.toString());
            }
            result.add(al);
            return;
        }
        
        for(int i=0;i<n;i++) {
            if(isSafe(grid, row, i)) {
                // System.out.println(row + " pre " + i);
                //action
                grid[row][i] = true;
                
                //backtrack
                backtrack(grid, row+1);
                // System.out.println(row + " in " + i);
                
                //recurse
                grid[row][i] = false;
                
            }
        }
    }
    
    private boolean isSafe(boolean[][] grid, int row, int col) {
        // System.out.println(row + " row col " + col);
        int nr = row;
        int nc = col;
        // checking queen in that particular column
        for(int i=0;i<nr;i++) {
            if(grid[i][nc] == true) {
                // System.out.println(grid[i][col]);
                return false;
            }
        }
        
        // checking queen left-top diagonal
        while(nr > 0 && nc > 0) {
            if(grid[nr-1][nc-1] == true) {
                return false;
            }
            nr--;
            nc--;
        }
        
        
        // checking queeen top-right diagonal
        while(row > 0 && col < n-1) {
            // System.out.println(row + " row col after first while " + col);
            if(grid[row-1][col+1] == true) {
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
}
