# Time Complexity : O(n!)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.board = [[False for _ in range(n)] for _ in range(n)]
        self.backtrack(0, n)
        return self.result

    def backtrack(self, r, n):
        if r == n:
            li = []
            for i in range(n):
                sb = []
                for j in range(n):
                    if self.board[i][j]:
                        sb.append('Q')
                    else:
                        sb.append('.')
                li.append("".join(sb))
            self.result.append(li)
            return

        for c in range(n):
            if self.isSafe(r, c, n):
                self.board[r][c] = True
                self.backtrack(r + 1, n)
                self.board[r][c] = False

    def isSafe(self, r, c, n):
        for i in range(r):
            if self.board[i][c]:
                return False

        i, j = r, c
        while i >= 0 and j >= 0:
            if self.board[i][j]:
                return False
            i -= 1
            j -= 1

        i, j = r, c
        while i >= 0 and j <= n - 1:
            if self.board[i][j]:
                return False
            i -= 1
            j += 1

        return True