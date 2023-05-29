## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)

// Time Complexity - 0(n!) since the maximum number of queens in the grid is N, the number of recursive calls is N!. 
// Space Complexity - 0(n ^ 2) because the grid is a 2D boolean array of size N x N, representing the placement of queens on the board

class Solution {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        grid = new boolean[n][n];
        backtrack(0);
        return result;       
    }
    private void backtrack(int row) {
        if (row == grid.length) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == true) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;
        }

        for (int i = 0; i < grid.length; i++) {
            if (isSafe(row, i)) {
                grid[row][i] = true;
                backtrack(row + 1);
                grid[row][i] = false;
            }
        }
    }
    private boolean isSafe(int row, int col) {
        // check upper column for queen
        for (int i = row; i >= 0; i--) {
            if (grid[i][col] == true) {
                return false;
            }
        }
        // check upper left diagonal
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }
        // check upper right diagonal
        i = row;
        j = col;
        while (i >= 0 && j < grid.length) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}

## Problem2
Word Search(https://leetcode.com/problems/word-search/)

// Time Complexity - O(m * n * 4^k) because code iterates through each cell of the board once in the nested loops and 
//                   For each cell, the backtrack function is called, which explores the neighboring cells recursively.
// Space Complexity - 0(k) where k is the length of the word.

class Solution {
    int m, n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row == m || col < 0 || col == n || board[row][col] == '#') {
            return false;
        }

        if (word.charAt(index) == board[row][col]) {
            char ch = board[row][col];
            board[row][col] = '#';

            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (backtrack(board, nr, nc, word, index + 1)) {
                    return true;
                }
            }
            board[row][col] = ch;
        }
        return false;
    }
}