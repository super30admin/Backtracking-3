#time: o(2^n)
#space:o(n)

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        board = [['.']*n for i in range (n)]
        ans = []
        def queen(col, ans, lowerDiagonal, upperDiagonal, board, leftRow):
    
            if col == n:
                ans.append(["".join(r) for r in board])
                return  
            for row in range(n):
                if leftRow[row]==0 and lowerDiagonal[row+col]==0 and upperDiagonal[n-1+col-row]==0:
                    board[row][col] = "Q"
                    leftRow[row] = 1
                    lowerDiagonal[row+col] = 1
                    upperDiagonal[n-1+col-row] = 1
                    queen(col+1, ans, lowerDiagonal, upperDiagonal, board, leftRow)
                    board[row][col] = "."
                    leftRow[row] = 0
                    lowerDiagonal[row+col] = 0
                    upperDiagonal[n-1+col-row] = 0
        queen(0, ans,  [0]*(2*n-1), [0]*(2*n-1), board, [0]*n)
        return ans