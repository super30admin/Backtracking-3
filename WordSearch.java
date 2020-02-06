//Time Complexity: O(4^l * (mn))
public class WordSearch {
    int m;
    int n;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, i, j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j){
        //Base Case
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return false; 
        //Logic
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if(board[i][j] == word.charAt(0)){
            if(word.length() == 1) return true;
            visited[i][j] = true;
            for(int[] dir: dirs){
                int x = dir[0] + i;
                int y = dir[1] + j;
                if(dfs(board, word.substring(1), x, y)) return true;
            }
            //backtrack
            visited[i][j] = false;
        }
        return false;
    }
}