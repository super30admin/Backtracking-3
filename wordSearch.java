class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word){
        if(board == null || board.length == 0){
            return false;
        }
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board,i,j, 0, word)){
                        return true;
                }
            }
        }
        return false;
    }
        
    
    int[][] dirs = {{-1,0}, {0,1},{0,-1}, {1,0}};
    
    private boolean dfs(char[][] board,int i, int j, int newIndex, String word){
        if(newIndex == word.length()){
            return true;
        }
        
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '*'){
            return false;
        }
        
        if(board[i][j] == word.charAt(newIndex)){
            char ch = board[i][j];
            board[i][j] = '*';
            for(int[] dir : dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(dfs(board, nr, nc, newIndex+1, word)){
                    return true;
                }
            }
            board[i][j] = ch;
        }
        return false;
    }  
}


