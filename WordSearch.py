# Time Complexity - O(N * 3^L) where N is number of cells in board and L is length of given word
# Space Complexity - O(L) for recursive stack (max will be length of the word)
class Solution:
    def exist(self, board, word):
        self.ROWS = len(board)
        self.COL = len(board[0])
        self.directions = [(0,1),(1,0),(-1,0),(0,-1)]
        for i in range(self.ROWS):
            for j in range(self.COL):
                if board[i][j] == word[0]:
                    if self.backtrack(board, i, j, word, 0):
                        return True
        return False
                    
    def backtrack(self, board, i, j, word, index):
        if index >= len(word)-1:
            return True
        temp = board[i][j]
        board[i][j] = "#"
        for d in self.directions:
            r = i + d[0]
            c = j + d[1]
            if r >= 0 and r < self.ROWS and c >= 0 and c < self.COL and index+1 < len(word) and board[r][c] == word[index+1]:
                if self.backtrack(board, r, c, word, index+1):
                    return True
        board[i][j] = temp
        return False
            
                
                