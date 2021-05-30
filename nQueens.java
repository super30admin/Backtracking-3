class Solution {
    List<List<String>> result;
    int [][] board;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if( n == 0) return result;
        board = new int[n][n];
        backtrack(0, n);
        return result;
    }
    
    private void backtrack(int r, int n){
        
        //base condition
        if(r == n){
            //create a list
            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i++){
                //string builder for each row 
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 1){
                        str.append('Q');
                    }else{
                        str.append('.');
                    }
                }
                li.add(str.toString());
            }
            result.add(li);
        }
        
        for(int c = 0; c < n; c++){
            
            if(isSafe(r, c, n)){
                //action
                board[r][c] = 1;
                
                //recurse
                backtrack(r + 1, n);
                
                //backtrack
                board[r][c] = 0;
             }
        }
    }
    
    private boolean isSafe(int row, int col, int n){
       // column up check 
        for(int i = 0; i < row; i++){
            if(board[i][col] == 1) return false ;  
        }
        
        //up left
        int r = row; int c = col;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 1) return false ;
            r--; c--;
        }
        
        //up right
        r = row;  c = col;
        while(r >= 0 && c < n){
            if(board[r][c] == 1) return false ;
            r--; c++;
        }
       return true; 
    }
}
