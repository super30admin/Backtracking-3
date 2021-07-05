# Time Complexity : O(N!)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:

    def __init__(self):
        self.result = []
        self.board = []
        self.m = None

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.m = n
        self.board = [[0 for i in range(n)] for y in range(n)]
        self.backtrack(0)
        return self.result

    def backtrack(self, r):

        # base case
        if r == self.m:
            li = []
            for i in range(self.m):
                sb = []
                for j in range(self.m):
                    if self.board[i][j] == 1:
                        sb.append('Q')
                    else:
                        sb.append('.')
                s = "".join(sb)
                li.append(s)
            self.result.append(li)
            return

        # logic
        for j in range(self.m):
            if self.issafe(r, j):
                self.board[r][j] = 1
                self.backtrack(r + 1)
                self.board[r][j] = 0

    def issafe(self, row, col):
        # Column Up
        for i in range(row):
            if self.board[i][col] == 1:
                return False

            # diagonal Up Left
            i = row
            j = col
            while i >= 0 and j >= 0:
                if self.board[i][j] == 1:
                    return False
                i -= 1
                j -= 1

            # diagonal Up right
            i = row
            j = col
            while i >= 0 and j < self.m:
                if self.board[i][j] == 1:
                    return False
                i -= 1
                j += 1
        return True
