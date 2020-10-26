# Time Complexity : O(n*3^K)
# Space Complexity : O(K)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Global variable defining
# Your code here along with comments explaining your approach
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        self.nrows = len(board)
        self.ncols = len(board[0])
        self.board = board
        if not self.board:
            return False
        if self.nrows == 0 or self.ncols == 0 or len(word) == 0:
            return False
        
        for i in range(self.nrows):
            for j in range(self.ncols):
                if word[0] == self.board[i][j] and self.backtrack(word, i, j, 0):
                    return True
        return False
        
    def backtrack(self,word, row, col, strindex):
        if strindex >= len(word):
            return True

        if row < 0 or row >= self.nrows or col < 0 or col >= self.ncols or self.board[row][col] != word[strindex]:
            return False

        prev = self.board[row][col]
        self.board[row][col] = '#'

        dirs = [[-1,0], [0,1], [0, 1], [0, -1]]
        for dir_ in dirs:
            new_row = row + dir_[0]
            new_col = col + dir_[1]

            if(self.backtrack(word, new_row, new_col, strindex+1)):
                return True

        self.board[row][col] = prev
        return False
    
