/**
Problem: https://leetcode.com/problems/n-queens/
TC: O(n!)
in the first row, we have n choices.
In the second row, we'll have n-2 / n - 3 choices depending on where we place the first queen
In the third row, we'll have n - 4 / n - 6 choices
...			=> n(n-2)(n-4)... = n!
SC: O(n) -> for recursion stack
*/


class Solution {
    List<List<String>> solutions = null;
    char[][] board = null;
    int n;
    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        board = new char[n][n];
        this.n = n;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <n; ++j) {
                board[i][j] = '.';
            }
        }
        
        backtrack(0);
        return solutions;
    }
    
    private void backtrack(int row) {
        if (row == n) {
            solutions.add(construct());
            return;
        }
        
        for (int col = 0; col < n; ++col) {
            if (canPlaceQueen(row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean canPlaceQueen(int row, int col) {
        // check if column has a queen
        for (int r = 0; r < row; ++r) {
            if (board[r][col] == 'Q') return false;
        }
        
        // Check if upper left diagonal has a queen
        int r = row - 1, c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            --r; --c;
        }
        
        // Check if upper right diagonal has a queen
        r = row - 1; c = col + 1;
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') return false;
            --r; ++c;
        }
        
        return true;
    }
    
    private List<String> construct() {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}