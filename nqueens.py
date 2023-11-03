# // Time Complexity :O(n(n!))
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we recursively check in each row where to put the Q. if at any node we cant find a plae to put Q, 
# we backtrack to the previous row and change the assignment and check another baby and do the same until all rows are placed
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        def isSafe(r,c):
            # columsn up
            for i in range(r):
                if(grid[i][c]):
                    return False
            # diagonal top left
            i=r
            j=c
            while(i>=0 and j>=0):
                if(grid[i][j]):
                    return False
                i-=1
                j-=1
            # diagonal top right
            i=r
            j=c
            while(i>=0 and j<len(grid)):
                if(grid[i][j]):
                    return False
                i-=1
                j+=1
            return True
        def backtrack(r,n):

            # logic
            if(r==n):
                # make list of strs
                li=[]
                for i in range(n):
                    sb=""
                    for j in range(n):
                        if(grid[i][j]):
                            sb+="Q"
                        else:
                            sb+="."
                    li.append(sb)
                res.append(li)

            for c in range(n):
                if(isSafe(r,c)):
                    # action
                    grid[r][c]=True
                    # recurse
                    backtrack(r+1,n)
                    # backtrack
                    grid[r][c]=False

        grid=[[False for i in range(n)] for k in range(n)]
        res=[]
        backtrack(0,n)
        return res
        