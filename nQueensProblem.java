class Solution {
    List<List<String>> result;
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        m = n;
        
        if(n == 0 ) return result;
        
        backtrack(0);
        return result;
    }
    
    private void backtrack(int row){
        List<String> li = new ArrayList<>();
        
        //base
        if(row == m ){ //placed all queens
        for(int i = 0 ; i < m ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j <m ; j++){
                if(board[i][j] == 0){
                    sb.append('.');
                }
                else{
                    sb.append('Q');
                }
            }
        li.add(sb.toString());    
        }
            result.add(li);
            return;
        }
        
        //logic
        for(int i = 0 ; i < m ; i ++){
           if(isSafe(row,i)){
            //action
            board[row][i] = 1;
            //recurse
            backtrack(row+1);
            //backtrack
            board[row][i] = 0;
        }
    }
    }
    
    private boolean isSafe(int r, int c){
        //column above
       for(int k=0;k < r; k++){
            if(board[k][c] == 1) return false;
        }
    
        //diagonal above up left
         int i = r-1; int j = c-1;
        while(i>=0 && j>=0){
            if(board[i][j] == 1) return false;
                i--;j--;
        }
        //diagonal above up right
        int iNew = r-1; int jNew = c+1;
        while(iNew >= 0 && jNew < m){
            if(board[iNew][jNew] == 1) return false;
                iNew-- ; jNew++;
        }
    return true;
}
}

//Time : Nchoices in 1st row,N-2 choices in 2nd row ..... hence O(n!)
//Space: O(nxn) board space + O(n) recursive space + O(n) string builder aymtotically O(nxn)