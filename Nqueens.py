class Solution(object):
    result = []
    def solveNQueens(self, n):
        self.result = []
        grid = [[0 for i in range(n)] for j in range(n)]
        self.backtrack(grid, 0)
        return self.result
    
    def backtrack(self, grid, r):
        # base
        if r == len(grid):
            res = []
            for i in range(len(grid)):
                li = ""
                for j in range(len(grid)):
                    if grid[i][j] == 0:
                        li += "."
                    else:
                        li += "Q"
                res.append(li)
            self.result.append(res)
        # action
        for c in range(len(grid)):
            if self.is_safe(r, c, grid):
                grid[r][c] = 1
                # backtrack
                self.backtrack(grid, r+1)
                #recurse
                grid[r][c] = 0

    def is_safe(self,r, c, grid):
        # check col up
        for i in range(r):
            if grid[i][c] == 1:
                return False
        # diagonal top left
        i, j = r, c
        while i >= 0 and j >= 0:
            if grid[i][j] == 1:
                return False
            i -= 1
            j -= 1
        # diagonal top right
        i, j = r, c
        while i >= 0 and j < len(grid):
            if grid[i][j] == 1:
                return False
            i -= 1
            j += 1
        return True