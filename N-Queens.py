# time complexity is o(n!), where n is the size of the input
# space complexity is o(n^2), where n is the size of the input
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = list()
        board = [[True for i in range(n)] for i in range(n)] #space is n^2
        self.bt(n, board, 0, result)
        return result
    def bt(self, n, board, r, result):
        if(r == n):
            fl = list()
            for i in range(n):
                l = list()
                for j in range(n):
                    if(board[i][j]):
                        l.append('.')
                    else:
                        l.append('Q')
                fl.append(''.join(l))
            result.append(fl)
            return
                
        
        for j in range(n):
            if(self.issafe(board, r, j, n)):
                board[r][j] = False
                self.bt(n, board, r+1, result)
                board[r][j] = True
                    
    def issafe(self, board, r, c, n):
        for i in range(r):
            if(board[i][c] == False):
                return False
        i = r
        j = c
        while(i >= 0 and j >= 0):
            if(board[i][j] == False):
                return False
            else:
                i -= 1
                j -= 1
        i = r
        j = c
        while(i >= 0 and j < n):
            if(board[i][j] == False):
                return False
            else:
                i -= 1
                j += 1
        return True
        
                    

    
        