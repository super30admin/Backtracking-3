public class WordSearch {
    boolean[][] visited;
    int[][] dirs = {{1,0},{-1,0},{0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        visited = new boolean[m][n];

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(helper(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index){
        int m = board.length;
        int n = board[0].length;

        // base case
        if( index == word.length()){
            return true;
        }

        if(i<0 || j < 0 || i > m - 1 || j > n - 1){
            return false;
        }

        if(visited[i][j]){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }

        // logic
        visited[i][j] = true;

        for(int[] dir : dirs){
            int currI = i + dir[0];
            int currJ = j + dir[1];
            if(helper(board, word, currI, currJ, index+1)){
                return true;
            }
        }

        // backtrack

        visited[i][j] = false;

        return false;


    }
}
