'''
Solution
1.  This can be solved using DFS + Backtracking on the given matrix.
2.  From any cell in the matrix, if the dfs from that cell returns true checking in all 4 directions for one cell, then
    it means that the word is present in the matrix.
3.  Backtrack once all possible directions of one cell are completely explored.

Time Complexity:    O(mxn x 2^L) where mxn is the size of the matrix and L the length of the word to be searched
Space Complexity:   O(L) at most L recursive calls on the recursive stack

--- Passed all testcases on Leetcode successfully
'''


class WordSearch(object):

    def __init__(self):
        self.nRows = 0
        self.nCols = 0

    def __dfs(self, board, word, wordIndex, row, col):

        #   base case - cell should be valid and not visited
        if (row < 0 or row >= self.nRows or col < 0 or col >= self.nCols or
                board[row][col] == '#'):
            return

        #   initialize dirs array for 4 neighbors
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        #   only if the cell value matches with the char at current index
        if (board[row][col] == word[wordIndex]):

            #   base case to return True
            if (wordIndex == len(word) - 1):
                return True

            #   action -- mark the cell visited
            currChar = board[row][col]
            board[row][col] = '#'

            #   recursion -- explore all 4 directions
            for d in dirs:
                newRow = row + d[0]
                newCol = col + d[1]
                if (self.__dfs(board, word, wordIndex + 1, newRow, newCol)):
                    return True

            #   backtrack -- mark the cell unvisited again
            board[row][col] = currChar

        #   return false if not found
        return False

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        #   edge case check
        if (board == None or len(board) == 0 or len(word) == 0):
            return False

        #   initialize number of rows and columns
        self.nRows = len(board);  self.nCols = len(board[0])

        #   for all cells, perform dfs until we hit a true case else return false
        for r in range(self.nRows):
            for c in range(self.nCols):
                if self.__dfs(board, word, 0, r, c):
                    return True

        #   return false if not found
        return False