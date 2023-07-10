// Time Complexity : O(3^n) where n is the length of the word
// Space Complexity :O(n) where n is the length of the word
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
class WordSearch {
    private boolean flag;
    private int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][] {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
        int rows = board.length;
        int cols = board[0].length;

        for(int i =0; i< rows; i++){
            for(int j =0; j<cols; j++){
                if(!flag){
                    helper(board, word, i, j, 0);
                }
            }
        }
        return flag;
    }

    private void helper(char[][] board, String word, int r, int c, int idx){

        if(idx == word.length()){
            flag = true;
            return;
        }
        //base
        if(r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] == '#'){
            return;
        }

        //logic
        //action
        if(board[r][c] == word.charAt(idx)){
            board[r][c] = '#';
            //find the next letter in one of the neighbors
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                helper(board, word, nr, nc, idx+1);
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }

    }

}