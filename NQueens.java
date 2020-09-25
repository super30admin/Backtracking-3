// Time Complexity : O(n^n) m is the lenght of coins
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Bactracking
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
                
            }
        }
        backtracking(board, n, 0);
        return res;
    }
    
    private void backtracking(char[][] board, int queenLeft, int i){
        //base case
        if(queenLeft<=0){
            res.add(makeOutput(board));
            return;
        }
        
        //recursion cases
        for(int j=0; j<board.length; j++ ){
            if(isValid(board, i, j)){
                board[i][j] = 'Q';
                backtracking(board, queenLeft-1, i+1);
                board[i][j] = '.';
            }
        } 
    }
    
    private List<String> makeOutput(char[][] board){
        List<String> out = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<board.length; j++){
                sb.append(board[i][j]);
            }
            out.add(sb.toString());
        }
        return out;
    }
    
    private boolean isValid(char[][] board, int i, int j){
        int r = i;
        int c = j;
        
        //upper
        while(r>=0){
            if(board[r][c] == 'Q')
                return false;
            r--;
        }
        
        r = i;
        c = j;
        //left diagonal
        while(r>=0 && c>=0){
            if(board[r][c]=='Q')
                return false;
            r--;
            c--;
        }
        
        //right digonal
        r = i;
        c = j;
        while(r>=0 && c<board.length){
            if(board[r][c]=='Q')
                return false;
            r--;
            c++;
        }
        
        return true;   
    }             
}