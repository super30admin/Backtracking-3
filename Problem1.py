# Time Complexity :O(n!) where n is input
# Space Complexity : O(n^2) single temp list
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        self.board = None
        self.result = []
        self.n = n

        if self.n <= 0:
            return self.result

        self.board = [None]*self.n
        for i in range(n):
            self.board[i] = [0]*self.n
        # iterate from zero index
        self.backtrack(0)
        return self.result

    def backtrack(self, r):

        if r >= self.n:
            temp = []
            for i in range(self.n):
                s = []
                for j in range(self.n):
                    if self.board[i][j] == 0:
                        s.append('.')
                    else:
                        s.append('Q')
                temp.append("".join(s))
            self.result.append(temp)

        # logic
        for j in range(self.n):

            if self.isSafe(r, j):
                self.board[r][j] = 1

                self.backtrack(r+1)

                self.board[r][j] = 0

    def isSafe(self, r, c):

        # same column
        for i in range(r):
            if self.board[i][c] == 1:
                return False

        # diagonal up right
        i = r-1
        j = c+1
        while i >= 0 and j < self.n:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j += 1

        # diagonal up right
        i = r-1
        j = c-1
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j -= 1

        return True
