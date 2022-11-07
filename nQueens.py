class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        rtnData = []
        if n == 0:
            return rtnData
        grid = [[False for j in range(n)] for i in range(n)]

        def isSafe(row, col):
            for i in range(row-1,-1,-1):
                if grid[i][col]== True:
                    return False
            i , j = row , col
            while i >=0 and j >= 0:
                if grid[i][j] == True:
                    return False
                i-=1
                j-=1
            i , j = row,col
            while i>=0 and j < n:
                if grid[i][j] == True:
                    return False
                i-=1
                j+=1
            return True


        def backtrack(row):
            if(row== n):
                ans = []
                for i in range(n):
                    string = ""
                    for j in range(n):
                        if(grid[i][j] == True):
                            string+='Q'
                        else:
                            string+='.'
                    ans.append(string)
                rtnData.append(ans)
                return

            for i in range(n):
                if(isSafe(row, i)==True):
                    grid[row][i] = True
                    backtrack(row+1)
                    grid[row][i] = False

        backtrack(0)
        return rtnData