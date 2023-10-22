/* 

Word Search(https://leetcode.com/problems/word-search/)

Time Complexity : O(m*n * 3^m*n)
Space Complexity : O(l)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/


class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }

        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, word, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col){
        if(index == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row == m || col == n || board[row][col] == '#'){
            return false;
        }

        if(board[row][col] == word.charAt(index)){
            char temp = board[row][col];
            board[row][col] = '#';
            for(int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(backtrack(board, word, index + 1, nr, nc)){
                   return true;
                }
            }
            board[row][col] = temp;
        }

        return false;

    }
}