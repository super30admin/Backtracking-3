class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                if self.backtrack(board,word,i,j,0):
                    return True
        
        return False
    
    def backtrack(self,board,word,r,c,index):
        
        #base
        
        if index == len(word):
            return True
        
        
        if r < 0 or r == len(board) or c < 0 or c == len(board[0]) or board[r][c] == '#':
            return False
       
        
        
        #logic
        
        if board[r][c] == word[index]:
            temp = board[r][c]
            board[r][c] = '#'
            #print (board)
            dir_array = [(1,0),(0,1),(-1,0),(0,-1)]            
            for i in dir_array:
                row = i[0]+ r
                column = i[1] + c
                if self.backtrack(board,word,row,column,index+1):
                    return True
            board[r][c] = temp
            
        return False
        
                
                    
        
