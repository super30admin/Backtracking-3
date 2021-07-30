// Time complexity: O(N*M*(3^L)), where N*M is the size of the board, and L is the length of the word.
// Space complexity: O(L)

class Solution2 {
    int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}}; 
    public boolean exist(char[][] board, String word) {
        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[row].length; col++) {
                if(helper(board, row, col, word, 0)) return true;
            }
        }
        return false; 
    }
    
    public boolean helper(char[][] board, int row, int col, String word, int index) {
        //base case
        if(index == word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(index)) return false;
        
        //logic
        //action
        board[row][col] = '#'; 
        //recurse
        for(int[] d: directions) {
            if(helper(board, row+d[0], col+d[1], word, index+1)) return true;
        }
        //backtrack
        board[row][col] = word.charAt(index); 
        
        return false;
    }
}