// 51 N Queens
// sovled on leetcode
// Time complexity: O(n!)
// space complexity: O(n*2)

class Solution {
    
    List<List<String>> result;
    boolean [][] board;
    int N;
    public List<List<String>> solveNQueens(int n) {
        
        result = new ArrayList();
        N=n;
        board = new boolean[n][n];
        placingQueen(0);
        return result;
    }
    
    private void placingQueen(int row){
        
        // base
        if(row==N){
            
            List<String> temp = new ArrayList();
          
            for(int i=0;i<N;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<N;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                 temp.add(sb.toString());
            }
           
            result.add(temp);
            return;
        }
        // logic
        
        for(int j=0;j<N;j++){
            if(isSafe(row,j)){
                
                // action
                board[row][j]=true;
                // recurse
                placingQueen(row+1);
                // backtrack
                board[row][j]=false;
            }
        }
    }
    
    private boolean isSafe(int i,int j){
        
        // column check
        for(int x=0;x<i;x++){
            if(board[x][j]) return false;
        }
        
        // left diagonal 
        int x=i,y=j;
        while(x>=0 && y>=0){
            if(board[x][y]) return false;
            x--;
            y--;
        }
        
          // Right diagonal 
         x=i;y=j;
        while(x>=0 && y<board[0].length){
            if(board[x][y]) return false;
            x--;
            y++;
        }
        return true;
        
    }
}