// Time complexity - O(mxn)
// Space complexity - O(mxn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
     List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        
        result = new ArrayList<>();
        
        int[][] matrix1 = new int[n][n];
        
        backtrackQueen(0, n, matrix1);
        return result;
    }
    
    private void backtrackQueen(int r, int n, int[][] matrix1){
      //  System.out.println(r);
        if(r == n ){
            
         //  System.out.println("Hitting???");
            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                
                 String path = "";
                
                for(int j = 0; j < n; j ++){
                    
                    if(matrix1[i][j] == 1){
                        
                        path = path + "Q";
                    }
                    
                    else {
                        
                         path = path + ".";
                    }
                }
                //result.add(new ArrayList<>(path));
                li.add(path);
                
            }
            result.add((li));
            return;
        }
        
            
            for(int c = 0; c < n; c ++){
              //  System.out.println("Hitting here hrere");
            if(isSafe(r, c, n, matrix1)){
           // System.out.println("Hitting here hrere");
            //action
            matrix1[r][c] = 1;
            //recurse
            backtrackQueen(r + 1,  n, matrix1);
                
            //backtrack
            matrix1[r][c] = 0;
             }
                
                
            }
        
       
    }
    
    private boolean isSafe(int r, int c, int n, int[][] matrix1){
        
        //checking for sme column
        for(int i = 0; i < r; i ++){
            
            if(matrix1[i][c] == 1){
                
                return false;
            }
        }
        
        //checking for right diagonal
        int i = r;
        int j = c;
        while(i >= 0 && j < n){
            
            if(matrix1[i][j] == 1){
                
                return false;
            }
            
            i--;
            j++;
        }
        
        
        //checking for left diagonal
         i = r;
         j = c;
        while(i >= 0 && j >= 0){
            
            if(matrix1[i][j] == 1){
                
                return false;
            }
            
            i--;
            j--;
        }
        
        return true;
    }
}