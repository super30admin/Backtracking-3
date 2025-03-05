class Solution {

    int[][] dirs = new int [][] {{0,1}, {1,0}, {-1, 0}, {0,-1}};
    int m;
    int n;
    boolean [][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board,word, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word, int i, int j){
        // base cases
        if(i < 0 || i >= m ||j < 0 || j >= n || visited[i][j]) return false;

        // logic
        if(word.charAt(0) == board[i][j]){
            if(word.length() == 1) return true;
            visited[i][j] = true;
            for(int [] dir : dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(dfs(board,word.substring(1), r , c)) return true;
            }
            // backtrack
            visited[i][j] = false;
        }
        return false;
    }
}