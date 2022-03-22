class Solution {
    List<List<String>> result;
    boolean[][] board;
    private int size;

    public List<List<String>> solveNQueens(int n) {
        size = n;
        result= new ArrayList<>();
        board = new boolean[size][size];
        backtrack(0);
        return result;
    }
    
    private void backtrack(int i){
        // base
        if(i == size){
            List<String> sol= new ArrayList<>();
            for(int k=0; k< size; k++){
                StringBuilder sb= new StringBuilder();
                for (int j=0; j< size; j++){
                    if(board[k][j]) sb.append('Q');
                    else sb.append('.');
                }
                  sol.add(sb.toString());
            }
          result.add(sol);
        }
        
        //logic
        for(int j=0; j< size; j++){
            if(isSafe(i,j)){
                board[i][j]= true;
                //recurse
                backtrack(i+1);
                //backtrack
                board[i][j]=false;
            }
        }
    }
    
    private boolean isSafe(int r, int c){
        //check column up
        for(int i=0 ; i<= r; i++){
            if(board[i][c]) return false;
        }
        int i=r; int j=c;
        while(i>=0 && j>=0 ){
            if(board[i][j]) return false;
            i--; j--;
        }
        //check diagonal up right
        i=r; j=c;
        while(i >=0 && j< size){
            if(board[i][j]) return false;
            i--; j++;    
        }
        return true;
    }
}
//time complexity- O(N!)
//space - O(N^2)