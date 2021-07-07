/*
Author: Akhilesh Borgaonkar
Problem: Given an integer n, return all distinct solutions to the n-queens puzzle.
Approach: I have used backtracking approach here. First, I place the queen at (0,0) and then check if the placement is safe.
    The isSafe() method returns true if the placement adheres to row, column and diagonal condition of placing a Queen on chessboard
    else returns false. If the current placement is safe then, I call the backtrack function recursively to place next queen in
    next row.
Time Complexity: O(n^n) where n is number of rows or columns in the grid.
Space Complexity: O(n) where n is number of rows or columns in the grid.
LC verified.
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] ch : board)
            Arrays.fill(ch,'.');                            //setting chess board to blank

        placeQueen(board, 0, output);                       //placing first queen in first row
        return output;
    }
    
    private void placeQueen(char[][] board, int row, List<List<String>> output){
        //base condition
        if(row == board.length) {                           //if all n queens are placed in every row
            List<String> list = new ArrayList<>(board.length);
            for(char[] chars : board)
                list.add(new String(chars));                //because expected output is in the form of list of lists
            output.add(list);
            return;
        }
        
        //calling backtrack function for each row
        for(int j=0; j<board.length; j++){
            board[row][j]='Q';                              //making choice of placing queen
            if(isSafe(board, row, j))                       //checking if the placement satisifies row, column and diagonal conditions
                placeQueen(board, row+1, output);           //now placing the next queen in next row
            board[row][j]='.';                              //if condition of placement not satisfied then backtrack to default
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col){   //determines if the placement of current queen is valid
        //column condition
        for(int i=0; i<board[0].length; i++) {
            if (board[i][col] == 'Q' && i != row)           //checking for existence of second queen in the current column
                return false;
        }
        //row condition
        for(int j=0; j<board.length; j++){
            if(board[row][j]=='Q' && j!=col)                //checking for existence of second queen in the current row
                return false;
        }

        //diagonal condition
        for(int i=0; i<row; i++){
            for(int j=0; j<board[0].length; j++){
                if( board[i][j] == 'Q' && (row+j==col+i || row+col==i+j ))
                    return false;                           //checking for existence of second queen on the diagonals
            }
        }
        return true;
    }
}
