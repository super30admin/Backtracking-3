// Time Complexity - O(3^word.length())
// Space Complexity - O(n^2)
class Solution {
    boolean flag;
    public boolean exist(char[][] board, String word) {
        flag = false;
        for(int m = 0; m < board.length; m++){
            for(int n = 0; n < board[0].length; n++){
                if(board[m][n] == word.charAt(0)){
                    dfs(board, word, m, n, 0);
                }
            }
        }

        return flag;
    }

    private void dfs(char[][] board, String word,int row, int col, int idx){
        // base case
        if(idx >= word.length()){
            flag = true;
            return;
        }
        // logic
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return;
        }
        if(word.charAt(idx) == board[row][col]){
            // action
            board[row][col] = '#';
            int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
            // recurse
            for(int[] dir : dirs){
                dfs(board, word, row+dir[0], col+dir[1],idx+1);
            }
            // backtrack
            board[row][col] = word.charAt(idx);
        }

    }
}
