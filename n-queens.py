# O(N!) TIME AND O(N*N) SPACE
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [["." for _ in range(n)] for _ in range(n)]
        return self.placeQueens(board,0,[])
    
    def placeQueens(self,board,row,output):
        if row == len(board):
            output.append(list(''.join(i[:]) for i in board))
            return output
        
        for col in range(len(board)):
            if self.isValid(board,row,col):
                board[row][col] = "Q"
                self.placeQueens(board,row+1,output)
                board[row][col] = "."
        
        return output
    
    def isValid(self,board,row,col):
        
        i = row
        while i >= 0:
            if board[i][col] == "Q":
                return False
            i -= 1
        
        i = row
        j = col
        while i >= 0 and j >= 0:
            if board[i][j] == "Q":
                return False
            i -= 1
            j -= 1
            
        i = row
        j = col
        while i >= 0 and j < len(board):
            if board[i][j] == "Q":
                return False
            i -= 1
            j += 1
        
        return True
        
        
            
        
        
        
    
            
        