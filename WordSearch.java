// Time Complexity : O(N*3^L) We have to make 3 decisions over each and every character(N) in the 2D array until we we find all the character in the word(L)
// Space Complexity : O(L), recursion stack equal to word length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class WordSearch {
    private int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    private int row;
    private int col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        for(int i=0; i<row;i++){
            for(int j=0; j<col;j++){
                if(dfs(board, word, i,j,0)) return true;
            }
        }


        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        //base
        //check if index == word length then return true
        if(index >= word.length()) return true;
        //check if  i and j out of bounds the  return false
        if(i<0 || j<0 || i>=row || j>=col || board[i][j]=='#') return false;

        //logic
        if(board[i][j] == word.charAt(index)) {
            //mark visited
            char c = board[i][j];
            board[i][j] = '#';
            //dfs
            for(int[] dir : dirs) {
                if(dfs(board, word, i+dir[0], j+dir[1], index+1)) return true;
            }
            //backtrack
            board[i][j] = c;

        }

        return false;
    }
}
