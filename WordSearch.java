class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || word.length() == 0 || word == null || (word.length() > board.length * board[0].length)){
            return false;
        }
        
        for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[0].length; j++){
                if(backtracking(board, word, 0, i, j)) {
                    return true;
                }
           }
        }
        
        return false;
    }
    
    private boolean backtracking(char[][] board, String word, int index, int row, int col){
        if(index >= word.length()){
            return true;
        }else if(row < 0 || row >=board.length || col < 0 || col >= board[0].length || board[row][col] == '#' || word.charAt(index) != board[row][col]){
            return false;
        }
        
        board[row][col] ='#';
        
        for(int i = 0; i < dirs.length; i++){
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            
            if(backtracking(board, word, index + 1, newRow, newCol)) {
                return true;
            }
        }
        board[row][col] = word.charAt(index);
        
        return false;
    }
}

//Time Complexity : O(m*n * 3^l) l -> length of the word
//Space Complexity: O(l)