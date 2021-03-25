// Time Complexity : O(N!) where n is the grid size 
// Space Complexity : O(n^2) since we're using addition matrix, Recursion Stack and temporary list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = '.';
            }
        }
        backtracking(board,n,0);
        return result;
    }
    
    private void backtracking(char[][] board,int n,int i){
        if(n == 0){
            result.add(new ArrayList<>(output(board)));
            return;
        }
        for(int j=0;j<board[0].length;j++){
            if(isValid(board,i,j)){
                board[i][j] = 'Q';
                backtracking(board,n-1,i+1);
                board[i][j] = '.';
            }
        }
    }
    private List<String> output(char[][] board){
        List<String> temp = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<board[0].length;j++){
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }
    private boolean isValid(char[][] board,int i,int j){
        int r = i, c=j;
        // check Upper columns
        while(r>=0){
            if(board[r--][c] == 'Q')
                return false;
        }
        
        r=i;
        c=j;
        // check left diagonal
        while(r>=0 && c >=0){
            if(board[r--][c--] == 'Q')
                return false;
        }
        
        r=i;
        c=j;
        // check right diagonal
        while(r>=0 && c < board[0].length){
            if(board[r--][c++] == 'Q')
                return false;
        }
        return true;
    }
}
