class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(1,i,j,visited, board, word))
                        return true;
                    else 
                        visited = new boolean[board.length][board[0].length];
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int idx, int i, int j, boolean[][] visited, char[][] board, String word){
        if(idx == word.length()) return true;
        visited[i][j] = true;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] d : dir){
            int x = d[0] + i, y = d[1] + j;
            if(x>=0 && y>=0 && x<visited.length && y<visited[0].length && !visited[x][y] && board[x][y] == word.charAt(idx)){
                //System.out.println(word.charAt(idx));
                if(idx == word.length() -1) return true;
                if(dfs(idx+1,x,y,visited,board,word)) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}