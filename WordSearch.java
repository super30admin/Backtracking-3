// Time Complexity: O(L*4^L) where L is the length of the word
// Space Complexity: O(L) where L is the length of the word

class WordSearch {
    int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(i, j, word, board, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, String word, char[][] board, int idx){
        // base
        if(word.length() == idx){
            return true;
        }
        if(row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] == '*'){
            return false;
        }


        // logic

        if(word.charAt(idx) == board[row][col]){
            board[row][col] = '*';
            for(int[] dir: dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(dfs(nr, nc, word, board, idx+1)){
                    return true;
                }
            }
            board[row][col] = word.charAt(idx);
        }


        return false;
    }
}
