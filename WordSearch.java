public class WordSearch {

    //Time Complexity: O(MXN)
    //Space Complexity: length of the word to search which is constant
    int[][] dirs;
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        // dfs approach

        for(int i = 0 ; i < board.length; i++){
            for(int j =0; j< board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    backtrack(board, i, j, 0, word);
                    if(flag == true){
                        return true;
                    }
                }
            }
        }

        return false;

    }
    private void backtrack(char[][] board, int i, int j, int idx, String word){

        if(idx == word.length()){
            flag = true;
            return;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)){
            return;
        }

        char temp = board[i][j];
        board[i][j] = '0';
        for(int[] dir: dirs){
            backtrack(board, i+dir[0], j+ dir[1], idx + 1, word);
        }
        board[i][j] = temp;
    }
}
