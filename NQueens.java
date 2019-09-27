/*
Author: Akhilesh Borgaonkar
Problem: Given an integer n, return all distinct solutions to the n-queens puzzle.
Approach: I have used backtracking approach here. First, I place the queen at (0,0) and then check if the placement is safe.
    The isSafe() method returns true if the placement adheres to row, column and diagonal condition of placing a Queen on chessboard
    else returns false. If the current placement is safe then, I call the backtrack function recursively to place next queen in
    next row.
Time Complexity: O(n^n) where n is number of rows or columns in the grid. (I am not confident about this.)
Space Complexity: O(n) where n is number of rows or columns in the grid.
Known Issue: Duplicates in resultant output list of lists. I will resolve it using visited matrix.
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] ch : board)
            Arrays.fill(ch,'.');

        placeQueen(board, 0, output);
        return output;
    }
    
    private void placeQueen(char[][] board, int row, List<List<String>> output){
        //base condition
        if(row == board.length) {
            List<String> list = new ArrayList<>(board.length);
            for(char[] chars : board)
                list.add(new String(chars));
            output.add(list);
            return;
        }
        
        //calling backtrack function for each row
        for(int j=0; j<board.length; j++){
            board[row][j]='Q';
            if(isSafe(board, row, j))
                placeQueen(board, row+1, output);
            board[row][j]='.';
        }
    }
    
    private int[][] directions = {{-1,1},{1,1},{-1,-1},{1,-1}};

    private boolean isSafe(char[][] board, int row, int col){
        //column condition
        for(int i=0; i<board[0].length; i++) {
            if (board[i][col] == 'Q' && i != row)
                return false;
        }
        //row condition
        for(int j=0; j<board.length; j++){
            if(board[row][j]=='Q' && j!=col)
                return false;
        }

        //diagonal condition
        for(int[] dir : directions ){
            int x = row + dir[0];
            int y = col + dir[1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]=='Q')
                return false;
        }
        return true;
    }
}
