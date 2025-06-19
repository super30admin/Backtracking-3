"""
Problem: N-Queens
Approach: Put only 1 queen in each row and put at an indes (row, j) only if that element is not present in the
diagonals or in that column and sole exhaistively using recursion.
t.c. => O(n!)
s.c. => O(n)
"""
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        colSet = set()
        diagSet = set()
        antiDiagSet = set()
        res = []
        matrix = [[False for i in range(n)] for j in range(n)]

        def helper(row):
            if row == n:
                print("h")
                path = []
                for i in range(n):
                    currRow = []
                    for j in range(n):
                        if matrix[i][j]:
                            currRow.append("Q")
                        else:
                            currRow.append(".")
                    path.append("".join(currRow))
                res.append(path)
                
                return 

            for i in range(n):
                diag = (i - row)
                antiDiag = (i + row)
            
                if (i in colSet) or (diag in diagSet) or (antiDiag in antiDiagSet):
                    print(diag)
                    continue
                colSet.add(i)
                diagSet.add(diag)
                antiDiagSet.add(antiDiag)
                matrix[row][i] = True
                helper(row + 1)
                matrix[row][i] = False
                colSet.remove(i)
                diagSet.remove(diag)
                antiDiagSet.remove(antiDiag)
        helper(0)
        return res