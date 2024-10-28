#Approach
# start with each word which has the starting letter in the board as start and find wecan achieve the word if not return false


#COmplexities
#Time: O(N*M*3^L)
#Space: O(1)


from typing import List


class Solution:
    def __init__(self):
        self.directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]

    def exist(self, board: List[List[str]], word: str) -> bool:
        startQueue = []
        self.rows = len(board)
        self.columns = len(board[0])

        for i in range(self.rows):
            for j in range(self.columns):
                if board[i][j] == word[0]:
                    startQueue.append((i, j))

        for (i, j) in startQueue:
            index = 0
            if self.helper(board, i, j, index, word):
                return True
        return False

    def helper(self, board, i, j, index, s):
        if index == len(s):
            return True

        if not (0 <= i < self.rows and 0 <= j < self.columns and s[index] == board[i][j]):
            return False

        temp = board[i][j]
        board[i][j] = '#'
        for [di, dj] in self.directions:
            nr, nc = i + di, j + dj

            if (self.helper(board, nr, nc, index + 1, s)):
                return True
        board[i][j] = temp
        return False

