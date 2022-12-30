//Time Complexity: O(3^L) // l is the length of the string
//Space Complexity: O(L) // length of the string which will be in stack

/*
 * here we go through the board and find the first character in the word.
 * whenever we traverse through the board and find the elemnt we mark it visited and call
 * the recursion. If the length of the string is equal to index return true.
 */

class Solution {
    int [][] dirs;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(helper(board, word, i, j, m, n, 0)) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int r, int c, int m, int n, int idx){
        //base
        if(word.length() == idx){
            return true;
        }
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') return false;

        //logic
        if(word.charAt(idx) == board[r][c]){
            //action
            board[r][c] = '#';
            //recurse
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(helper(board, word, nr, nc, m, n, idx+1)) return true;
            }
                //backtrack
                board[r][c] = word.charAt(idx);
        }
        
        return false;
    }
}