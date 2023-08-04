class Solution:
    # Time Complexity:O(MN4^L)
    # Space Complexity:O(L)
    def __init__(self):
        self.m = 0
        self.n = 0
        self.flag = False
        self.dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]

    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        self.m = len(board)
        self.n = len(board[0])

        for i in range(0, self.m):
            for j in range(0, self.n):
                if not self.flag:
                    self.backtrack(board, word, 0, i, j)
        return self.flag

    def backtrack(self, board, word, idx, i, j):
        if idx == len(word):
            self.flag = True
            return
        if i < 0 or j < 0 or i >= self.m or j >= self.n or board[i][j] != word[idx]:
            return
        if word[idx] == board[i][j]:
            board[i][j] = 0
            for dir in self.dirs:
                nr = dir[0] + i
                nc = dir[1] + j
                if not self.flag:
                    self.backtrack(board, word, idx + 1, nr, nc)
                if self.flag:
                    break
            board[i][j] = word[idx]
