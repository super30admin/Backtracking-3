// N Queens Problem
class Solution {
    int[][] board;
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        board = new int[n][n];
        m = n;
        backtrack(0);
        return result;
        
    }
    
    public void backtrack(int r){
        // base
        if(r == m){
            List<String> li = new ArrayList<>();
            for(int i =0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j =0; j < m; j++){
                    if(board[i][j] == 0){
                        sb.append('.');
                    }
                    else{
                        sb.append('Q');
                    };
                }
                li.add(sb.toString());
            }
            result.add(li);
            return; 
            
        }
        
        
        // logic 
        for (int i = 0; i < m; i++){
            if(isvalid(r, i)){
                //action
                board[r][i] = 1;
                // recurse
                backtrack(r+1);
                //backtrack
                board[r][i] = 0;
            }
            
        }
        
        
    }
    
    public boolean isvalid(int r, int c){
        
        // column above
        for(int k =0; k < r; k++){
            if(board[k][c] == 1) return false;
        }
        
        
        // diagonal up left
        int tempr = r-1; 
        int tempc = c-1; 
        while(tempr >= 0 && tempc >= 0){
            if(board[tempr][tempc] == 1) return false; 
            tempr--;
            tempc--;
        }
        
        //diagonal up right
        tempr = r -1 ; 
        tempc = c +1;
        
        while(tempr >= 0 && tempc < m){
            if(board[tempr][tempc] == 1) return false; 
            tempr--;
            tempc++;
        }
        
        return true;
        
        
        
    }
    
}


// Backtrack solution 

// TC N !
// SC m * m board +  O(m) recursive stack space 



/* ----------------------------------------------------------------------/
Given NN as the number of queens (which is the same as the width and height of the board),

Time complexity: O(N!)O(N!)

Unlike the brute force approach, we will only place queens on squares that aren't under attack. For the first queen, we have NN options. For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider for the second queen is N - 2N−2. For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. Thus, the maximum number of squares we can consider for the third queen is N - 4N−4. This pattern continues, resulting in an approximate time complexity of N!N!.

While it costs O(N^2)O(N 
2
 ) to build each valid solution, the amount of valid solutions S(N)S(N) does not grow nearly as fast as N!N!, so O(N! + S(N) * N^2) = O(N!)O(N!+S(N)∗N 
2
 )=O(N!)

Space complexity: O(N^2)O(N 
2
 )

Extra memory used includes the 3 sets used to store board state, as well as the recursion call stack. All of this scales linearly with the number of queens. However, to keep the board state costs O(N^2)O(N 
2
 ), since the board is of size N * N. Space used for the output does not count towards space complexity.
 
 
*/














/* 
class Solution {
    int[][] board;
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        board = new int[n][n];
        m = n;
        backtrack(0);
        return result;
        
    }
    
    public void backtrack(int r){
        // base
        if(r == m){
            List<String> li = new ArrayList<>();
            for(int i =0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j =0; j < m; j++){
                    if(board[i][j] == 1 ){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    };
                }
                li.add(sb.toString());
            }
            result.add(li);
            return; 
            
        }
        
        
        // logic 
        for (int i = 0; i < m; i++){
            if(board[r][i] == 0){
               
                
                
                // take precaution
                helper(r , i);
                //action
                board[r][i] = 1;
                // recurse
                backtrack(r+1);
                //backtrack
                board[r][i] = 0;
            }
            
        }
        
        
    }
    
    public void helper(int row, int col){
        // column above and below
        
        for(int k =0; k < m; k++){
            board[k][col] = 2;
            
        }
        
        
        
        // // diagonal up left 
        int tempr = row-1; 
        int tempc = col-1; 
        while(tempr >= 0 && tempc >= 0){
            if(board[tempr][tempc] == 0) board[tempr][tempc] = 2; 
            tempr--;
            tempc--;
        }
        
        // diagonal down left
        tempr = row + 1;
        tempc = col -1;
        while(tempr < m && tempc >=0){
            if(board[tempr][tempc] == 0) board[tempr][tempc] = 2;
            tempr++;
            tempc--;
            
        }
        
        
        //diagonal up right
        tempr = row -1 ; 
        tempc = col +1;
        
        while(tempr >= 0 && tempc < m){
            if(board[tempr][tempc] == 0) board[tempr][tempc] = 2;
            tempr--;
            tempc++;
        }
        
        // diagonal down right
        
        tempr = row +1;
        tempc = col +1;
        while(tempr < m && tempc < m){
            if(board[tempr][tempc] == 0) board[tempr][tempc] = 2;
            tempr++;
            tempc++; 
        }
        
    
        
        
        
        
        
    }
    
    
}








*/
