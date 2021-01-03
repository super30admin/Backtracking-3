/*
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board is None or len(board) == 0:
            return False
        
        self.dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        rows, cols = len(board), len(board[0])
        for i in range(rows):
            for j in range(cols):
                if self.backtrack(board, word, i, j, 0):
                    return True
        
        return False
    def backtrack(self, board, word, row, col, index):
        if index == len(word):
            return True
        if row < 0 or row > len(board)-1 or col < 0 or col > len(board[0])-1:
            return False
        
        if board[row][col] == word[index]:
            temp = board[row][col]
            board[row][col] = "#"
            for r,c in self.dirs:
                new_row = r + row
                new_col = c + col
                
                if self.backtrack(board, word, new_row, new_col, index+1):
                    board[row][col] = temp
                    return True
            
            board[row][col] = temp
        
        return False
*/

// Time Complexity : O(4^l) where l is length of word
// Space Complexity : O(l) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: everytime a character matches I am starting dfs in that direction
class Solution {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        
        int rows = board.length, cols = board[0].length;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int row, int col, int index){
        if (index == word.length()){
            return true;
        }
        if (row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1)
            return false;
        
        if (board[row][col] == word.charAt(index)){
            char temp = board[row][col];
            board[row][col] = '#';
            for (int[] d:dirs){
                int new_row = d[0] + row;
                int new_col = d[1] + col;
                if (backtrack(board, word, new_row, new_col, index+1))
                    return true;
            }
            board[row][col] = temp;
        }
        
        return false;
    }
}