// Time Complexity : O(mn * 3 power L) ; L - length of given word
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes

public class WordSearch {

    int[][] dirs;
    int m; int n;
    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0) return false;

        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{1,0},{-1,0}, {0,-1}}; //ULDR

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(backtrack(board, i , j, 0, word)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, int index, String word){
        //base
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;

        //logic
        if(board[i][j] == word.charAt(index)){

            char c = board[i][j];
            //action
            board[i][j] = '#';
            for(int []dir : dirs){
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                //recurse
                if(backtrack(board, nr , nc, index + 1, word)) return true;
            }
            //backtrack
            board[i][j] = c;
        }

        return false;
    }

}
