// Time Complexity :O(N! * N)
// Space Complexity :O(N X N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    List<List<String>> result ;
    int m ;
    int [] [] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList();
        m=n;
        board = new  int [m][m];
        if( n == 0 ) return result;
        
        backtrack(0);
        return result;
    }
    private void backtrack(int r){
        //base case
        if(r == m ) {
            List<String> list = new ArrayList();
            
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j < m; j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        // progression
        for(int j = 0 ;j < m; j++){
            if(isSafe(r,j)){
                //placed queens
                board[r][j]=1;
                
                //PROGRESS
                backtrack(r+1);
                
                //remove queens
                board[r][j]=0;           
            }
        }
        
        
        
    }
    private boolean isSafe(int r , int c){
        int row = r-1;
        int col = c+1;
        
        //right diagonal
        while(row >= 0 && col < m){
           if(board [row--][col++] == 1) return false;
        }
        col = c-1;row = r-1;
        //left diagonal
         while(row >= 0 && col >=0 ){
           if(board [row--][col--] == 1) return false;
         }
         col = c;row = r-1;
         while(row >= 0) {
           if(board [row--][col] == 1) return false;
         }
      return true;  
    }
}
