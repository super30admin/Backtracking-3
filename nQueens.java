// Time Complexity : O(n!) 
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class nQueens {
    
    List<List<String>> answer = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueen(board, 0, n);
        return answer;
    }
    
    private void placeQueen(int[][] board, int row, int n) {
        // base case
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder("");
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) sb.append("Q");
                    else sb.append(".");
                }
                list.add(sb.toString());
            }
            answer.add(list);
        }
        // logic
        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1;
                placeQueen(board, row + 1, n);
                board[row][i] = 0;
            }
        }
    }
    
    private boolean isSafe(int[][] board, int row, int col) {
        // check same col
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        // check left diagonal
        int x = row - 1;
        int y = col - 1;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) return false;
            x--;
            y--;
        }
        // check right diagonal
        x = row - 1;
        y = col + 1;
        while (x >= 0 && y < board[0].length) {
            if (board[x][y] == 1) return false;
            x--;
            y++;
        }
        return true;
    }
}