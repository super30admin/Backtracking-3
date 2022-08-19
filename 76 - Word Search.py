class Solution:
    result = []
    m, n = 0, 0
    dirs = 0

    def exist(self, board: List[List[str]], word: str) -> bool:
        if board is None or len(board) == 0 or board[0] is None or len(board[0]) == 0:
            return False

        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(board, word, i, j, 0):
                    return True
        return False

    def dfs(self, board, word, i, j, index):
        if i < 0 or j < 0 or i == self.m or j == self.n or board[i][j] == "#":
            return False

        if index == len(word):
            return True

        if word[index] == board[i][j]:
            if index == len(word) - 1:
                return True
            ch = board[i][j]
            board[i][j] = "#"

            for d in self.dirs:
                r = i + d[0]
                c = j + d[1]
                if self.dfs(board, word, r, c, index + 1):
                    return True
            board[i][j] = ch
        return False

# TC =O(3^mn). Here m is for number of rows and n is number of columns in the board
# only for the middle row we have 4 choices, for the rest of the rows we have only 3 choices
# Space complexity : O(3^mn).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
