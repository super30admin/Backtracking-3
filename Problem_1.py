# TC : O(N!)
# SC : O(N^2)

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        def isSafe(grid, r, c):
            #column up
            for i in range(0, r):
                if grid[i][c]:
                    return False          
            #diag up right
            i, j = r, c
            while i >= 0 and j < n:
                if grid[i][j]:
                    return False
                i = i - 1
                j = j + 1
            #diag up left
            i, j = r, c
            while i >= 0 and j >= 0:
                if grid[i][j]:
                    return False
                i = i - 1
                j = j - 1
            return True
              
        def helper(grid, i):
            # base
            if i == n:
                temp = []
                for r in range(0, n):
                    string = ""
                    for c in range(0, n):
                        if grid[r][c] == True:
                            string = string + "Q"
                        else:
                            string = string + "."
                    temp.append(string)
                self.res.append(temp)
                return

            # logic
            for j in range(0, n):
                if (isSafe(grid, i, j)):
                    # action
                    grid[i][j] = True
                    # recurse
                    helper(grid, i+1)
                    # backtrack
                    grid[i][j] = False

        grid = [[None for i in range(n)] for j in range(n)]
        helper(grid, 0)
        return self.res