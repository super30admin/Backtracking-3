// Time Complexity : Add : O(m*n * #^L), m-rows, n-columns, L-length of word
// Space Complexity : O(L),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        exist(board, word);
    }

    static int[][] dirs;
    static int m, n;
    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;

        dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        m = board.length;
        n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, i, j, 0, word))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int wordIndex,  String word){
        //base
        if(wordIndex == word.length())
            return true;

        if(i<0 || j<0 || i==m || j==n || board[i][j] == '#')
            return false;

        //logic
        char ch = word.charAt(wordIndex);
        if(board[i][j] == ch){
            //action
            board[i][j] = '#'; //S.C - O(L)
            for(int[] dir: dirs){
                int r = dir[0] + i;
                int c = dir[1] + j;
                //recursion
                if(dfs(board, r, c, wordIndex+1, word)) // T.C - O(m * n * 3^L), L-Length of the word
                    return true;
            }
            //backtrack
            board[i][j] = ch;
        }
        return false;
    }
}

