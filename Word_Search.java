// 79. Word Search - https://leetcode.com/problems/word-search/
// Time Complexity - exponential M*N * 3^L 
// Space Complexity - M*N * 3^L where m is rows and n is columns, 3L dirs array
// Did it run on leetcode? Yes
// Any problems? No


class Solution {
    int [][] dirs;
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board == null || board.length == 0) return false;
        
        dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        m = board.length;
        n = board[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++){
                if(board[i][j] != word.charAt(0)) continue;
                if(helper(board, i ,j, word, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, int r, int c, String word, int index){
        // base
        if(index == word.length()) return true;
        if(r<0 || r>=m || c<0 || c>=n || board[r][c] != word.charAt(index)) return false;
        
        // logic
        char temp = board[r][c];
        board[r][c] = '#'; // action
        
        for(int[] dir  : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(helper(board, nr, nc, word, index+1)) return true; // recurse
        }
        board[r][c] = temp;
        //board[r][c] = word.charAt(index);
        
        return false;
        
    }
}