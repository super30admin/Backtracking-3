# Classical backtrack problem
# check row first
# check up column 0,i
# check left diagonal i--,j--
# check right diagonal i--,j++
# T.C. O(n!) where n is given grid row and olumns
# S.C. O(n)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n ==0:
            return[]
        
        global result
        result=[]
        global grid
        grid =[[False for _ in range(n)] for _ in range(n)]
        self.backtrack(0)
        
        return result
    
    def backtrack(self,row):
#         base
        if row==len(grid):
            resNewRows=[]
            for i in range(len(grid)):
                resRow=""
                for j in range(len(grid[0])):
                    if grid[i][j]==True:
                        resRow+="Q"
                    else:
                        resRow+="."
            
                resNewRows.append(resRow)
                # print(resNewRows)
            result.append(resNewRows)
            return
    
    # logic
        for i in range(len(grid)):
            if self.isSafe(row,i):
#             action
                grid[row][i]=True
#             recurse
                self.backtrack(row+1)
#             undo
                grid[row][i]=False

    
    
    def isSafe(self,r,c):
        # check the column
        for i in range(r):
            if grid[i][c]==True:
                return False
        
        i=r
        j=c
#         check the upper right
        while(i>=0 and j< len(grid)):
            # print(i,j)
            if grid[i][j]==True:
                return False
            i-=1
            j+=1
#         check upper left 
        
        i=r
        j=c
        while(i>=0 and j>=0):
            if grid[i][j]==True:
                return False
            i-=1
            j-=1
            
        return True
