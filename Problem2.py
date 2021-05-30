class Solution(object):
    def util(self,board,word,index,row,col,m,n):
        if index >= len(word):
            return True
        if row < 0 or row >=m or col < 0 or col >=n or board[row][col]!= word[index]:
            return False
        
        board[row][col] = '#'
        
        row_offsets = [1,0,-1,0]
        col_offsets = [0,1,0,-1]
        
        for d in range(4):
            if self.util(board,word,index+1,row+row_offsets[d],col+col_offsets[d],m,n):
                return True
            
        
        board[row][col] = word[index]
        return False
    
        
        
    def exist(self, board, word):
        
        m = len(board)
        n = len(board[0])
        index = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if self.util(board,word,0,i,j,m,n):
                        return True
                    
        return False
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        