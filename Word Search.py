""""// Time Complexity : O(m*n*(3^L)) --> exponential
// Space Complexity : O(1); recursive stack space - O(L) --> L = length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.d = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.backtrack(board, i, j, word, 0):
                        return True
        return False

    def backtrack(self, board, i, j, word, index):
        # base
        if index == len(word):
            return True
        if i < 0 or j < 0 or i == self.m or j == self.n or board[i][j] == '#':
            return False

        # logic
        if board[i][j] == word[index]:
            board[i][j] = '#'
            for k in self.d:
                nr = i + k[0]
                nc = j + k[1]
                if self.backtrack(board, nr, nc, word, index + 1):
                    return True
            board[i][j] = word[index]
        return False
