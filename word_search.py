# Time: O(m*n*4^i)
# Space : (mn)
class Solution(object):
    dirs = []
    m,n = 0, 0
    def exist(self, board, word):
        self.dirs = [[0,1], [0,-1], [1,0], [-1, 0]]
        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board, i, j, word, 0):
                    return True
        return False
    
    def backtrack(self, board, i, j, word, idx):
        # base
        if idx >= len(word):
            return True

        if i < 0 or j < 0 or i >= self.m or j >= self.n:
            return False
        
        # action
        if board[i][j] == word[idx]:
            board[i][j] = '#'
            for d in self.dirs:
                rn, cn = i + d[0], j + d[1]
                if self.backtrack(board, rn, cn, word, idx + 1):
                    return True
            # recurse
            board[i][j] = word[idx]
        return False