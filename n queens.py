class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def isSafe(row: int, col: int) -> bool:
            if col in cols:
                return False
            if (row - col) in diag1:
                return False
            if (row + col) in diag2:
                return False
            return True

        def placeQueens(row: int):
            if row == n:
                board = ["".join('Q' if i == col else '.' for i in range(n)) for col in queens]
                solutions.append(board)
                return
            
            for col in range(n):
                if isSafe(row, col):
                    queens[row] = col
                    cols.add(col)
                    diag1.add(row - col)
                    diag2.add(row + col)
                    placeQueens(row + 1)
                    queens[row] = -1
                    cols.remove(col)
                    diag1.remove(row - col)
                    diag2.remove(row + col)

        solutions = []
        queens = [-1] * n
        cols = set()
        diag1 = set()
        diag2 = set()

        placeQueens(0)
        return solutions
        
