//Time Complexity - (M*N * 3^L) where L is the length of the word
//Space Complexity - O(Depth of recursive stack which is length of word)

public class Word_Search_LC_79 {
    int [][] dirs;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
        for(int i =0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(dfs(i, j,board,word,0))
                    return true;
            }
        }
        return false;
    }
    boolean dfs(int i, int j,char[][] board, String word, int index) {
        int m = board.length;
        int n = board[0].length;
        if(index == word.length())
            return true;
        if(i >= m || i< 0 || j>= n || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }

        if(board[i][j]== word.charAt(index)){
            //action
            board[i][j] = '#';
            //recurse
            for(int[] dir : dirs ){
                if(dfs(i+dir[0], j+dir[1],board,word, index+1))
                    return true;
            }
            //backtrack
            board[i][j] = word.charAt(index);

        }
        return false;
    }
}