/** The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
TC O(N!) and SC O(N*N)
class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 0)
            return result;
        board = new int[n][n];
        backtrack(n, 0);
        return result;
    }
    
    private void backtrack(int n, int row) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i< n; i ++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n ; j++) {
                    if (board[i][j] == 1) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp); 
            return;
        }
        
        for (int i = 0; i < n; i++) {
            boolean placed = placeable(row, i, n);
            if (placed) {
                board[row][i] = 1;
                backtrack(n, row+1);
                board[row][i] = 0;
            }
        }
    }
    
    private boolean placeable(int row, int col, int n) {
        for (int i = row; i >=0; i--) {
            if (board[i][col] == 1){
                return false;
            }
        }
        
        int i = row, j = col;
        while(i >= 0 && j >= 0){
            if (board[i][j] == 1) {
                return false;
            }
            i --;
            j--;
        }
        
            
        i = row; j = col;
        while(i >= 0 && j < n){
            if (board[i][j] == 1) {
                return false;   
            }
            i--;
            j++;
        }
        
        return true;
    }
}

