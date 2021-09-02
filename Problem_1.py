class Solution:
    def __init__(self):
        self.grid = []
        self.result = []

    def isSafe(self, n, row, col):
        for i in range(row):
            if self.grid[i][col]:
                return False
        i, j = row, col
        while i >= 0 and j >= 0:
            if self.grid[i][j]:
                return False
            i -= 1
            j -= 1
        i, j = row, col
        while i >= 0 and j < n:
            if self.grid[i][j]:
                return False
            i -= 1
            j += 1
        return True

    def backtrack(self, n, row):
        if row == n:
            li = []
            for i in range(n):
                sb = []
                for j in range(n):
                    if self.grid[i][j]:
                        sb.append('Q')
                    else:
                        sb.append('.')
                li.append(("").join(sb))
            self.result.append(li)
            return

        for i in range(n):
            if self.isSafe(n, row, i):
                self.grid[row][i] = True
                self.backtrack(n, row + 1)
                self.grid[row][i] = False

    """
    Backtrack approach, simply put Q in all places in first row and check if its valid
    TC - O(nxn)
    SC - O(nxn)
    """

    def solveNQueens(self, n: int) -> List[List[str]]:
        if n == 0:
            return self.result
        self.grid = [[False for _ in range(n)] for j in range(n)]
        self.backtrack(n, 0)
        return self.result
