# Time Complexity : O(n!), at each row there are n choice then n-2 then n-4, where n is the input.
# Space Complexity : O(n^2), space for the board.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# This is a backtracking approach, where all possible placements of the
# queens are tried following the rules. If all queens has been placed,
# the result is converted to a list of strings and added to the result.
class Solution(object):
    def __init__(self):
        self.retVal = []
        self.board = None
        self.n = None

    def solveNQueens(self, n):
        if n <= 0:
            return self.retVal
        # saving to global scope
        self.n = n
        # board init
        self.board = [None] * n
        for i in range(n):
            self.board[i] = [0] * n
        # init recursive call
        self.backtrack(0)
        return self.retVal

    def backtrack(self, r):
        # base case
        if r >= self.n:
            # adding pattern as a string to result
            temp = []
            for i in range(self.n):
                s = []
                for j in range(self.n):
                    if self.board[i][j] == 0:
                        s.append('.')
                    else:
                        s.append('Q')
                temp.append("".join(s))
            self.retVal.append(temp)
        # logic
        # iterate
        for i in range(self.n):
            if self.isSafe(r, i):
                # action
                self.board[r][i] = 1
                # recurse
                self.backtrack(r + 1)
                # backtrack
                self.board[r][i] = 0

    def isSafe(self, r, c):
        # column above
        for i in range(r):
            if self.board[i][c] == 1:
                return False
        # diagonal up left
        i, j = r - 1, c - 1
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j -= 1
        # diagonal up right
        i, j = r - 1, c + 1
        while i >= 0 and j < self.n:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j += 1
        return True
