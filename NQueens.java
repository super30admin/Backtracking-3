// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Create a board based on n values
condition based Recursion and backtracking. The condition here is that col needs to be valid
to check if col is valid, check horizontal, vertical, 45deg and 135deg
If all rows have been traversed then convert board to Sublist and add to result
*/
public class NQueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result= new ArrayList<>();
        if(n==0) return result;

        char[][] board= new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
                board[i][j]='.';
        }

        helper(board,n,0);

        return result;
    }

    private void helper(char[][] board, int n, int row){
        if(row==n){
            result.add(convertBoardToList(board));
            return;
        }

        for(int col=0;col<board[0].length;col++){
            if(isValidColumn(board,row,col)){
                board[row][col]='Q';
                helper(board,n,row+1);
                board[row][col]='.';
            }
        }
    }

    private boolean isValidColumn(char[][] board, int row, int col){

        //check col valid
        for(int r=row;r>=0;r--){
            if(board[r][col]=='Q') return false;
        }

        //check row valid
        for(int c=col;c>=0;c--){
            if(board[row][c]=='Q') return false;
        }

        //check 45 degrees
        for(int r=row-1, c=col+1; r>=0 && c<board[0].length; r--,c++){
            if(board[r][c]=='Q') return false;
        }

        //check 135 degrees
        for(int r=row-1, c=col-1; r>=0 && c>=0; r--,c--){
            if(board[r][c]=='Q') return false;
        }

        return true;
    }

    private List<String> convertBoardToList(char[][] board){

        List<String> values= new ArrayList<>();
        for(int r=0;r<board.length;r++){
            StringBuilder rowVal= new StringBuilder();
            for(int c=0;c<board[0].length;c++){
                rowVal.append(board[r][c]);
            }
            values.add(rowVal.toString());
        }

        return values;
    }
}
