"""
Word Search(https://leetcode.com/problems/word-search/)
"""


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        """
        Space Complexity: O(len(word))
        TC: O(n*3^len(word))
        """
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[1, 0], [-1, 0], [0, -1], [0, 1]]
        self.board = board
        if board is None:
            return False

        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(i, j, word, 0):
                    return True
        return False

    def backtrack(self, row, column, word, index):
        if index == len(word):
            return True

        ###base
        if row < 0 or column < 0 or row >= self.m or column >= self.n or self.board[row][column] == "#":  ##visited
            return False

        ##logic

        if self.board[row][column] == word[index]:
            ##actionv

            char = self.board[row][column]
            self.board[row][column] = "#"
            for d in self.dirs:
                nr = d[0] + row
                nc = d[1] + column
                if self.backtrack(nr, nc, word, index + 1):
                    return True

            ###if we dont find we will backtrack

            self.board[row][column] = char
        return False

