class Solution {
    int [] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j]='-';
                    if(dfs(i,j,1,word,board)){
                        return true;

                    }
                    board[i][j]=word.charAt(0);

                }
            }
        }

        return false;

    }

    private boolean dfs(int i, int j, int wi, String word, char[][] board ){
        if(wi == word.length()){
            return true;
        }
        for(int k =0;k<4;k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(isValid(nx,ny,word,board) && word.charAt(wi)==board[nx][ny]){
                board[nx][ny]='-';
                if(dfs(nx,ny,wi+1,word,board)) return true;
                board[nx][ny]=word.charAt(wi);
            }

        }
        return false;
    }

    private boolean isValid(int i,int j, String word, char[][] board){
        if(i>=board.length || j>= board[0].length || i<0 || j<0)return false;
        return true;

    }
}