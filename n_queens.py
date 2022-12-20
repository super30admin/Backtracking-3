class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        ## T.C = O(n!)
        ## S.C = O(n^2)
    
        result = []
        grid = [ [False for j in range(n)] for i in range(n)]

        def is_safe(row, col):
            r, c = row, col
            for i in range(r-1, -1, -1):
                if grid[i][c] == True:
                    return False
            
            r, c = row-1, col-1
       
            while (r>=0 and c >= 0):
                if grid[r][c] == True:
                    return False
                r -= 1
                c -= 1
            
            r, c = row-1, col+1
            
            while (r>=0 and c <n):
                if grid[r][c] == True:
                    return False
                r -= 1
                c += 1
            
            return True
        
        def backtrack(row):
            
            if row == n:
                res = []
                for i in range(n):
                    tmp_str = ''
                    for j in range(n):
                        if grid[i][j] == True:
                            tmp_str += 'Q'
                        else:
                            tmp_str += '.'
                    res.append(tmp_str)
                
                result.append(res)
                return

            for col in range(n):
                if is_safe(row, col):
                    # action
                    grid[row][col] = True

                    # recurse
                    backtrack(row + 1)

                    #backtrack
                    grid[row][col] = False

        backtrack(0)
        
        return result
