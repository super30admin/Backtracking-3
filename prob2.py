class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.sz = len(word)
        
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        for i in range(self.m):
            for j in range(self.n):
                if(self.backtrack(board,word,i,j,0)):
                    return True
        return False
    
    def backtrack(self,board,word,r,c,index):
        if(index == len(word)):
            return True
        if(r<0 or c<0 or r == self.m or c == self.n or board[r][c]=='#'):
            return False
        
        
        #logic
        if(word[index]==board[r][c]):
            ch = board[r][c]
            board[r][c]='#'
            
            for d in self.dirs:
                nr = r + d[0]
                nc = c + d[1]
                if(self.backtrack(board,word,nr,nc,index+1)):
                    return True
                
                
            board[r][c]=ch
        return False                