# Time Complexity = O(3^n)  | Space Complexity = O(n)

class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        self.dirs = [(-1 ,0) ,(1 ,0) ,(0 ,1) ,(0 ,-1)]
        self.m = len(board)
        self.n = len(board[0])
        self.flag = False

        for i in range(self.m):
            for j in range(self.n):
                if(not self.flag):
                    self.helper(board, i, j, word, 0)
                else:
                    break

        return self.flag

    def helper(self, board: list[list[str]] ,i: int, j: int, word: str, idx: int):
        # base case

        if idx == len(word):
            self.flag = True
            return

        if i < 0 or j < 0 or i == self.m or j == self.n or board[i][j] == "!":
            return

        # logic
        if word[idx] == board[i][j]:
            # action
            board[i][j] = "!"
            # recurse
            for d in self.dirs:
                r = d[0] + i
                c = d[1] + j
                # if r >= 0 and c >= 0 and r < self.m and c < self.n and board[r][c] != "!" and not self.flag:
                self.helper(board, r, c, word, idx +1)
            # backtrack
            board[i][j] = word[idx]

