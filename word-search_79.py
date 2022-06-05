#Approach: Backtracking
#Time Complexity O(3^N) for every child we are visiting threesides except character already visited 
#Space Complexity O(N) recursive stack space
#It successfully runs on leetcode

#changing state to #
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board: return False
        d= {(0,1),(0,-1),(1,0),(-1,0)}
        r, c = len(board), len(board[0])
        
        def find(board, word, ind, i, j, r, c):
                    if ind==len(word): return True
                    if i<0 or i==r or j<0 or j==c or board[i][j]== '#': return False 
                  
                    if board[i][j]==word[ind]:
                        board[i][j]="#"
                      
                        for x,y in d:
                            nr,nc= x+i, y+j
                            if find(board,word,ind+1, nr,nc, r,c): return True
                        board[i][j]=word[ind]
                            
                    return False     
                            
                            
        for i in range(r):
                for j in range(c):
                    if  find(board, word,0, i,j, r, c): return True
        return False


#storing visited string
class Solution:
    def __init__(self):
        self.res=False
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board: return False
        d= {(0,1),(0,-1),(1,0),(-1,0)}
        r, c = len(board), len(board[0])
        
        def find(board, word, ind, i, j, r, c, path):
                    if ind==len(word): 
                        self.res= True
                        return
                    if i<0 or i==r or j<0 or j==c or board[i][j]== '#': return False 
                  
                    if board[i][j]==word[ind]:
                        path+=board[i][j]
                        if path==word: 
                            self.res= True
                            return
                        board[i][j]="#"
                        
                        for x,y in d:
                            nr,nc= x+i, y+j
                            find(board,word,ind+1, nr,nc, r,c, path)
                        board[i][j]=word[ind]
                        path = path[:-1]
                           
                  
                            
        for i in range(r):
                for j in range(c):
                    find(board, word,0, i,j, r, c,"")
        return self.res  