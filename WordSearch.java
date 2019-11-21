/**
 * Time Complexity: O(4^n)??
 * Space Complexity: O(n)?
 * Leetcode: Does Not Run Successfully
 * Problems: Having problems tracking seen elements
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || board.length == 0) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j]){
                    if(word.length() == 1) return true;
                    boolean found = find(board, word, i, j, 0);
                    if(found) return true;
                }
            }
        }
        return false;
    }
    
    private boolean find(char[][] board, String word, int row, int col, int index){
        if(index == word.length()) return true;
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i = index; i < word.length(); i++){
            char current = word.charAt(i);
            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                if(r >=0 && r < board.length && c >=0 && c < board[0].length){
                    if(board[r][c] == current && find(board, word, r, c, i + 1)){
                        return true;
                    };
                }
            }
        }
        return false;
    }
}