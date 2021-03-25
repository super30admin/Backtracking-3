class WordSearch {

    // Time Complexity: O(mn)
    // Space Complexity: O(mn)

    public final int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        // Edge Case Checking
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        int n = board.length;
        int m = board[0].length;
        boolean result = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    result = dfs(board, i, j, word,0, n, m);
                    // If word found - then return true
                    if(result)
                       return result;
                }
            }
        }
        return result;
    }
    
    // Do a DFS - traverse each character of the word to find the entire word character by character
    private boolean dfs(char[][] board, int row, int col, String word, int index, int n, int m){
        // If we reach the word length -> return true
        if(index == word.length()-1)
            return true;
        boolean output = false;
        char c = board[row][col];
        board[row][col] = '#';
        for(int[] dir: dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && index+1 < word.length() && board[nextRow][nextCol] == word.charAt(index+1)){
                output = dfs(board, nextRow, nextCol, word, index+1, n, m);
            }
            if(output)
                break;
        }
        board[row][col] = c;
        return output;
    }
}