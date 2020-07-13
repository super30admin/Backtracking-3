class Solution:
    
    """
         Student : Shahreen Shahjahan Psyche
         Time : N!
         Space: O(N*N) 
         
         Passed Test Cases in LC : Yes
    
    """
    
    def isValid(self, board, pos_i, pos_j):
        
        m = len(board[0])
        
        # check up
        i = pos_i
        while(i>=0):
            if board[i][pos_j] != 1:
                i -= 1
            else:
                return False
        
        # check left
        j = pos_j
        while(j>=0):
            if board[pos_i][j] != 1:
                j -= 1
            else:
                return False
        
        # check diagonal-left
        i = pos_i
        j = pos_j
        
        while(i >= 0 and j>=0):
            if board[i][j] != 1:
                i -= 1
                j -= 1
            else:
                return False
        
        # check diagonal-right
        i = pos_i
        j = pos_j
        
        while(i >= 0 and j<m):
            if board[i][j] != 1:
                i -= 1
                j += 1
            else:
                return False
        return True
    
    def helper(self, board, row, res):
        if row == len(board):
            tmp = []
            for i in range(len(board)):
                temp_str = ""
                for j in range(len(board[0])):
                    if board[i][j] == 0:
                        temp_str = temp_str + "."
                    else:
                        temp_str = temp_str + "Q"
                tmp.append(temp_str)
            res.append(tmp)
            return
            
        col = len(board[0])
        for j in range(col):
            if self.isValid(board, row, j):
                board[row][j] = 1
                self.helper(board, row+1, res)
                board[row][j] = 0
            

    def solveNQueens(self, n: int) -> List[List[str]]:
        
        if n < 0:
            return []
        
        board = [[0 for _ in range(n)] for _ in range(n)]
        row = 0
        res = []
        self.helper(board, row, res)
        
        return res
        
        
        
        
        
