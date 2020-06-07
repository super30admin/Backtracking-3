//Leetcode: 51. N-Queens
//Time Complexity: O(n!)
//Space Complexity: O(n)
class Solution {
    List<List<String>> res;
     int[][] board;
    public List<List<String>> solveNQueens(int n) {
        //place queen
        //check in all the three directions //top, dia1 and dia2
        //as it reaches the end of the chess board add it to resulting list
        // create 2d matrix from each of them
        
        res = new ArrayList<List<String>>();
        
        if(n==0){
            return res;
        }
        board= new int[n][n];
       
        helper(0);

        return res;
        
        
    }
    
    public void helper(int row){
       //base 
        if(row==board.length){
           List<String> lst = new ArrayList<>();
            
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==1){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                lst.add(sb.toString());
            }
            res.add(lst);
            return;
        }
        
        //logic
        for(int col=0; col<board.length;col++){
            if( isSafe(row,col)){
                board[row][col]=1;
                 helper(row+1);
                board[row][col]=0;
                
            }
        }
        
    }
    
    public boolean isSafe(int i,int j){
        //check col
        for(int k=i;k>=0; k--){
            if(board[k][j]==1) return false;
        }
        
        //diagonal : right
        int row= i-1;
        int col= j+1;
        while(row>=0 && col<board[0].length){
            if(board[row][col]==1) return false;
            row--;
            col++;
        }
        //diagonal: left
        row= i-1;
        col=j-1;
         while(row>=0 && col>=0){
            if(board[row][col]==1) return false;
             row--;
             col--;
        }
        return true;
    }
}