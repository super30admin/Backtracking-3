# Time Complexity : n!
# Space Complexity : n^2
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
For loop based recursion
"""
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [[False] * n for i in range(0, n)]
        self.result = []
        self.helper(board, 0)
        return self.result

    def helper(self, board, r):
        if r == len(board):
            solution = []
            for row in board:
                rowStr = []
                for col in row:
                    if col:
                        rowStr.append("Q")
                    else:
                        rowStr.append(".")
                solution.append("".join(rowStr))
            self.result.append(solution)

        for i in range(0, len(board[0])):
            if self.isSafe(board, r, i):
                board[r][i] = True
                self.helper(board, r + 1)
                board[r][i] = False

    def isSafe(self, board, r, c):
        # column check
        for i in range(0, len(board)):
            if board[i][c]:
                return False

        # left top diagonal check
        i = r - 1
        j = c - 1
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1

        # right top diagonal check
        i = r - 1
        j = c + 1
        while i >= 0 and j < len(board[0]):
            if board[i][j]:
                return False
            i -= 1
            j += 1
        return True






