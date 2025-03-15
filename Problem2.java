// DFS with backtracking
// TC: O(mxnx4^l)
// SC: O(mxn) >> recursive stack
class Solution {
    boolean exist = false;
    int l;
    int m;
    int n;
    // int[][] visited;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        l = word.length();
        visited = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(l == 1) return true;
                    // visited[i][j] = 1;
                    board[i][j] = '*';
                    dfs(board, word, i, j, 1);
                    // visited[i][j] = 0;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return exist;
    }
    public void dfs(char[][] board, String word, int r, int c, int index){
        
        if(index == l){
            exist = true;
            return;
        }
        for(int[] dir : dirs){
            if(exist) return;
            int nr = r + dir[0];
            int nc = c + dir[1];
            // if(nr >= 0 && nr < m && nc >= 0 && nc < n && visited[nr][nc] != 1 && board[nr][nc] == word.charAt(index)){
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == word.charAt(index)){
                // visited[nr][nc] = 1;
                board[nr][nc] = '*';
                dfs(board, word, nr, nc, index + 1);
                // visited[nr][nc] = 0;
                board[nr][nc] = word.charAt(index);
            }
        }
    }
}
