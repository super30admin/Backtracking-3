#TC-O(n!)
#SC-O(mn)
#logic-recurse through each row, in each row,try placing queen in all columnd and check if its safe,recurse to next row,
#if we reach i==n ,then we successfully found a solution and append it to glob
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        grid = [[False for i in range(n)] for j in range(n)]
        glob=[]
        def safe(i,j,n,grid):
            #row
            for c in range(n):
                if grid[i][c]:
                    return False
            #column
            for r in range(n):
                if grid[r][j]:
                    return False
            #topleft to bottom right diagonal
            r=i
            c=j
            while r>=0 and c>=0:
                if grid[r][c]:
                    return False
                r-=1
                c-=1
            #topright
            r=i
            c=j
            while r>=0 and c<n:
                if grid[r][c]:
                    return False
                r-=1
                c+=1
            return True
        def helper(grid,i,n):
            if i==n:
                result=[]
                for i in range(n):
                    l=''
                    for j in range(n):
                        if grid[i][j]:
                            l+='Q'
                        else:
                            l+='.'
                    result.append(l)   
                glob.append(result)          
                return 
            for j in range(n):
                if safe(i,j,n,grid):
                    grid[i][j]=True
                    helper(grid,i+1,n)
                    grid[i][j]=False
        helper(grid,0,n)
        return glob
            