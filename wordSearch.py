#Time Complexity: O(mn*(3^L))
#Space Complexity: O(L)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m=len(board)
        self.n=len(board[0])
        if len(board)==0 or board==None:
            return False
        self.dirs=[(0,1),(1,0),(0,-1),(-1,0)]
        for i in range(self.m):
            for j in range(self.n):
                if word[0]==board[i][j]:
                    if self.helper(board, i, j, word, 0):
                        return True
        return False
    
    def helper(self, board, i, j, word, index):
        #base
        if index==len(word):
            return True
        if i<0 or j<0 or i==self.m or j==self.n or board[i][j]=='#':
            return False
        #logic
        if board[i][j]==word[index]:
            for dir in self.dirs:
                nr=i+dir[0]
                nc=j+dir[1]
                #action 
                temp=board[i][j]
                board[i][j]='#'
                
                #recurse
                if self.helper(board, nr, nc, word, index+1):
                    return True
            
                #backtrack
                board[i][j]=temp
        return False
                