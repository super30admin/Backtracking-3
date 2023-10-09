//TC - O(n*3^n)
//SC - O(1)
class Solution {
    int m, n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }
        m = board.length;
        n = board[0].length;

        dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(recurse(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean recurse(char[][] board, int row, int col, int index, String word){
        if(index == word.length()){
            return true;
        }


        if(row == m || col == n || row < 0 || col < 0 || board[row][col] == '#' ){
            return false;
        }

        if(board[row][col] == word.charAt(index)){
            //action
            char temp = board[row][col];
            board[row][col] = '#';
            for(int[] dir:dirs){
                int nr = dir[0] + row;
                int nc = dir[1] + col;
                //recurse
                if(recurse(board, nr, nc, index + 1, word)){
                    return true;
                }
            }
 

            //backtrack
            board[row][col] = temp;
        }
        return false;
    }
}