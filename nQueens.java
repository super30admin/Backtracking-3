//time O(n!)
//space O(n^2) for the board
//approach: Try placing a queen in first row in first column, then recursively call the same method on 2nd, 3rd row etc. until the queen cannot be placed. If the queen cannot be placed backtrack else add the result to the list.

class Solution {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.grid = new boolean[n][n];
        backtrack(grid, 0, n);
        return result;
    }
    
    private void backtrack(boolean[][] grid, int r, int n) {
        //base
        if (r == n) {
            List<String> list =new ArrayList<>();
            for(int i= 0; i< n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j= 0; j< n; j++) {
                    if(grid[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');                        
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return; 
        }
        
        //logic
        for (int j = 0; j < n; j++) {
            if(isSafe(grid, r, j)) {
                grid[r][j] = true;
                backtrack(grid, r + 1, n);
                grid[r][j] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int r, int c) {
        int orgR  = r;
        int orgC = c;
        
        //top
        for(int i = 0; i < r; i++) {
            if(board[i][c] == true) return false;
        }
        
        //diag left
        orgR = r;
        orgC = c;
        while(orgR >= 0 && orgC >= 0){
            if(board[orgR][orgC] == true) return false;
            orgR--; orgC--;
        }
        
        
        //diag right
        orgR = r;
        orgC = c;
        while(orgR >= 0 && orgC < board.length){
            if(board[orgR][orgC] == true ) return false;
            orgR--; orgC++;
        }
        
        return true;
    }
}
