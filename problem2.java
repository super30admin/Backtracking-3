// Time Complexity : m * n 3^L
// Space Complexity : m * n 3^L
// Did this code successfully run on Leetcode : Yes

/*Traverse the different directions of neighbors and check if we can find a path. 
Once you find it, change to # to mark it as visited. 
If the pointer reaches the length of the word successfully, then we have successfully found the word. 
 * 
 */

public class problem2 {
    private int[][] dirs;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, m, n, i, j, 0, word))
                        return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int m, int n, int i, int j, int idx, String word){
        if(idx == word.length())
            return true;
        if(i < 0 || j < 0 || i ==m || j == n || board[i][j] == '#')
            return false;
        if(board[i][j] == word.charAt(idx)){
            board[i][j] = '#';
            for(int dir[]: dirs){
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                if(backtrack(board,m, n,nr,nc,idx+1,word))
                    return true;
            }
            board[i][j] = word.charAt(idx);
        }
        return false;
    }
}