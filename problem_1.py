# Time Complexity - n! 
# Space Complexity- O(n)

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        matrix = [[False for j in range(n)] for i in range(n)]
        li = []
        self.backtrack(matrix, 0, n, li)
        return li

    def backtrack(self,matrix, r, n, li):
        if r == n:
            out = []
            for i in range(n):
                stringVal = ""
                for j in range(n):
                    if matrix[i][j]:
                        stringVal += 'Q'
                    else:
                        stringVal += '.'
                out.append(stringVal)
            li.append(out)
            return

        for j in range(n):
            matrix[r][j] = True
            if self.isSafe(matrix, r, j, n):
                self.backtrack(matrix, r+1, n, li)
            matrix[r][j] = False

    def isSafe(self,matrix, r, c, n):
       
        for i in range(r):
           
            if matrix[i][c]:
             
                return False
        i, j = r - 1, c - 1
        while i >= 0 and j >= 0:
            if matrix[i][j]:
              
                return False
            i -= 1
            j -= 1

        i, j = r - 1, c + 1
        while i >= 0 and j < n:
            if matrix[i][j]:
             
                return False
            i -= 1
            j += 1
       
        return True
