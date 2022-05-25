// O(N 3^L) time complexity: invoke backtracking worst case N number of cells on board, L length of word to be matched, each direction to explore after initial choice is 3, so 3-ary tree is 3^L
// O(L), L is length of word to be matched, ie. max length of call stack

class Solution {
    private char[][] board;
    int rows;
    int cols;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (this.backtrack(row, col, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    protected boolean backtrack(int row, int col, String word, int index){
        // Step 1: check the bottom case
        if (index >= word.length()) return true;
        
        // Step 2: check boundaries
        if (row < 0 || row == rows || col < 0 || col == cols || board[row][col] != word.charAt(index)) return false;
        
        // step 3: explore the neighbors in DFS
        boolean ret = false;
        board[row][col]= '1'; // mark path before next exploration
        
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int dir = 0; dir < 4; dir++){
            ret = this.backtrack(row + rowOffsets[dir], col + colOffsets[dir], word, index + 1);
            if (ret) break;
        }
        
        // step 4: clean board and retun result
        this.board[row][col] = word.charAt(index);
        return ret;
    }
}