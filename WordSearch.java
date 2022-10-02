// TC : O((m*n)(3^L)) - length of the string ( every position, we have 3 choices to make for every character of string of length L) & m*n - for the matrix
// SC : O(L) (Tree height/stack height would be length of the string)

public class WordSearch {
    private int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        //null check
        if(board == null || board.length == 0)
            return false;

        m = board.length;
        n = board[0].length;

        dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(backtrack(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board,String word, int i, int j,int idx){
        //base
        if(idx == word.length())
            return true;

        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;


        //logic
        if(board[i][j] == word.charAt(idx)){
            //action
            char c = board[i][j];
            board[i][j] = '#';
            //recurse
            for(int[] dir: dirs){
                int nr = i+ dir[0];
                int nc = j+ dir[1];
                if(backtrack(board,word,nr,nc,idx+1))
                    return true;
            }

            //backtrack
            board[i][j] = c;
        }

        return false;
    }
}