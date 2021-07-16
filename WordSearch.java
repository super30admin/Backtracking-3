// Time Complexity : Exponential
// Space Complexity : O(n ^ 2)

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, word, 1, i, j, m, n))
                        return true;
                }
            }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int index, int r, int c, int m, int n){
        //base
        if(index == word.length())
            return true;
        //logic
        int dirs[][] = {{-1, 0},{0, 1},{1, 0},{0, -1}};
        char temp = board[r][c];
        board[r][c] = '#';
        for(int[] dir: dirs){
            int i = r + dir[0];
            int j = c + dir[1];
            if(i >= 0 && i < m && j >= 0 && j < n && board[i][j] == word.charAt(index)){
                if(helper(board, word, index + 1, i, j, m, n))
                    return true;
            }
        }
        //backtrack
        board[r][c] = temp;
        return false;
    }
}