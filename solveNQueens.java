// Time Complexity : O(n!)
// Space Complexity : O(n*n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    private List<List<String>> result = new ArrayList();
    
    public List<List<String>> solveNQueens(int n) {
        
        if(n==0) return result;
        
        char[][] board = new char[n][n];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j]='.'; 
            }            
        }
        
        backtrack(board, 0, n);
        
        return result;
    }
    
    
    public void backtrack(char[][] board, int i, int n) {
        
        if(n==0) {
            result.add(getOutput(board));
            return;
        } else {
            
            for(int j=0;j<board[0].length;j++) {
                
                if(isValid(board, i, j)) {
                    
                    board[i][j] = 'Q';
                    backtrack(board, i+1, n-1);
                    board[i][j] = '.';
                    
                }
                
            }
        }
        
    }
    
    
    public boolean isValid(char[][] board, int i, int j) {
        
        int r = i;
        int c = j;
        
        // upper columns
        while(r>=0) {
            if(board[r][c] == 'Q') {
                return false;
            }
            r--;
        }
        
        // left diagonal
        r = i;
        c = j;
        while(r>=0 && c>=0) {
            if(board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        
        // right diagonal
        r = i;
        c = j;
        while(r>=0&&c<board.length) {
            if(board[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    
    public List<String> getOutput(char[][] board) {
        
        List<String> rows = new ArrayList();
        String s = "";
        
        for(int i=0;i<board.length;i++) {
            s="";
            for(int j=0;j<board[0].length;j++) {
                s += board[i][j];
            }           
            rows.add(s);
        }
        return rows;
    }
    
}
