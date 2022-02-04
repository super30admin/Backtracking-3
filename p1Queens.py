"""
time: O(N!)
space: O(N), N = depth of recursion
"""

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        ans =[]
        matrix = [["." for x in range(n)] for i in range(n)]
        
        inCol = set()
        posD = set()
        negD= set()
        
        def helper(row):
            if row == n: #passed the row bound, mat is complete
                copy = ["".join(row) for row in matrix]
                ans.append(copy)
                return
            for col in range(n):
                if col in inCol or (row+col) in posD or (row-col) in negD:
                    continue
                inCol.add(col)
                posD.add(row+col)
                negD.add(row-col)
                matrix[row][col]="Q"
                helper(row+1)
                
                inCol.remove(col)
                posD.remove(row+col)
                negD.remove(row-col)
                matrix[row][col]="."
        helper(0)
        
        return ans