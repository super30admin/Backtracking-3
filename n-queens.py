# Time Complexity: O(N!)
# Space Complexity: O(N^2)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        
        res=[]
        grid=[[False] *n for _ in range(n)]

        def isSafe(row,col):
            for i in range(row):
                if grid[i][col]:
                    return False
            
            i=row
            j=col

            while(i>=0 and j>=0):
                if grid[i][j]:
                    return False
                i-=1
                j-=1

            i=row
            j=col

            while(i>=0 and j<len(grid)):
                if grid[i][j]:
                    return False
                i-=1
                j+=1
            
            return True


        def helper(r):
            #base
            if r==len(grid):
                sol=[]
                for i in range(len(grid)):
                    positions=[]
                    for j in range(len(grid)):
                        if grid[i][j]:
                            positions.append('Q')
                        else:
                            positions.append('.')
                
                    sol.append("".join(positions))
                
                res.append(list(sol))
                return 
            

            #logic
            for c in range(n):
                if (isSafe(r,c)):
                    grid[r][c]= True
                    helper(r+1)
                    grid[r][c]=False
         
        helper(0)
    
        return res

