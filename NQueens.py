class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        self.field = [[0 for _ in range(n)] for i in range(n)]
        def is_valid(r, c):
            return not self.field[r][c]
        def place(r, c):
            i, j = r, c
            for _ in range(n):
                self.field[r][_], self.field[_][c] = 1, 1
            for dx, dy in [(1,1), (-1,-1), (-1,1), (1,-1)]:
                i, j = r, c
                while 0<=i<n and 0<=j<n:
                    self.field[i][j] = 1
                    i+=dx;j+=dy
        def backtrack(row, candidate):
            if row == n:
                result.append(tuple(candidate))
                return
            for col in range(n):
                if is_valid(row, col):
                    temp = deepcopy(self.field)
                    place(row, col)
                    candidate.append('.'*col+'Q'+'.'*(n-col-1))
                    backtrack(row+1, candidate)
                    self.field = temp
                    candidate.pop()

        backtrack(0, [])
        return result