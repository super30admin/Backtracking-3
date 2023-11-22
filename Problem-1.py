class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        colSet, posDiagonal, negDiagonal = set(), set(), set()
        mat = [['.' for i in range(n)]for i in range(n)]
        result = []

        def backtrack(r):
            if r == n:
                copy = ["".join(row) for row in mat]
                result.append(copy)
                return
            
            for c in range(n):
                if c in colSet:
                    continue
                if r+c in negDiagonal or r-c in posDiagonal:
                    continue
                
                posDiagonal.add(r-c)
                negDiagonal.add(r+c)
                colSet.add(c)

                mat[r][c] = 'Q'
                backtrack(r+1)
                mat[r][c] = '.'

                posDiagonal.remove(r-c)
                negDiagonal.remove(r+c)
                colSet.remove(c)

        backtrack(0)
        return result
