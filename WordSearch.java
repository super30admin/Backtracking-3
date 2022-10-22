//Time: O(n * 3^l)
//Space: O(L)
class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int r, int c, String word, int index){
        if(index == word.length())
            return true;
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#')
            return false;
        if(board[r][c] == word.charAt(index)){
            char ch = board[r][c];
            board[r][c] = '#';
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(backtrack(board, nr, nc, word, index + 1))
                    return true;
            }
            board[r][c] = ch;
                
        }
        return false;
    }
}
