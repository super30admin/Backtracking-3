'''
Time Complexity  : factorial(n)
Space Complexity : N*N matrix initialization 0(n^2)
                   recursive stack 0(n)
On Leet-code: Yes
'''

class Solution:
    result = list()
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = list()
        board = [[False for i in range(n)] for j in range(n)]
        print(board)
        if n == 0:
            return self.result
        
        self.backtrack(0, n, board)
        return self.result
    
    
    def backtrack(self, row, n, board):
        # base
        if row == n:
            ll = []
            for li in board:
                ss = ''
                for k in li:
                    if k == True:
                        ss += 'Q'
                    else:
                        ss += '.'
                ll.append(ss)
            self.result.append(ll)
            return
                
            
        
        # logic
        for j in range(n):
            if self.isSafe(row,j, board, n):
                board[row][j] = True
                
                self.backtrack(row+1, n, board)
                
                board[row][j] = False
    
    def isSafe(self, i, j, board, n):
        
        for r in range(i):
            if board[r][j]:
                return False
        
        r = i
        c = j
        while r >= 0 and c >= 0:
            if board[r][c]:
                return False
            r -= 1
            c -= 1
        
        r = i
        c = j
        while r >= 0 and c < n:
            if board[r][c]:
                return False
            r -= 1
            c += 1
        return True
        