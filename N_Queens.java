class Solution {
    List<List<String>> result;
    int [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        placeQueens(board, 0, n);
        return result;
    }
    
    private boolean placeQueens(int [][] board, int r, int n){
        //base case
            if( r == n){
                List<String> temp = new ArrayList<>();
                for(int i = 0; i < n ; i++){
                    String a = new String();
                    for(int j = 0; j < n; j++){
                        if(board[i][j] == 1)
                            a += 'Q';
                        else
                            a += '.';
                    }
                    temp.add(a);
                }
                result.add(temp);
                return false;
            }
        
        //logic
        //recursive
        for(int i = 0; i < n; i++){
            if(isSafe(board, r, i, n)){
                board[r][i] = 1;
                if(placeQueens(board, r+1, n)) return true;
            }
            //backtrack
            board[r][i] = 0;
        }
        return false;
    }
    
    private boolean isSafe(int [][] board, int i, int j, int n){
        //same column
        for(int r= 0; r<i ; r++){
            if(board[r][j] == 1){
                return false;
            }
        }
        
        //left diagonal
        int x = i-1;
        int y = j -1;
        
        while(x >= 0 && y >= 0){
            if(board[x][y] == 1) return false;
            x--; y--;
        }
        
        //right diagonal
        x = i-1;
        y = j+1;
        
        while( x >= 0 && y < n){
            if(board[x][y] == 1) return false;
            x--; y++;
        }
        return true;
    }
}

//TC: N fatorial ( n, n - 2, n-4..)
