//TC: O(N!)
//SC: O(N)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                chess[i][j] = '.';
            
        
        List<List<String>> result = new ArrayList<List<String>>();

        solve(result, chess, 0);
        return result;
    }
    private void solve(List<List<String>> result, char[][] chess, int row) {
        if (row == chess.length) {
            result.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                solve(result, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }
    private boolean valid(char[][] chess, int row, int col) {
        // check all cols
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //check 45 degree
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //check 135
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) 
            path.add(new String(chess[i]));
        
        return path;
    }
}