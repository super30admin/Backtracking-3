package Backtracking3;
// Time Complexity :O(3^L*N)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes

public class WordSearch {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int ind, int r, int c){
        //base
        if(word.length() <= ind)
            return true;
        if( r<0 || r>= board.length || c<0 || c>=board[0].length ||
                board[r][c] == '*' || board[r][c] != word.charAt(ind)){
            return false;
        }
        boolean ans = false;
        //logic
        for(int[] dir : dirs){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            char oldChar = board[r][c];
            board[r][c] = '*';
            ans = ans || backtrack(board, word, ind+1, nr, nc);
            board[r][c] = oldChar;
        }
        return ans;
    }
}
