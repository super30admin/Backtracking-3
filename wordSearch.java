class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        if(word.length() == 0) return true;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, word, i, j, 0)){
                    return true;
                }
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int index){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
        
        int [][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        if(board[i][j] == word.charAt(index)){
            //action
            char temp = board[i][j];
            board[i][j] = '#';
            //recurse
            for(int [] d : dirs){
                int r = i + d[0];
                int c = j + d[1];
                if(backtrack(board, word, r, c, index + 1)) return true;
            } 
            //backtrack
            board[i][j] = temp;
        
        }
        return false;
    }
}
