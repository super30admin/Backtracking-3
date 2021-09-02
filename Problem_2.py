class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    """
    backtrack approach, check all direction and maintaine a boolean
    TC - O(mxn)
    SC - O(mxn)
    """

    def backtrack(self, board, word, index, row, col):
        if index == len(word):
            return True
        if row < 0 or col < 0 or col == self.n or row == self.m or board[row][col] != word[index]:
            return False
        ch = board[row][col]
        board[row][col] = '#'
        for d in self.dirs:
            r = row + d[0]
            c = col + d[1]
            if self.backtrack(board, word, index + 1, r, c):
                return True
        board[row][col] = ch
        return False

    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        self.m = len(board)
        self.n = len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.backtrack(board, word, 0, i, j):
                        return True
        return False
