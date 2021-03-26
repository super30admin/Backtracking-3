// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//TC: O(N.3^L)
//SC: O(L)
class Solution{
public boolean exist(char[][] board, String word) {
    if(board == null || board.length == 0 || board[0]== null || board[0].length == 0 || word==null || word.length() == 0)return false;
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if(exist(board, i, j, word, 0)) return true;
        }
    }
    return false;
}

private boolean exist(char[][] board, int x, int y, String word, int start) {
    if(start >= word.length()) return true;
    if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
    if (board[x][y] == word.charAt(start++)) {
        char c = board[x][y];
        board[x][y] = '#';
        boolean res = exist(board, x + 1, y, word, start) || exist(board, x - 1, y, word, start) ||
        exist(board, x, y + 1, word, start) || exist(board, x, y - 1, word, start);
        board[x][y] = c;
        return res;
    }
    return false;
}
}