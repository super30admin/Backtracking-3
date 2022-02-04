class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        if board == None or len(board) == 0:
            return False
        
        m = len(board)
        
        n = len(board[0])
        
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        def btrack(board , i , j , index , word,dirs):
#          Base Case   
            
            if index == len(word):
                return True
            
            if i < 0 or j <0 or i== m or j== n or board[i][j] == "#":
                return False
            
            
            
            if board[i][j] == word[index]:
#                 Action
                ch = board[i][j]
                
                board[i][j] = "#"
                for a in dirs:
                    
                    r = i + a[0]
                    c = j + a[1]
                    
                    if btrack(board , r ,c ,index +1 , word,dirs):
                        return True
#                     BackTrack
                board[i][j] = ch
            return False
                      
        for i in range(m):
            for j in range(n):
                
                if btrack(board , i , j, 0, word,dirs):
                    return True
        
        return False
    
        