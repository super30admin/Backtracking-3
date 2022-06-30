#Time complexity: O(m*n*3^L)
#space complexity: O(L)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[0,1], [1,0], [0,-1], [-1, 0]]
        
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.backtrack(board, word, 0, i, j):
                        return True
        return False
    def backtrack(self, board, word, idx, r, c):
        if idx == len(word):
            return True
        
        if r < 0 or c < 0 or r == self.m or c == self.n or board[r][c] == "#":
            return False
        
        if board[r][c] == word[idx]:
            for d in self.dirs:
                nr = d[0] + r
                nc = d[1] + c
                board[r][c] = "#"
                if self.backtrack(board, word, idx+1, nr, nc):
                    return True
                board[r][c] = word[idx]
        return False
        
        
        
        
