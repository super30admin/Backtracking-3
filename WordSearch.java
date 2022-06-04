// Time Complexity : O(e^(m * n) )
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


public class WordSearch {
    private int[][] dirs = new int[][] { {-1,0}, {0,-1}, {0,1}, {1,0}};
    private int m;
    private int n;
    private boolean result;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        result = false;
        for(int i = 0; i < m; i++){
            for(int j =0 ; j < n; j++){
                if(result) return result;
                if(board[i][j] == word.charAt(0))
                    dfs(board, i, j, 0, word);
            }
        }
        return result;
    }
    private void dfs(char[][] board,int row, int column, int index, String word){
        //base condition
        if(index == word.length()) result = true;
        if(result) return;
        
        //logic
        char ch = '#';
        if(board[row][column] == word.charAt(index)){
            ch = board[row][column];
            board[row][column] = '#';
            if(index == word.length() - 1) result = true;
            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = column + dir[1];
                if(r < 0 || c < 0 || r >= m || c >= n) continue;
                dfs(board, r, c, index+1, word);
            }
            board[row][column] = ch;
        }
    }
}
