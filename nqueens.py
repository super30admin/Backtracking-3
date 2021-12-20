# TC==>O(N!)
# SC==>O(N^2)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        def backtrack(path, r):
            if len(path) == n and r == n:
                res.append(path)
            for c in range(n):
                if all(r != r1 and c != c1 and abs(r - r1) != abs(c - c1)
                          for r1, c1 in path):
                    backtrack(path + [(r, c)], r + 1)
        backtrack([], 0)
        return [[''.join('Q' if (i, j) in val else '.' for i in range(n)) for j in range(n)]for val in res]