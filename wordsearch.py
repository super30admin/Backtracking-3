class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        self.m = len(board)
        self.n = len(board[0])

        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(board, i, j, word, 0):
                    return True

        return False

    def dfs(self, board: List[List[str]], i: int, j: int, word: str, idx: int) -> bool:
        if idx == len(word): return True

        if i < 0 or j < 0 or i == self.m or j == self.n or board[i][j] == '#':
            return False

        if board[i][j] != word[idx]: return False

        # action
        board[i][j] = '#'

        # recurse
        for dir in self.dirs:
            r = dir[0] + i
            c = dir[1] + j

            if self.dfs(board, r, c, word, idx + 1): return True

        # backtrack
        board[i][j] = word[idx]

        return False

# TC - O(m * n * 4^L) where L = word.length()
# SC - O(L)