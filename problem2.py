class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board==None or len(board)==0: return false
        self.m=len(board)
        self.n=len(board[0])
        self._dir=[[0,1],[1,0],[-1,0],[0,-1]]
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board,word,i,j,0) : return True
        
        return False
    
    # dfs
    def backtrack(self,board,word,i,j,index):
        #base
        if index==len(word): return True
        if i<0 or i >=self.m or j<0 or j>=self.n: return False
        
        #logic
        if word[index]==board[i][j]:
            #action
            temp=board[i][j]
            board[i][j]="#"
            #recurs
            for d in self._dir:
                r=i + d[0]
                c=j+ d[1]
                if self.backtrack(board,word,r,c,index+1): return True
                    
            board[i][j]=temp
                
                
        return False