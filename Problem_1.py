"""
Time Complexity : O(n!)- This is because, at first row, i have n decisions to make, ie n places to place 
the queen, in second row, it becomes n-2, in 3rd, its n-4 and so forth. So, its n(n-2)(n-4)....which if we 
round off, comes down to n(n-1)(n-2).... which is n!
Space Complexity : O(n^2) - n^2 for board + n for recursive stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
Here, starting from first row, we start placing the queen one column at a time, after first row, when we 
go to second row, we see if the queen is safe to be placed in a column. We check that by checking
values in upper rows for the same column, and diagonal up left and diagonal up right. If we find
any queen in those places, that means that the queen is not safe to be placed in the current column of that row.
So we move to the next column. When we find a safe place, we move to next row. If we do not find a safe place
in next row, we backtrack and change the column for the previous row. Whenever all the rows are traversed,
we traverse the board, and enter all the valid locations into the result.
"""


class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.m = n
        self.board = [[0]*n for _ in range(n)]
        self.backtrack(0)
        return self.result

    def backtrack(self, row):
        if row == self.m:
            temp = []
            for i in range(0, self.m):
                s = ""
                for j in range(0, self.m):
                    if self.board[i][j] == 0:
                        s += '.'
                    elif self.board[i][j] == 1:
                        s += 'Q'
                temp.append(s)
            self.result.append(temp)
            return

        for j in range(0, self.m):
            if self.isSafe(row, j):
                self.board[row][j] = 1
                self.backtrack(row+1)
                self.board[row][j] = 0

    def isSafe(self, r, c):
        for i in range(0, r+1):
            if self.board[i][c] == 1:
                return False
        i = r
        j = c
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j -= 1
        i = r
        j = c
        while i >= 0 and j < self.m:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j += 1
        return True
