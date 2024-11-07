class Solution:
    def __init__(self):

        self.flag = False
        self.dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])

        for i in range(self.m):
            for j in range(self.n):
                if not self.flag:
                    self.helper(board, i, j, word, 0)

                else:
                    break
        return self.flag

    def helper(self, board, i, j, word, idx):
        # base case
        if idx == len(word):
            self.flag = True
            return
        if i < 0 or j < 0 or i >= self.m or j >= self.n or board[i][j] != word[idx]:
            return

        temp = board[i][j]
        board[i][j] = "#"  # Mark as visited

        # recurse
        for dir in self.dirs:
            r = dir[0] + i
            c = dir[1] + j
            if not self.flag:
                self.helper(board, r, c, word, idx + 1)
        # backtrack
        board[i][j] = temp


# time complexity is O(3^n) where n is length of string
# space complexity is O(n)
