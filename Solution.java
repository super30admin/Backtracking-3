class Solution {

    int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
            {
                //dfs call
                if(dfs(board, i, j, 0, word)) return true;
                

            }
        }

    return false;
        
    }

    private boolean dfs(char[][] board, int i , int j, int idx, String word)
    {
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '#') return false;

        if(board[i][j] != word.charAt(idx)) return false;

        board[i][j] = '#';

        for(int[] direction: directions){
            int r = direction[0] + i;
            int c = direction[1] + j;
                if(dfs(board, r, c, idx + 1, word)) return true;
        }

        board[i][j] = word.charAt(idx);

        return false;

    }
}