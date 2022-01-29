class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:  
        cols = set()     
        pdiag = set() 
        ndiag = set()
        board = [['.'] * n for i in range(n)]
        res = []
        def backtrack(row=0):
            if row == n:
                str = [''.join(row) for row in board]
                res.append(str)
                return
            for col in range(n):
                if col in cols or (row + col) in pdiag or (row - col) in ndiag:continue   
                cols.add(col)
                pdiag.add(row+col)
                ndiag.add(row-col)
                board[row][col] = 'Q'
                backtrack(row + 1)

                cols.remove(col)
                pdiag.remove(row+col)
                ndiag.remove(row-col)
                board[row][col] = '.'
        
        backtrack()
        return res
    
    
# T.C=> O(N!) 
# S.C=>O(n * n) => It depends of the size of the board
# Approach=> Here we make a copy of grid and place a . at ever place.
# Ones we decide to place a quenn just change th location on board to Q
# If the condition didn't match while backtracking just change all the Q to . and continue 
# from the last Q.
                