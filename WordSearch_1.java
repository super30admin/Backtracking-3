package S30.BackTracking_3;

/*
Time Complexity : O(MxNx3^L) - L is length of the word
Space Complexity : O(L) - L is length of the word - Space of Recursive Stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class WordSearch_1 {

    int R;
    int C;
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public boolean exist(char[][] board, String word) {

        this.R = board.length;
        if(R == 0) return false;
        this.C = board[0].length;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){

                if(backtrack(board,word,0,i,j) == true) return true;
            }
        }

        return false;

    }

    public boolean backtrack(char[][] board,String word,int index,int r, int c){

        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r >= R || c >= C || word.charAt(index) != board[r][c]) return false;

        char ch = board[r][c];
        board[r][c] = '#';
        for(int[] dir : dirs){
            int row = r + dir[0];
            int col = c + dir[1];
            if(backtrack(board,word,index+1,row,col) == true){
                board[r][c] = ch; //restoring the state of the board before returning true
                return true;
            }

        }
        board[r][c] = ch; //restoring the state of the board
        return false;

    }
}
