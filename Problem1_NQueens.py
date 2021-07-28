# Time Complexity: O(n!) , where n = row = col
# Space Complexity: O(n^2), due to board (n x n)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n == 0:
            return []

        self.board = [['.' for x in range(n)] for y in range(n)]
        self.result = list()

        self.helper(n, 0)
        return self.result

    def helper(self, n: int, r: int) -> None:
        # base - If 'Q' can be placed in all rows
        if r == n:
            li = list()
            for i in range(n):
                row = ""
                for j in range(n):
                    row += self.board[i][j]
                li.append(row)

            self.result.append(li)
            return

        # logic
        for c in range(n):
            if self.is_safe(n, r, c):
                # action
                self.board[r][c] = 'Q'
                # recurse - to the next row
                self.helper(n, r + 1)
                # backtrack
                self.board[r][c] = '.'

    def is_safe(self, n: int, r: int, c: int) -> bool:
        # upper column
        for i in range(r):
            if self.board[i][c] == 'Q':
                return False

        # upper left diagonal
        i, j = r, c
        while i >= 0 and j >= 0:
            if self.board[i][j] == 'Q':
                return False
            i -= 1
            j -= 1

        # upper right diagonal
        i, j = r, c
        while i >= 0 and j < n:
            if self.board[i][j] == 'Q':
                return False
            i -= 1
            j += 1

        return True





