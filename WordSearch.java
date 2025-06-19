//Time Complexity :O(m∗n∗3^L)
//Space Complexity : O(L)

class Solution {
    int [][] dirs;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0, -1}};
        for(int i = 0; i < m; i++){
            for(int j=0; j < n; j++){
                if(word.charAt(0)== board[i][j]){
                    if(helper(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
        private boolean helper(char[][] board, int r, int c, String word, int idx){
            if(idx == word.length()){
                return true;
            }

            if(r <0 || c< 0 || r == board.length || c == board[0].length) return false;
            if(board[r][c] == word.charAt(idx)){
                board[r][c] = '#';

                for(int [] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(helper(board, nr, nc , word, idx +1)){
                        return true;
                    };
                }
                board[r][c] = word.charAt(idx);
            }
            return false;
        }
}
