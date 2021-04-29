// Time Complexity : O(n!) 
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class NQueens {
    int[][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return new ArrayList();
        result = new ArrayList();
        if(n == 1) {
            result.add(Arrays.asList("Q"));
            return result;
        } 
        board = new int[n][n];
        backtrack(0);
        return result;
    }
    
    private void backtrack(int row){
        if(row == board.length){
            result.add(convert());
            return;
        }
        
        for(int col = 0; col <board[0].length;col++){
            if(valid(row,col)){
                board[row][col] = 1;
                backtrack(row+1);
                board[row][col] = 0;    
            }
        }
    }
    
    private boolean valid(int row, int col){
        int r = row, c = col;
        while(r>=0){
            if(board[r--][c] == 1) return false;
        }
        r=row;
        while(c>=0 && r>=0){
            if(board[r--][c--] == 1) return false;
        }
        r=row;c=col;
        
        while(c<board[0].length && r>=0){
            if(board[r--][c++] == 1) return false;
        } 
        return true;
    }
    
    private List<String> convert(){
        List<String> b = new ArrayList();
        for(int i=0;i<board.length;i++){
            StringBuilder sb  =new StringBuilder();
            for(int j = 0 ; j < board[0].length;j++){
                sb.append(board[i][j] == 1 ? "Q" : ".");
            }
            b.add(sb.toString());
        }
        return b;
    }
}