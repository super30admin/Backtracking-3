// Time Complexity : O(m*n* 3^L) where M*n is size of the board and L is the length of the word
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We wil be using DFS to traverse the board. We will run the DFS from each loc on the board.
 * For next dfs iteration we will check the next letter int he word is present at the neighbours,
 * if yes we replace the letter with temporary '#' value. Moving forward if we dont find the solution we backtrack
 * and replace '#' value to its existing character.
 *
 * */


public class WordSearch {

    int m,n;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {

        if(board==null || board.length==0) return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        //base
        if(index==word.length()) return true;

        if(i<0 || i>=m || j<0 || j>=n) return false;

        //logic
        if(board[i][j]==word.charAt(index)){
            char temp = board[i][j];
            board[i][j] = '#';
            for(int[] dir : dirs){
                int r = i+dir[0];
                int c = j+dir[1];
                if(backtrack(board, word, r, c, index+1)){
                    board[i][j] = temp;
                    return true;
                }
            }
            board[i][j] = temp;
        }
        return false;
    }


}
