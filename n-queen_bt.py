
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        #create a grid, with everything as false or sm, if we place queen,
        #change to true, create another secondary to check if valid pos
        #to place queen, if not move forward
        result=[]
        grid=[[False for _ in range (0, n)] for _ in range(0,n)]
        self.helper(grid, 0, result,n)
        return result

    def helper(self, grid, r, result,n): 
        #base
        if r==n:
            #create a list, that traverses the arr 
            li=[]
            for i in range(0, n):
                inner=""
                for j in range(0,n):
                    if grid[i][j]:
                        inner+="Q"
                    else:
                        inner+="."
                li.append(inner)
            result. append(li)
            return

        for c in range (n):
            #gear up for some hardass backtracking
            if self.isvalidpos(grid, r,c ,n):
                #action on grid: aka change it to true: but when? ifvalidpos
                grid[r][c]= True
                #recursion 
                self.helper(grid, r+1,result,n)
                #backtrack
                grid[r][c]= False




    def isvalidpos(self, grid, r, c,n):
        #valid column, means above it all rows of same col shouldnt have
        #queen
        i=0
        while i<r:
            if grid[i][c]: return False
            i+=1
        
        #up-left diagonal
        i=r-1
        j=c-1
        while i>=0 and j>=0:
            if grid[i][j]: return False
            i-=1
            j-=1
        
        #up-right diagonal
        i=r-1
        j=c+1
        while i>=0 and j<n:
            if grid[i][j]: return False
            i-=1
            j+=1

        #no need to check row, cuz first time placement in curr row
        #so if above conds arent passing, then yeah queen can be placed there
        return True 