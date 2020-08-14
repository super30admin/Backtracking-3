//TC: O(n!)
//SC: O(n^2), n:number of rows
class Solution {
    int[][] board; int m; List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        m = n; board = new int[n][n];
        result = new ArrayList();
        backtrack(0);
        return result;
    }
    
    private void backtrack(int r){
        //base
        if(r==m) { //we have placed all the queens
            List<String> newList = new ArrayList();
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++){
                    if(board[i][j]==1){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                newList.add(sb.toString());
            }
            result.add(newList);
            return;
        }
        
        
        
        //logic
        for(int i = 0; i < m; i++){
            //try to put queen at a particular column
            if(isSafe(r, i)){
                //action
                board[r][i] = 1;
                //recurse
                backtrack(r+1);
                //backtrack
                board[r][i] = 0;
            }
        }
    }
    
    private boolean isSafe(int r, int c){
        //same column
        for(int i = 0; i <= r; i++){
            if(board[i][c] == 1){
                return false;
            }
        }
        //upright diagonal
        int i = r-1; int j = c+1;
        while(i>=0 && j < m){
            if(board[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }
        //upleft diagonal
        i = r-1; j = c-1;
        while(i>=0 && j >=0){
            if(board[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
