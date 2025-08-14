# Time Complexity: O(m*n*2^l)
# Space Complexity: O(l)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        self.m = len(board)
        self.n = len(board[0])

        def dfs(row, col, index, word):
            if index == len(word):
                return True

            if row < 0 or col < 0 or row == self.m or col == self.n or word[index] == '#':
                return False

            if board[row][col] != word[index]:
                return False

            board[row][col] = '#'
            for k in self.dirs:
                nr = row + k[0]
                nc = col + k[1]

                if dfs(nr, nc, index + 1, word):
                    return True
            board[row][col] = word[index]

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if dfs(i, j, 0, word):
                        return True

        return False
