// Time Complexity: O((m * n) 3^(L)) where m - no of rows, n - no of cols, L - length of word
// Space Complexity: O(L) where L - length of word

class Solution {
    int row;
    int col;
    int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }
        row = board.length;
        col = board[0].length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    private boolean search(char[][] board, String word, int i, int j, int idx){
        //base
        if(idx == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] == '#'){
            return false;
        }
        
        //logic
        if(board[i][j] == word.charAt(idx)){
            char ch = board[i][j];
            board[i][j] = '#';
            for(int[] dir:dirs){
                int r = dir[0]+i;
                int c = dir[1]+j;
                if(search(board, word, r, c, idx+1)){
                    return true;
                }
            }
            board[i][j] = ch;
        }
        return false;
    }
}