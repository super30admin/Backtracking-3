#TC: O(mxn x 2^L)
#SC: O(L)

class Solution:
    def __init__(self):
        self.nRows = 0
        self.nCols = 0

    def __dfs(self, board, word, wordIndex, row, col):
        if (row < 0 or row >= self.nRows or col < 0 or col >= self.nCols or
                board[row][col] == '#'):
            return
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        if (board[row][col] == word[wordIndex]):
            if (wordIndex == len(word) - 1):
                return True
            currChar = board[row][col]
            board[row][col] = '#'
            for d in dirs:
                newRow = row + d[0]
                newCol = col + d[1]
                if (self.__dfs(board, word, wordIndex + 1, newRow, newCol)):
                    return True
            board[row][col] = currChar
        return False

    def exist(self, board, word):
        if (board == None or len(board) == 0 or len(word) == 0):
            return False
        self.nRows = len(board);  self.nCols = len(board[0])
        for r in range(self.nRows):
            for c in range(self.nCols):
                if self.__dfs(board, word, 0, r, c):
                    return True
        return False