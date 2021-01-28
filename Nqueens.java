/*
time complexity: O(n!), as we are checking every row recursively and at every step the search spce in next row
will reduce by 2. first row-> n checks, next row -> n-2 checks and so on

space complexity: O(nxn) for creating grid

Algorithm :
-create an n x n board
- backtrack function would start from row 0
- at every row, check if the current cell is safe to place queeen
    - if yes, add 1 to current cell
    - recurse for next row
    - undo the action taken in previous step

- finally when r = n, 
use string builder to built the string list by replace 1 with 'q' and 0 with '.'
append this to result list

- is Safe function:
check column up, Diagonal  up left and diagonal up right

*/
class Nqueens {
    
    List<List<String>> result;
    int m;
    
     int[][]board;
    public List<List<String>> solveNQueens(int n) {
      
        this.board = new int[n][n];
        this.m = n;
        this.result = new ArrayList<>();
        backtrack(0);
        return result;
        
    }
    
    private void backtrack(int r){
        
        //base condition
        if(r == m){
           
            List<String> currList = new ArrayList<>();
            for(int i = 0;i < m;i++){
                 StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m;j++){
                    if(board[i][j] == 1){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                currList.add(sb.toString());
            }
            
            result.add(currList);
            return;
        }
        
     
        //logic
        for(int j = 0; j < m;j++){
            if(isSafe(r,j)){
                //action
                board[r][j] = 1;
                //recurse
                backtrack(r+1);
                //backtrack
                board[r][j] = 0;
            }
        }
    }
    
    
    private boolean isSafe(int r, int c){
        //check column up
        for(int i = 0; i < r;i++){
            if(board[i][c] == 1)return false;
        }
        
        //check diagonal up left
        int i = r;
        int j = c;
       while(i >= 0 && j >= 0){
           if(board[i][j] == 1)return false;
           i--;
           j--;
       }
        //check diagonal up right
        
        i = r;
        j = c;
        while(i >= 0 && j < m){
            if(board[i][j] == 1)return false;
            i--;
            j++;
        }
        
        return true;
    }
}