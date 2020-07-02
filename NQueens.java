/*

        Time complexity : O(2^N)

        Space complexity: (N*N) 

        worked on leetcode : YES
*/

public class NQueens {
    int m;
    List<List<String>> result;
    int [][] board;
    public List<List<String>> solveNQueens(int n) {
        if ( n == 0) return new ArrayList();
        result = new ArrayList();
        m = n;
        board = new int[m][m];
        backtrack(0);
        
        return   result;
        
        
    }
    
    private void backtrack(int row){
        // base
        
        if( row == m){
            List<String> li = new ArrayList();
            for(int i =0;i< m;i++){
                StringBuilder sb  =  new StringBuilder();
                for(int j =0; j< m; j++){
                    // if board is zero put dot
                    
                    if( board[i][j] == 0){
                        sb.append(".");
                    }
                    // if board is one put Q
                    else{
                        sb.append("Q");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            
        }
        
    
        // logic
        // check for every column for perticular row
        for(int col =0; col < m; col++){
            
    
            if(isSafe(row, col)){
                // action put queen in this cell
                board[row][col] = 1;
            
                // recursive
                // move to the next row
                backtrack(row+1);

                // backtrack   
                board[row][col] = 0;
            }
        }
    }
    
    
    private boolean isSafe(int r, int c){
        // above column
        for(int k =0; k< r;k++){
            // above column already have queen so return false this is not safe
            if(board[k][c] == 1) return false;
        }
        
        // left diagonal
        int i = r-1 ;
        
        int j = c-1;
        
        while( i >= 0 && j >= 0){
            if(board[i][j] == 1) return false; 
            i--;
            j--;
        }
        
        i = r-1;
        j= c+1;
        // right diagonal
        
        while(i >= 0  && j < m){
            
            if( board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }
}