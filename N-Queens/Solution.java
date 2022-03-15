// Time Complexity : O(N!) 
// Space Complexity : O(N ^ 2) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use backtracking to put queen on board
 * For each queen position we check if it is same to put queen here by going in vertical and upper left diagonal and upper right diagonal
 * Whenever we get a safe position we put a queen there and go for next queen
 * Once we have placed all queens, we take current combination and put it into result.
 * Once we have check all possible places for queens, we return
*/

class Solution {
    List<List<String>> res;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n == 0)return res;
        board = new boolean[n][n];
        backtrack(0);
        return res;
    }
    
    private void backtrack(int row){
        //base
        if(row == board.length){
            List<String> ans = new ArrayList<>();
            
            for(int r = 0; r < board.length;r++){
                StringBuilder sb = new StringBuilder();
                for(int c = 0; c < board.length;c++){
                    if(board[r][c] == true){
                        sb.append('Q');    
                    }else{
                        sb.append('.');
                    }
                    
                }
                
                ans.add(sb.toString());
            }
            
            res.add(ans);
            return;
        }
        
        
        //logic
        for(int c = 0; c < board.length;c++){
            if(safe(row, c)){
                board[row][c] = true;
                backtrack(row+1);
                board[row][c] = false;
            }
        }
    }
    
    private boolean safe(int r, int c){
        for(int row = 0; row < board.length;row++){
            if(board[row][c] == true){
                return false;
            }
        }
        
        int row = r-1;
        int col = c-1;
        
        while(row >= 0 && col >= 0){
            if(board[row][col] == true)return false;
            row--;
            col--;
        }
        
        row = r-1;
        col = c+1;
        
        while(row >= 0 && col < board.length){
            if(board[row][col] == true)return false;
            row--;
            col++;
        }
        
        return true;
    }
}