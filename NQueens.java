/*
 * Time Complexity  : n!
 * Space Complexity : O(n*n)
 * 
 * 
 */
class Solution {
    
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        
        if(n == 0){
            return result;
        }
        
        int[][] board = new int[n][n];
        placeQueens(board, 0, n);
        return result;
    }
    
    private void placeQueens(int[][] board, int row, int n){
        //Base Case
        if(row == n){
            List<String> list = new ArrayList<>();
            
            
            for(int i=0; i<row; i++){
                StringBuilder builder = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(board[i][j] == 1){
                        builder.append("Q");
                    }else{
                        builder.append(".");
                    }
                }
                
                list.add(builder.toString());
            }
            
            
            result.add(list);
        }
        
        
        //Logic
        for(int col=0; col < n; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 1;
                
                placeQueens(board, row+1, n);
                
                board[row][col] = 0;
            }
        }
    }
    
    private boolean isSafe(int[][] board, int row, int col){
        
        //Check columns
        for(int r=row-1; r >= 0; r--){
            if(board[r][col] == 1){
                return false;
            }
        }
        
        //check upleft side;
        int x = row - 1;
        int y = col - 1;
        
        while(x >=0 && y >= 0){
            if(board[x][y] == 1){
                return false;
            }
            
            x--;
            y--;
        }
        
        //check upright side;
        x = row - 1;
        y = col + 1;
        
        while(x >=0 && y < board[0].length){
            if(board[x][y] == 1){
                return false;
            }
            
            x--;
            y++;
        }
        
        return true;
    }
}