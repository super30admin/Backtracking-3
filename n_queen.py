# Time Complexity: O(n!)
# Space COmplexity: O(n^2)
# Ran on Leetcode: Yes

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        board = [["." for i in range(n)] for j in range(n)]
        
        self.col = [False] * n
        self.dia_l = [False] * (n * 2)
        self.dia_r = [False] * (n * 2)
        
        if n == 0:
            return []
        self.solver(board, 0 ,0, n)
        
        return self.res
    
    def solver(self, board, i, j, n):
        if i == n:
            self.res.append(["".join(row) for row in board])
            return
        
        while j < n:
            
            if self.valid(board, i, j):
                
                board[i][j] = 'Q'
                
                self.col[j] = True
                self.dia_r[i + j] = True
                self.dia_l[i - j] = True

                self.solver(board, i + 1, 0, n)

                board[i][j] = '.'
                self.col[j] = False
                self.dia_r[i + j] = False
                self.dia_l[i - j] = False
                
            j += 1
    
    def valid(self, board, i, j):
        if self.col[j] or self.dia_r[i + j] or self.dia_l[i - j]:
            return False
        return True
        
        