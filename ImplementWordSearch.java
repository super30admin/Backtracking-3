//Time Complexity : O(4 power n) since we can move four directions
//Space Complexity: O(n)
class Solution {
    int m, n;
    int[][] dirs;
    public boolean exist(char[][] board, String word)
    {
        //Validate inputs
        if(word.length() == 0) return true;
        if(board == null || board.length == 0) return false;

        //Initialize variables
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx)
    {
        //Invalid base case
        if(board[i][j] != word.charAt(idx)) return false;

        //Valid base case
        if(idx == word.length()-1) return true;

        //action
        char temp = board[i][j];
        board[i][j] = '#';

        //recurse
        for(int[] dir: dirs)
        {
            int r = dir[0] + i;
            int c = dir[1] + j;

            if(r >= 0 && r < m && c >= 0 && c < n && word.charAt(idx + 1) == board[r][c]){
                if(dfs(board, r, c, word, idx+1)) return true;
            }
        }

        //backtrack
        board[i][j] = temp;
        return false;
    }
}