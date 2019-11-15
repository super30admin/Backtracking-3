TC:O(n)
SC:O(n)

Runtime: 3 ms, faster than 75.21% of Java online submissions for N-Queens.
Memory Usage: 38.4 MB, less than 48.65% of Java online submissions for N-Queens.

Approach: We will fill row by row checking each column.


class Solution {
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        
        int[][] board = new int[n][n];
        placeQueens(board,0,n);
        return result;
        
    }
    private boolean placeQueens(int[][] board, int row, int n){
        
        // base case
        if(row==n){  // vald solution
            List<String> temp = new ArrayList<>();
            for(int i=0 ;i<n; i++){
                StringBuilder s = new StringBuilder();
                for(int j=0;j<board.length; j++){
                    if(board[i][j]==1){
                        s.append("Q"); }
                    else
                        s.append(".");
                }
                temp.add(s.toString()); 
            }
             result.add(temp);
        return false; 
           
        }
        // logic 
        for(int i=0; i< n; i++){
            // place a queen at a particular column in a row;
           if( isSafe(board,row,i)) {
               board[row][i] = 1;
               if(placeQueens(board,row+1,n)) return true;
           }
             board[row][i]=0;
        }
       
        return false;
        
    }
    private boolean isSafe(int[][] board,int row, int col){
        for(int i=0;i<row; i++){
            if(board[i][col]== 1) return false;
        }
        int r=row-1;
        int c=col-1;
        
        while(r>=0 && c>=0){
            if(board[r][c]==1) return false;
            r--; c--;
        }
        r=row-1;
        c=col+1;
        while(r>=0 && c<board.length){
            if(board[r][c]==1) return false;
            r--; c++;
        }
        return true;
    }
}
