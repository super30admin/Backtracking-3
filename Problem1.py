#In this code, I implemented the solution to the N-Queens problem using a backtracking approach. The goal is to place n queens on an n×n chessboard so that no two queens threaten each other. I initialized an empty chessboard and three sets to track columns (cols), positive diagonals (pos), and negative diagonals (neg) where queens are already placed. The backtrack function recursively tries to place a queen in each row. For each column in the current row, if placing a queen does not conflict with existing queens (checked via the sets), the queen is placed, and the function recurses to the next row. After trying all possibilities in a row, the queen is removed (backtracked), and the function continues. Once all queens are placed (r == n), the current board configuration is copied and added to the results list.

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.' for j in range(n)] for i in range(n)]
        cols,pos,neg = set(),set(),set()
        res = []

        def backtrack(r):
            if r==n:
                copy = [''.join(row) for row in board]
                res.append(copy)
                return

            for c in range(n):
                if c in cols or (r+c) in pos or (r-c) in neg:
                    continue

                cols.add(c)
                pos.add(r+c)
                neg.add(r-c)
                board[r][c]='Q'
                backtrack(r+1)
                cols.remove(c)
                pos.remove(r+c)
                neg.remove(r-c)
                board[r][c]='.'

        backtrack(0)
        return res