class Solution {
    
    private List<List<String>> result;
    private boolean[][] board;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        
        solveNQueens(board, 0);
        
        return result;
    }
    
    private void solveNQueens(boolean[][] board, int row){
        if(row==board.length){
            List<String> out = new ArrayList<>();
            
            for(int i=0; i<board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j]==true){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                out.add(sb.toString());
            }
            
            result.add(out);
            return;
        }
        
        for(int col=0; col<board[0].length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                solveNQueens(board, row + 1);
                board[row][col] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int row, int col){
        return isSafeColumn(board, row, col) && isSafeUpperDiag(board, row, col) && isSafeRightUpperDiag(board, row, col);
    }
    
    private boolean isSafeColumn(boolean[][] board, int row, int col){
        for(int i=row; i>=0; i--){
            if(board[i][col]==false){
                return false;
            }
        }
        return true;
    }
    
    private boolean isSafeUpperDiag(boolean[][] board, int row, int col){
        int i=row - 1;
        int j=col - 1;
        while(i>=0 && j>=0){
            if(board[i][j]==true){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
    
    private boolean isSafeLeftUpperDiag(boolean[][] board, int row, int col){
         int i=row - 1;
        int j=col - 1;
        while(i>=0 && j>=0){
            if(board[i][j]==true){
                return false;
            }
            --i;
            --j;
        }
        return true;
    }
    
    private boolean isSafeRightUpperDiag(boolean[][] board, int row, int col){
         int i=row - 1;
        int j=col + 1;
        while(i>=0 && j>=0){
            if(board[i][j]==true){
                return false;
            }
            --i;
            ++j;
        }
        return true;
    }
}
