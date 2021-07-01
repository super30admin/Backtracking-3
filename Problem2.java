

// Time - O(N * 3^N)
// Space - O(L)

class Solution {
    int m;
    int n;
    int [][] dirs;
    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) {

            return false;

        }

        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(backtrack(board,word,0,i,j)) return true;

            }

        }

        return false;


    }

    private boolean backtrack(char[][] board, String word, int index, int r, int c){

        // base condition
        if(index == word.length()) {
            return true;
        }
        //logic

        // store value in temp by mutating the array
        char temp = board[r][c];
        board[r][c] = '#';
        for( int [] dir: dirs) {

            int i = r + dir[0];
            int j = c + dir[1];
            if(i >= 0 && i < m && j >= 0 && j < n && board[i][j] == word.charAt(index)) {

                // recurse
                if(backtrack(board,word,index+1,i,j)) return true;

            }

        }

        // backtrack by replacing # value to original element so that can be re-used
        board[r][c] = temp;
        return false;
    }

}
