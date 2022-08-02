//tc: o(mn*3^l)
// sc: o(l)

class Solution {
    int[][] dirs;
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;

        // row
        m = board.length;
        //column
        n = board[0].length;

        // directions
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};// Up, Down, Right, left

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int index){
        // base case

        if(index == word.length()) return true;
        if(r<0 || c<0 || r==m || c==n || board[r][c] == '#') return false;
        //logic
        if(word.charAt(index) == board[r][c]){
            // action
            char ch = board[r][c];
            board[r][c] = '#';
            for(int[] dir: dirs){
                // new row
                int nr = dir[0] + r;
                // new column
                int nc = dir[1] + c;
                // recurse
                if(backtrack(board, word,  nr, nc, index + 1)){
                    return true;
                }

            }
            // backtrack
            board[r][c] = ch;

        }
        return false;

    }

}