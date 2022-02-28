# Time complexity: Exponential = m * n * 3 ^ L where L is the length of the word
# Space complexity: O(L)

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board is None or len(board) == 0:
            return board

        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for i in range(0, self.m):
            for j in range(0, self.n):
                if board[i][j] == word[0] and self.helper(board, word, 0, i, j):
                    return True

        return False

    def helper(self, board, word, index, i, j):
        # base case
        if index == len(word):
            return True

        if i < 0 or j < 0 or i >= self.m or j >= self.n or board[i][j] == "#":
            return False

        # logic
        if board[i][j] == word[index]:
            ch = board[i][j]
            board[i][j] = "#"

            for dirs in self.dirs:
                nr = i + dirs[0]
                nc = j + dirs[1]

                if self.helper(board, word, index + 1, nr, nc):
                    return True

            board[i][j] = ch

            return False
