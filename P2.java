class Solution {
    char placeholder = '.';
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0) return false;
        if(word == null || word.length() == 0) return true;
        int m = board.length;
        int n = board[0].length;
        char firstLetter = word.charAt(0);
        for(int i=0;i<m; i++) {
            for(int j=0;j<n;j++) {
               
                    if(helper(board, i, j, word, 0)) {
                        return true;
        
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int i, int j, String word, int index) {
        if(index == word.length()){
            return true;
        }
        
        if(word.length()==1 && word.charAt(index) == board[i][j] )  return true;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir: dirs) {
            int row = i+dir[0];
            int column = j+ dir[1];
            
            if(row>=0 && row<board.length && column>=0 && column< board[0].length && board[row][column] != placeholder) {
                char nextChar = board[row][column];
                if(word.charAt(index) == nextChar) {
                    board[row][column] = placeholder;
                    if(helper(board, row, column, word, index+1)) {
                       return true;
                    }
                    board[row][column] = nextChar; //Backtrack
                }
            }
        }
        return false;
    }
}