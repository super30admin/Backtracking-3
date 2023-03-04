/*
Word Search
approach: dfs with backtracking
time: O(length of word)
space: O(length of word)
 */
public class Problem2 {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board==null || word.length()==0) return false;

        dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {

        if(index==word.length()) return true;
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]=='#') return false;

        if(board[r][c]==word.charAt(index)) {

            char curr = board[r][c];
            board[r][c] = '#';

            for(int[] dir: dirs) {
                int nr = dir[0]+r;
                int nc = dir[1]+c;
                if(dfs(board, word, nr, nc, index+1)) return true;
            }
            board[r][c] = curr;
        }
        return false;
    }
}
