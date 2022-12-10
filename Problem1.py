#Time complexity: N!
#Space complexity: O(N^2) for maintaining the grid (stack takes O(N))

#Accepted on Leetcode

#Approach:
#Use recursion (with backtracking), for each row take a position and check if it's valid (by checking all previous positions)
#If valid position, place queen and move to next row, if not valid backtrack to previous row and continue
#Maintain an n*n boolean grid to track placed queens, use this to backtrack/check validitity/place queens -> If row == n, it means all queens have been placed -> record this position

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.grid = [[False for i in range(n)] for j in range(n)]
        self.result = []


        self.recurse(0)

        return self.result

    def recurse(self, row):
        #base
        if row == len(self.grid):
            solnList = []
            for i in range(len(self.grid)):
                solnElem = []
                for j in range(len(self.grid)):
                    if self.grid[i][j] == False:
                        solnElem.append('.')
                    else:
                        solnElem.append('Q')
                solnList.append(''.join(solnElem))
            self.result.append(solnList)
            return

        #logic
        for col in range(len(self.grid)):
            if self.isSafePosition(row, col):
                #action
                self.grid[row][col] = True
                #recurse
                self.recurse(row + 1)
                #backtrack
                self.grid[row][col] = False


    def isSafePosition(self, row, col):
        #column check
        for i in range(row - 1, -1, -1):
            if self.grid[i][col] == True:
                return False
        
        #left diagonal check
        i = row - 1
        j = col - 1
        while i >= 0 and j >= 0:
            if self.grid[i][j] == True:
                return False
            i-=1
            j-=1

        #right diagonal check
        i = row - 1
        j = col + 1
        while i >= 0 and j < len(self.grid):
            if self.grid[i][j] == True:
                return False
            i-=1
            j+=1

        return True