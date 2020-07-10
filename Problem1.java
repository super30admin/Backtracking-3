//Problem1 
//N Queens(https://leetcode.com/problems/n-queens/)

// Time - O(n!) Space - O(n)
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        int[][] board = new int[n][n];
        placeQueens(board, 0, n);
        return res;
    }
    
    private void placeQueens(int[][] board, int r, int n){
        // Base
        if(r == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
                
            }
            res.add(temp);
            return;
        }
        
        // logic
        //select a column in a particular row
        for(int j = 0; j < n; j++){
            if(isValid(board, r, j, n)){
                board[r][j] = 1; //action
                placeQueens(board, r + 1, n); // recurse
                board[r][j] = 0; // bactrack
            }
        }
    }
    
    private boolean isValid(int[][] board, int r, int c, int n){
        //valid column check - check rows above the current row 
        for(int i = 0; i < r; i++){
            if(board[i][c] == 1) return false;
        }
        
        // Diagonal check - top left
        int i = r - 1, j = c - 1;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }
        
        // Diagonal check - top right
        i = r - 1; j = c + 1;
        while(i >= 0 && j < n){
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        
        return true;
        
    }
}