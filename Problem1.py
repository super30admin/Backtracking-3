class Solution(object):
    def isvalid(self,board,row,col,n):
        
        for i in range(row):
            if board[i][col] == 'Q':
                return False
        for j in range(col):
            if board[row][j] == 'Q':
                return False
        directions = [(-1,1),(-1,-1)]
        for rowD, colD in directions:
                r, c = row, col
                while 0<=r<=row and 0<=c<n:
                    if r != row and c != col and board[r][c] == 'Q':
                        return False
                    r+=rowD    
                    c+=colD
        return True
        
    def util(self,board,n,row):
        if row ==n:
            d_b = []
            for i in range(n):
                temp = ""
                for j in range(n):
                    temp += board[i][j]
                d_b.append(temp)
            self.res.append(d_b)
        for col in range(n):
            if self.isvalid(board,row,col,n):
                board[row][col] = 'Q'
                if self.util(board,n,row+1):
                    return True
                board[row][col] = '.'
        return False
        
    def solveNQueens(self, n):
        
        board = [['.' for i in range(n)] for i in range(n)]
        self.res = []
        self.util(board,n,0)
        return self.res
        """
        :type n: int
        :rtype: List[List[str]]
        """
        