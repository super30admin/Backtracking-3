""""// Time Complexity : O(n!) --> exponential.
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        if n == 0:
            return result
        board = [[False for i in range(n)] for j in range(n)]
        self.helper(board, 0, n)
        return self.result

    def helper(self, board, r, n):
        # base
        if r == n:
            l = []
            for i in range(n):
                st = ''
                for j in range(n):
                    if board[i][j] == True:
                        st += 'Q'
                    else:
                        st += '.'
                l.append(st)
            self.result.append(l)
            return

        # logic
        for i in range(n):
            if self.isSafe(board, r, i, n):
                # action
                board[r][i] = True
                # recurse
                self.helper(board, r + 1, n)
                # backtrack
                board[r][i] = False

    def isSafe(self, board, r, c, n):
        # column check
        for i in range(r):
            if board[i][c] == True:
                return False

        # diagnol left up
        i = r
        j = c
        while (i >= 0 and j >= 0):
            if board[i][j] == True:
                return False
            i -= 1
            j -= 1
        # diagnol right up
        i = r
        j = c
        while (i >= 0 and j < n):
            if board[i][j] == True:
                return False
            i -= 1
            j += 1
        return True





