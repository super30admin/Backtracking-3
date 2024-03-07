class Solution {
    private List<List<String>> result = new LinkedList<>();

    private boolean checkSafe(int i, int j, boolean[][] board){
        // check left row
        for(int nc = 0; nc < j; nc++){
            if(board[i][nc]) return false;
        }
        // check above
        for(int nr = 0; nr < i; nr++){
            if(board[nr][j]) return false;
        }
        // check NW
        int ci = i-1;
        int cj = j-1;
        while(ci > -1 && cj > -1){
            if(board[ci][cj]) return false;
            ci--;
            cj--;
        }
        // check NE
        ci = i-1;
        cj = j+1;
        while(ci > -1 && cj < board.length){
            if(board[ci][cj]) return false;
            ci--;
            cj++;
        }
        return true;
    }

    private void helper(boolean[][] board, int i){
        if(i >= board.length) return;

        int n = board.length;
        
        // You get a board with rows above i populated or non-existant
        for(int j = 0; j < n; j++){
            // At i,j
            boolean isSafe = checkSafe(i, j, board);
            if(isSafe){
                board[i][j] = true;
                // last row
                if(i == n-1){
                    // add to result
                    List<String> res = new LinkedList<>();
                    for(int k = 0; k < n; k++){
                        StringBuilder s = new StringBuilder();
                        for(int l = 0; l < n; l++){
                            if(board[k][l]){
                                s.append("Q");
                            } else s.append(".");
                        }
                        res.add(s.toString());
                    }
                    result.add(res);
                } else helper(board, i+1);
                board[i][j] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        helper(board, 0);
        return result;
    }
}
