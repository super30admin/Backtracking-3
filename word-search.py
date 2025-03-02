# Time O(mn* 3^L)
# Space O(1)
class Solution:
    def __init__(self):
        self.flag = False
        self.dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        self.m = 0
        self.n = 0

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    temp, board[i][j] = board[i][j], "."
                    self.dfs(board, word, 1, i, j)
                    board[i][j] = temp
        return self.flag

    def dfs(self, board: List[List[str]], word: str, i: int, r: int, c: int) -> None:
        if i >= len(word): 
            self.flag = True
            return
        
        for u, v in self.dirs:
            nr = r + u
            nc = c + v
            if -1 < nr < self.m and -1 < nc < self.n and board[nr][nc] == word[i]:
                temp, board[nr][nc] = board[nr][nc], "."
                self.dfs(board, word, i+1, nr, nc)
                board[nr][nc] = temp