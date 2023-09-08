//TC = O(mn)3^L
//SC = O(L)
// Here we are using direction array to look for char in matrix. We are using combination of Backtrakcing and DFS.
class WordSearch{
    private int[][] dirs;
    int m; int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        dirs = new int[][] {{1,0}, {-1,0}, {0,-1}, {0,1}};
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(backtrack(board,word,i, j, 0)) return true;
            }
        }
        return false;
    }


    private boolean backtrack(char[][] board, String word, int i, int j, int index){
        //base
    if(index == word.length()) return true;
    if(i<0 || j<0 || i==m || j==n || board[i][j] == '#') return false;

        //logic
        if(board[i][j] == word.charAt(index)){
            //action
            board[i][j] = '#';
            //recurse
            for(int [] dir : dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(backtrack(board, word, nr, nc, index+1)) return true;
            }
            //backtrack
            board[i][j] = word.charAt(index);
        }
        return false;
    }
}
}=