class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        col=set()
        pos=set()#r+c
        neg=set()#r-c
        res=[]
        board=[["."]*n for i in range(n)]
        def backtracking(r):
            if r==n:
                copy=["".join(row) for row in board]
                res.append(copy)
                return
            for c in range(n):
                if c in col or (r+c) in pos or (r-c) in neg:
                    continue
                col.add(c)
                pos.add(r+c)
                neg.add(r-c)
                board[r][c]="Q"
                backtracking(r+1)
                col.remove(c)
                pos.remove(r+c)
                neg.remove(r-c)
                board[r][c]="."
        backtracking(0)
        return res
                