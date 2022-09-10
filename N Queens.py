# TC : O(n!)
# SC : O(n)
class Solution(object):
    def solveNQueens(self, n):
        
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [[False for i in range(n)] for j in range(n)]
        self.result = []
        self.placequeens(board, 0, n)
        return self.result

    def placequeens(self, board, r, n):
        # base case
        if r == n:
            row = []
            
            for i in range(n):
                rowStr = ""
                for j in range(n):
                    if board[i][j]:
                        rowStr += "Q"
                    else:
                        rowStr += "."
                row.append(rowStr)
            self.result.append(row)
            return False

        
        for c in range(n):
            #action
            board[r][c] = True                
            if self.issafe(board, r, c):    
                #recurse           
                if self.placequeens(board, r + 1, n):
                    return True
            #backtrack
            board[r][c] = False
        return False

    def issafe(self, board, i, j):
        
        # same column
        for k in range(i):
            if board[k][j]:
                return False
            
        # left diagonal
        l = i - 1
        m = j - 1
        while l >= 0 and m >= 0:
            if board[l][m]:
                return False
            l -= 1
            m -= 1
            
        # right diagonal
        l = i - 1
        m = j + 1
        while l >= 0 and m <= len(board) - 1:
            if board[l][m]:
                return False
            l -= 1
            m += 1

        return True
