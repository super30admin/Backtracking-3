class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if not n or n == 0:
            return []
        self.result = []
        self.grid = [[False for i in range(n)] for i in range(n)]
        self.recurse(0)
        return self.result
        
    def recurse(self, row):
        # base
        if row == len(self.grid):
            temp = []
            for i in range(len(self.grid)):
                st = ""
                for j in range(len(self.grid)):
                    if self.grid[i][j]:
                        st = st + "Q"
                    else:
                        st = st + "."
                temp.append(st)
            self.result.append(temp)
            return
        # logic
        for i in range(len(self.grid)):
            # if is valid position
            if self.isValid(row, i):
                # add case 
                self.grid[row][i] = True
                # action
                self.recurse(row + 1)
                # backtrack
                self.grid[row][i] = False
    


    def isValid(self, row, col):
        # check upper indexes
        i = row
        j = col
        while i >= 0:
            if self.grid[i][j]:
                return False
            i -= 1


        # check left diagonal 
        i = row
        j = col
        while i >= 0 and j >= 0:
            if self.grid[i][j]:
                return False
            i -= 1
            j -= 1

        # check right diagonal
        i = row
        j = col
        while i >= 0 and j < len(self.grid):
            if self.grid[i][j]:
                return False
            i -= 1
            j += 1
        
        return True

