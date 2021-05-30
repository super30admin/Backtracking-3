// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n!) - First placement of queen has n choices, the second one n-2 and so on 
//Space Complexity: O(n power 2) since we are using a m x n 2d array  
 class Solution {
    List<List<String>> result;
    int[][] board;
    
    public List<List<String>> solveNQueens(int n) 
    {
        result = new ArrayList<>();
        board = new int[n][n];
        backtrack(0, n);
        return result;      
    }
    
    private void backtrack(int r, int n)
    {
        //base case
        if(r == n){
            List<String> str = new ArrayList<>();
            for(int i = 0; i < n; i++){                
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                str.add(sb.toString());
            }            
            result.add(str);
            return;
        }
        
        //logic
        for(int c = 0; c < n; c++){
           if(isSafe(r, c, n))
           {
               //action
               board[r][c] = 1;
               
               //recurse
               backtrack(r + 1, n);
               
               //backtrack
               board[r][c] = 0;
                   
           } 
        }
    }
    
    private boolean isSafe(int r, int c, int n){
        
        //check the upward column
        for(int i = 0; i < r; i++){
            if(board[i][c] == 1) return false;
        }
                
        int i = r; int j = c;
        while(i >= 0 && j < n){
            if(board[i][j] == 1) return false;
            i--; j++;
        }
        
        i = r; j = c;
        while(i >= 0 && j >=0){
            if(board[i][j] == 1) return false;
            i--; j--;
        }
        
        return true;
    }    
}