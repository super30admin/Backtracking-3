'''
TC: O(N!) - For placing each queen it is gonna be - N*(N-2)*(N-4)*(N-6)*... ~N!
SC: O(N^2) where N is the number of rows or cols cause it is a square matrix
'''
from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        tile = [[False for i in range(n)] for j in range(n)]

        def printMyList(tile):
            ans = []
            for i in range(len(tile)):
                s = ""
                for j in range(len(tile[0])):
                    if tile[i][j]:
                        s+='Q'
                    else:
                        s+='.'
                ans.append(s)
            return ans

        def isQueenPresent(r, c, tile):
            #Up
            nr, nc = r, c
            while nr>=0:
                if tile[nr][nc]:
                    return True
                nr -= 1

            #Diagonal Left Up
            nr, nc = r, c
            while nr>=0 and nc>=0 and nr<n and nc<n:
                if tile[nr][nc]:
                    return True
                nr -= 1
                nc -= 1

            #Diagonal Right Down
            nr, nc = r, c
            while nr>=0 and nc>=0 and nr<n and nc<n:
                if tile[nr][nc]:
                    return True
                nr -= 1
                nc += 1
            return False


        def backtrack(r, c, tile):
            if r==n:
                self.res.append(printMyList(tile))
                return
            
            #Columns
            for i in range(n):
                if not isQueenPresent(r,i,tile): 
                    tile[r][i] = True
                    backtrack(r+1, 0, tile)
                    tile[r][i] = False
        
        backtrack(0,0,tile)
        return self.res
s = Solution()
print(s.solveNQueens(4))
print(s.solveNQueens(6))