package Backtracking3;

public class question75_WordSearch {
    /* Created by palak on 7/6/2021 */

    /*
        DFS Approch:
            TC: O(n 3^L); L - length of word, n - no. of cells in board
            SC: O(L)
    */
    private int dirs[][];
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        //Base
        //check if the current character what we are looking for is at i and j index of the board
        if(index == word.length()) return true;

        if(r < 0 || c < 0 || r == m || c == n || word.charAt(index) != board[r][c]) return false;

        //Logic
        //Action
        char temp = board[r][c];
        board[r][c] = '#';

        //Recurse
        for(int dir[]: dirs) {
            int i = dir[0] + r;
            int j = dir[1] + c;
            if(backtrack(board, word, i, j, index + 1)) return true;
        }
        //Backtrack
        board[r][c] = temp;
        return false;
    }

    public static void main(String[] args) {

    }
}