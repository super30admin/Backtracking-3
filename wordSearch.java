class Solution {
    int m; int n; boolean result; int[][] dirs;
    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0; i<m;i++){
            for(int j =0; j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    helper(board, word, i, j, 1);
                }
            }
        }
        return result;
    }
    
    private void helper(char[][] board, String word, int r, int c, int index){
        
        if(index == word.length()){
            result = true;
            return;
        } 
        
        char temp = board[r][c];
        board[r][c] = '#';
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == word.charAt(index)){
                helper(board,word,nr,nc,index+1);
            }
        }
        board[r][c] = temp;
        
    }
}