// Time Complexity : We have N choices, then N-2, then N-4 so this will be approximately equivalent to factorial multiplication
//so, total time complexity will be in the order of N!


// Space Complexity : O(N^2) as we creating matrix of size N * N

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    List<List<String>> result;
    int size;
    boolean[][] mat;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0)  return result;
        
        size = n;
        mat = new boolean[n][n];
        helper(0); //Starting from row 0
        
        return result;
    }
    public void helper(int r){
        //Base Case
        if(r == size){
            List<String> list = new ArrayList<>();
            
            for(int i = 0; i< size; i++){ //For each row
               StringBuilder temp = new StringBuilder(); 
               for(int j = 0; j< size; j++){
                        if(mat[i][j] == true){
                            temp.append('Q');
                        }else{
                            temp.append('.');
                        }
                }
                //AFTER EACH ROW
                list.add(temp.toString());
            }
            
            result.add(list);
            return;
        }
        
        for(int col = 0; col< size; col++){
            if(isValid(r, col)){ // If it is false, we will skip to next column
                //Means we can out queen safely at indices[r,col] in board
                mat[r][col] = true;
                
                //Recursion
                helper(r + 1);
                //While backtracting reset the CELL to false
                mat[r][col] = false;
            }
        }
    }
    public boolean isValid(int r,int c){
        for(int i = 0; i< r; i++){
            if(mat[i][c] == true)   return false;
        }
        
        int x = r, y = c;
        while(x >= 0 && y < size){
            if(mat[x][y] == true)   return false;
            
            x--; y++;
        }
        
        
        x = r; y = c;
        while(x >= 0 && y >= 0){
            if(mat[x][y] == true)   return false;
            
            x--; y--;
        }
        
        
        return true;
    }
}