// Time Complexity : O(n × n!)
// Space Complexity : O(n^2) + O(n)

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean [][] board = new boolean[n][n];
        helper(board, 0, result);
        return result;
    }

    private void helper(boolean [][] board, int r, List<List<String>> result) {
        //base
        if(r == board.length) {
            List<String> li = new ArrayList<>();
            for(int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board.length; j++) {
                    if(board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        //logic
        for (int c = 0; c < board.length; c++) {
            if(isSafe(board, r, c)) {
                board[r][c] = true;
                helper(board, r+1, result);
                board[r][c] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c) {
        //column up
        for (int i = 0; i < r; i++) {
            if (board[i][c] == true) return false;
        }

        //diagonal up left
        int i = r; int j = c;
        while(i >= 0 && j >= 0) {
            if (board[i][j] == true) return false;
            i--; j--;
        }

        //diagonal up right
        i = r; j = c;
        while(i >= 0 && j < board.length) {
            if (board[i][j] == true) return false;
            i--; j++;
        }

        return true;
    }
}