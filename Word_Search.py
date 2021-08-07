# Time Complexity : O(M*N*(3^L))
# Space Complexity : O(L) - Stack space

class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        if board == None or len(board) == 0:
            return False
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board, word, i, j, 0):
                    return True
        return False

    def backtrack(self, board, word, i, j, index):
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        #base
        if index == len(word):
            return True
        #logic
        #boundary Conditions
        if i < 0 or i == len(board) or j < 0 or j == len(board[0]) or board[i][j] != word[index]:
            return False
        #action
        temp = board[i][j]
        board[i][j] = "#"
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            if self.backtrack(board, word, r, c, index + 1):
                return True
        #Backtrack
        board[i][j] = temp
        return False