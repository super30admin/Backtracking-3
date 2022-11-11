class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[0].length; ++j){
                if(exist(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board,int i, int j, String word, int wi){
        if(wi==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length ){
            return false;
        }

        if(board[i][j]==word.charAt(wi)){
            board[i][j]='#';
            boolean ans = exist(board, i-1, j, word, wi+1)||exist(board, i+1, j, word, wi+1)||exist(board, i, j-1, word, wi+1)||exist(board, i, j+1, word, wi+1);
            board[i][j]=word.charAt(wi);
            return ans;

        }
        return false;
    }
}
//tc= mn3^l;
//sc=mn;
