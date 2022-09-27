// cannot be done by BFS
// TC: (m*n) * 3^L (L = length of the word)
// SC: L
class Solution {
    private int[][] dirs;
    int m; int n;
    public boolean exist(char[][] board, String word) {
        // null
        if (board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        dirs = new int [][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int i = 0; i<m; i++) {
            for (int j = 0; j <n; j++) {
                if (backtrack(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        //base
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i ==m || j == n || board[i][j] == '#') return false;
        
        //logic
        if (board[i][j] == word.charAt(index)) {
            char c = board[i][j];
            board[i][j] = '#';
            
            for (int[] dir : dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if (backtrack(board, word, nr, nc, index+1)) return true;
            }
            
            // backtrack
            board[i][j] = c;
        }
        return false;
    }
}