#Time Complexity: O(n!)
#Space Complexity: O(n2)
class Solution:
    result = []
    board = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.board = [[False for i in range(n)] for i in range(n)]
        self.helper(n,0)
        return self.result
        
        
    def helper(self,n,row):
        if row == n:
            lst = []
            for i in range(n):
                s = ''
                for j in range(n):
                    if self.board[i][j] == False:
                        s += '.'
                    else:
                        s += 'Q'
                lst.append(s)
            self.result.append(lst)
                        
        
        for i in range(n):
            if self.isValid(row,i,n):
                self.board[row][i] = True
                self.helper(n,row+1)
                self.board[row][i] = False
                
                
    def isValid(self,row,col,n):
        
        for i in range(row):
            if self.board[i][col] == True:
                return False
            
        orow,ocol = row,col
        
        while orow>=0 and ocol>=0:
            if self.board[orow][ocol] == True:
                return False
            orow -= 1
            ocol -= 1
            
        orow,ocol = row,col
        while orow>=0 and ocol<n:
            if self.board[orow][ocol] == True:
                return False
            orow -= 1
            ocol += 1
            
        return True