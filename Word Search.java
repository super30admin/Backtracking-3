class Solution {

    private boolean helper(char[][] board, String word, int idx, boolean[][] visited, int i, int j){
        // base
        if(idx >= word.length()) return true;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0, -1}, {0,1}};
        char c = word.charAt(idx);
        for(int[] dir: dirs){
            int iNew = i + dir[0];
            int jNew = j + dir[1];
            if(iNew >= 0 && iNew < board.length && jNew >= 0 && jNew < board[iNew].length){
                if(!visited[iNew][jNew] && board[iNew][jNew] == c){
                    visited[iNew][jNew] = true;
                    boolean found = helper(board, word, idx+1, visited, iNew, jNew);
                    if(found) return true;
                    visited[iNew][jNew] = false;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    boolean found = helper(board, word, 1, visited, i,j);
                    if(found) return true;
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }
}
