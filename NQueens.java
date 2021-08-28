//https://leetcode.com/problems/n-queens/
/*
Time: O(N!) - Every time you place a Q, you end up blocking a space for it
Space: O(N^2)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        List<List<String>> result = new ArrayList<>();
        backtrack(n, board, 0, result);

        return result;

    }

    private void backtrack(int n, char[][] board, int row, List<List<String>> result) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(board, row, col)) {
                board[row][col] = 'Q'; // place
                backtrack(n, board, row + 1, result);
                board[row][col] = '.'; // unplace
            }
        }
    }

    private boolean canPlaceQueen(char[][] board, int row, int col) {
        // check upper rows
        for (int i = row - 1; i >= 0; i--) // from bottom see if you have already placed in the top
            if (board[i][col] == 'Q') // is there is already a Q in the same col
                return false;

        // diagonal check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) // bottom right to top left
            if (board[i][j] == 'Q')
                return false;

        // anti-diagonal check
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) // bottom left to top right
            if (board[i][j] == 'Q')
                return false;

        return true; // can place the Queen
    }

    private List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            result.add(new String(board[i])); // add each row of board to the list as a string

        return result;
    }

}
