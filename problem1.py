# Space Complexity: N^2 (Grid memory)
# Time Complexity: N! due to the is_safe function

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        grid = [[False for _ in range(n)] for _ in range(n)]

        def is_safe(grid, r, c, n):

            # column up
            for i in range(0, r):
                if grid[i][c]: 
                    return False

            # diag left up
            i=r
            j=c

            while i >=0 and j >= 0: 
                if grid[i][j]:
                    return False
                i-=1
                j-=1

            # diag right up
            i=r
            j=c

            while i>=0 and j < n: 
                if grid[i][j]:
                    return False
                i-=1
                j+=1
            
            return True
                    
        def backtrack(grid, res, r, n):
            # Base
            li = []
            if r == n: 
                # Valid Solution 
                for i in range(n): 
                    st = []
                    for j in range(n):
                        if grid[i][j]:
                            st.append('Q')
                        
                        else:
                            st.append('.')

                    li.append(''.join(st))
                res.append(li)

            # Logic
            for c in range(0, n):
                if is_safe(grid, r, c, n):
                    # Action
                    grid[r][c] = True
                    # Recurse
                    backtrack(grid, res, r+1, n)
                    #Backtrack
                    grid[r][c] = False

        backtrack(grid, res, 0, n)
        return res
