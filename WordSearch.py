class Solution:
    def __init__(self):
        self.m=None
        self.n=None
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m=len(board)
        self.n=len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if(self.backtrack(board,word,i,j,0)):
                    return True
        return False
    def backtrack(self,board, word, i,j,index):
        if index==len(word):
            return True
        
        if i<0 or j<0 or i==self.m or j==self.n or board[i][j]=='#':
            return False
        
        dirs=[[0,1],[0,-1],[-1,0],[1,0]]
        if word[index]==board[i][j]:
            temp=board[i][j]
            temp=board[i][j]
            board[i][j]='#'
            
            for dir in dirs:
                r=i+dir[0]
                c=j+dir[1]
                if(self.backtrack(board,word,r,c,index+1)):
                    return True
            #BACKTRACK
            board[i][j]=temp
        return False
        
  Time is O(mn) as we touch traverse all the values
  Space is O(m*n) worst case recursive stack space
