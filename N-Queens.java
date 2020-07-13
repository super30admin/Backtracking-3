// Time Complexity :O(n^n/2)
// Space Complexity :O(n^2) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<List<String>> result;
   int m;
   int [][] board;
   public List<List<String>> solveNQueens(int n) {
       result = new ArrayList<>();
       if(n == 0)return result;
       m = n;
       board = new int[m][m];
       backtrack(0);
       return result;
   }
   private void backtrack(int r){
       //base
       if(r == m){
           List<String> li = new ArrayList();
           for(int i = 0 ; i < m ; i++ ){
               StringBuilder sb = new StringBuilder();
               for(int j = 0; j < m; j ++){
                   if(board[i][j] == 0){
                       sb.append(".");
                   }
                   else{
                       sb.append("Q");
                   }
                   
               }
               li.add(sb.toString());
           }
           result.add(li);
       }
       //logic
       for(int i = 0; i < m; i++){
           //action
           if(isSafe(r , i)){
               board[r][i] = 1;
               
                //recurse
                backtrack(r + 1);
           
               //backtrack
               board[r][i] = 0;
           }
          
           
       }
   }
   private boolean isSafe(int r, int c){
       //column up
       for(int k = 0; k < r; k++){
           if(board[k][c] == 1)return false;
       }
       //diag left up
       int i = r - 1; int j = c - 1; 
       while(i >= 0 && j >= 0){
           if(board[i][j] == 1)return false;
           i--; j--;
       }
       //diag right up
       i = r - 1; j = c + 1; 
       while(i >= 0 && j < m){
           if(board[i][j] == 1)return false;
           i--; j++;
       }
       return true;
   }
}