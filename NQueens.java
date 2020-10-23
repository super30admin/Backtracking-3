// TC : O(n!), n ways to place first queen, n-1 for the next and so on 
// SC : O(n), max recursion depth

//Did it run on LC: yes
//still need to review this problem

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> output = new ArrayList<List<String>>();
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                board[i][j] = '.';
        
        helper(board, 0, output);
        
        return output;
    }
    
    private void helper(char[][] board, int columnIndex, List<List<String>> output){
        //base case
        if(columnIndex==board.length){
            output.add(constructOutput(board));
            return;
        }
        
        for(int i=0; i<board.length; i++){
            if(isValid(board, i, columnIndex)){
                board[i][columnIndex] = 'Q';
                helper(board, columnIndex+1, output);
                board[i][columnIndex] = '.';
            }
        }
    }
    
    private List<String> constructOutput(char[][] board){
        List<String> result = new LinkedList<String>();
        
        for(int i=0; i<board.length; i++){
            String row = new String(board[i]);
            result.add(row);
        }
        
        return result;
    }
    
    private boolean isValid(char[][] board, int r, int c){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<c; j++){
                if(board[i][j]=='Q' && (i==r || i+j == r+c || i+c==r+j)){
                    return false;
                }
            }
        }
        
        return true;
    }
}