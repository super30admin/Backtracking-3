"""
time - exponential
space - o(m*n)
"""

class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [[0 for i in range(n)] for j in range(n)]
        res = []
        self.backtrack(board, res, 0, n)
        return res
    
    def backtrack(self, board, res, r, n):
        if r == n:
            temp = []
            for i in range(n):
                tempStr = ""
                for j in range(n):
                    if board[i][j] == 1:
                        tempStr += "Q"
                    else:
                        tempStr += "."
                temp.append(tempStr)
                
            res.append(temp)
            return 
        
        for i in range(n):
            if self.issafe(board, r, i):
                board[r][i] = 1
                self.backtrack(board, res, r + 1, n)    
                board[r][i] = 0
      
    
    def issafe(self, board, i, j):
        for k in range(i):
            if board[k][j] == 1:
                return False
        l = i - 1
        m = j - 1
        while l >= 0 and m >= 0:
            if board[l][m] == 1:
                return False
            l -= 1
            m -= 1
        l = i - 1
        m = j + 1
        while l >= 0 and m <= len(board) - 1:
            if board[l][m] == 1:
                return False
            l -= 1
            m += 1
        return True


        