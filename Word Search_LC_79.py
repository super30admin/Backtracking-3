class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or len(board) == 0:
            return False
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.recurse(board, word, 0, i, j):
                        return True
        return False

    def recurse(self, board, word, index, row, col):
        # base case
        if index == len(word):
            return True

        if row < 0 or row == self.m or col < 0 or col == self.n or board[row][col] == "#":
            return False

        # logic
        if board[row][col] == word[index]:
            # add case
            temp = board[row][col]
            board[row][col] = "#"
            for i, j in self.dirs:
                nr = row + i
                nc = col + j 
                # action / recusre
                if self.recurse(board, word, index + 1, nr, nc):
                    return True
            # backtrack
            board[row][col] = temp
        return False
