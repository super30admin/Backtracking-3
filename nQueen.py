from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        mat = [[False for _ in range(n)] for _ in range(n)]

        def isSafe(matrix, row, col):
            for r in range(row):
                if matrix[r][col]:
                    return False

            for c in range(col):
                if matrix[row][c]:
                    return False

            # Check upper-left diagonal
            r = row
            c = col
            while r >= 0 and c >= 0:
                if matrix[r][c]:
                    return False
                r -= 1
                c -= 1

            # Check upper-right diagonal
            r = row
            c = col
            while r >= 0 and c < n:
                if matrix[r][c]:
                    return False
                r -= 1
                c += 1

            return True

        def helper(matrix, r):
            if r == n:
                path = []
                for irow in range(n):
                    currRow = []
                    for jcol in range(n):
                        if matrix[irow][jcol]:
                            currRow.append('Q')
                        else:
                            currRow.append('.')
                    path.append("".join(currRow))
                self.result.append(path)
                return

            for c in range(n):
                if isSafe(matrix, r, c):
                    matrix[r][c] = True
                    helper(matrix, r + 1)
                    matrix[r][c] = False

        helper(mat, 0)
        return self.result
