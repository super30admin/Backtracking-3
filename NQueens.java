// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes	 	
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach










class Solution {
     List<List<String>> result;
    int m ;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
      result = new ArrayList<>();
        
        
        
        if(n == 0)
            return result;
        board  = new int[n][n];
        m = n;
        backtrack(0);
        
        
      
        return result;
    }
    
    
    private void backtrack(int row){
        
        //base
       if(row < 0 || row >= m){
           List<String> temp = new ArrayList<>();
             for(int i = 0 ; i < m ; i++){
                 StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < m ;j++){
                if(board[i][j] == 1)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            temp.add(sb.toString());
           // temp = new ArrayList<>();
        }
           result.add(temp);
          return;
       }
         
        //logic
        
        for(int i = 0 ; i < m ; i++){
            if(isSafe(board,row,i) ){
               //action
               board[row][i] = 1;
               //recurse
               backtrack(row+1);  
               //backtrack
               board[row][i] = 0;               
           }
        }
        
    }
    
    private boolean isSafe(int[][] board ,int r, int c){
        
          for(int i = r-1; i >=0 ;i--){
              if(board[i][c] == 1)
                  return false;
          }
        int row = r-1;
        int col = c-1;
         while(row >=0 && col >=0){
             
             if(board[row][col] == 1){
                 return false;
             }
             row--;
             col--;
         }
        
        row = r-1;
        col = c+1;
        while(row >=0 && col < m){
            
            
            if(board[row][col] == 1)
                return false;
            row--;
            col++;
        }
        
        return true;
    }
}