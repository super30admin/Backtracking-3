#TC - O(N)
#SC - O(N^2)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res=[]
        board=[["."]*n for i in range(n)]
        posDiag = set()
        negDiag = set()
        col = set()
        def backtrack(r):
            if r==n:
                copy= ["".join(row) for row in board]
                res.append(copy)
                return 
            for c in range(n):
                if c in col or (r+c) in posDiag or (r-c) in negDiag:
                    continue 
                posDiag.add(r+c)
                negDiag.add(r-c)
                col.add(c)
                board[r][c]="Q"
                backtrack(r+1)
                posDiag.remove(r+c)
                negDiag.remove(r-c)
                col.remove(c)
                board[r][c]="."
        backtrack(0)
        return res 
