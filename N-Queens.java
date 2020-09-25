// Time Complexity : O(n * n!) to check the possibilty of placing each queen and whether it is safe or not to place it 
// Space Complexity : O(n * n) board to place queens
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    private List<List<String>> output = new ArrayList();
    private int board[][];
    private int m;
    
    public List<List<String>> solveNQueens(int n) {
        
        if(n == 0)  return output;
        
        m = n;
        board = new int[n][n];
        
        backtrack(0);
        
        return output;
    }
    
    private void backtrack(int r){
        
        // base case
        if(r == m){
            //generate grid of the string
            List<String> list = new ArrayList();
            
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    }else{
                       sb.append("."); 
                    }
                }
                
                list.add(sb.toString());
            }
            output.add(list);
        }
        
        //backtrack
        for(int j = 0; j < m; j++){
            
            if(isSafe(r,j)){
                //place queen if safe
                board[r][j] = 1;
                
                //progress
                backtrack(r+1);
                
                //remove the queen from the board
                board[r][j] = 0;
            }
            
        }
        
    }
    
    private boolean isSafe(int r, int c){
        
        int row = r - 1;
        int col = c;
        
        //check upwards whether we can place queen
        while(row >= 0){
            if(board[row--][c] == 1)  return false;
        }
        
        row = r - 1; col = c - 1;
        //check upper left diagonal whether we can place the queen or not
        while(row >= 0 && col >=0){
            if(board[row--][col--] == 1)    return false;
        }
        
        row = r - 1; col = c + 1;
        //check upper right diagonal whether we can place the queen or not
        while(row >= 0 && col < m){
            if(board[row--][col++] == 1)    return false;
        }
        
        return true;
    }
}
