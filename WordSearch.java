// TC - O(n * M)3^l, SC - O(n)

class Solution {
    public boolean exist(char[][] board, String word) {
        // sanity check 
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || word.length() == 0){
            return false;
        }
        
        // Iterate through board, if current char is equal to word.charAt(0), call backtrack function
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // dirs array
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    // backtrack function
    private boolean backtrack(char[][] board, String word, int r, int c, int index){
        // base function
        if(index == word.length() - 1){
            return true;
        }
        // store current r and c value of board into temp, we should not visit the cur node from its next direction, we will encode current value by changing it to * and decode it later 
        char temp = board[r][c];
        board[r][c] = '*';
        // iterating through dirs array
        for(int[] dir : dirs){
            // calculate new Row and new Col
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            // check out of bounds
            if(nr >= 0 && nr < board.length && nc >=0 && nc < board[0].length && board[nr][nc] == word.charAt(index+1)){
                // call backtrack with new indexes
                if(backtrack(board, word, nr, nc, index+1)){
                    return true;
                }
            }
        }
        // encode values
        board[r][c] = temp;
        return false;
    }
}