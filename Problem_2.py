# TC : O(m * n * 3^L), L---> word length
# SC : O(L)

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board == None:
            return False
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        m = len(board)
        n = len(board[0])

        def backtrack(i, j, idx):
            # base
            if idx == len(word):
                self.flag = True
                return
            if i < 0 or j < 0 or i == m or j == n or board[i][j] == "#":
                return
            # logic
            # action
            if board[i][j] == word[idx] and not self.flag:
                board[i][j] = "#"
                # recurse
                for dir in dirs:
                    nr = dir[0] + i
                    nc = dir[1] + j
                    if not self.flag:
                        backtrack(nr, nc, idx+1)
                #backtrack
                board[i][j] = word[idx]

        self.flag = False
        for i in range(m):
            for j in range(n):
                backtrack(i, j, 0)
        return self.flag