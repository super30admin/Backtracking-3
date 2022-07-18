#T(N)= O(N*3^L)
#S(N)= O(L)

class Solution:
    def dfs(self,b,w,i,j,ind,m,n):
        
        # Base
        if ind==len(w):
            return True
        # print(i,j,m,n)
        if i<0 or i>=m or j<0 or j>=n or b[i][j]!=w[ind]:
            return False
        
        # Logic
        te=b[i][j]
        b[i][j]="#"
        res=self.dfs(b,w,i+1,j,ind+1,m,n) or self.dfs(b,w,i-1,j,ind+1,m,n) or self.dfs(b,w,i,j+1,ind+1,m,n) or self.dfs(b,w,i,j-1,ind+1,m,n)
        b[i][j]=te
        return res
        
    
    def exist(self, board: List[List[str]], word: str) -> bool:
        m=len(board)
        n=len(board[0])
        ind=0
        for i in range(m):
            for j in range(n):
                if self.dfs(board,word,i,j,ind,m,n):
                    return True
        return False
        