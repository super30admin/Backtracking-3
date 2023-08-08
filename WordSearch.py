#Time Complexity: O(4^k) or O(3^k) 4 directions for k length
#Space Complexity: O(h)

class Solution: 
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions=[[0,-1],[0,1],[-1,0],[1,0]]
        m=len(board)
        n=len(board[0])
        for i in range(0,m):
            for j in range(0,n):
                if self.helperFunction(word,board,i,j,0,directions,m,n):
                    return True
        return False
        
    def helperFunction(self, word, board, i,j, idx, directions,m,n):
        if idx==len(word):
            return True
        if i<0 or j<0 or i>=m or j>=n or board[i][j]=="#":
            return False
        if board[i][j]==word[idx]:
            board[i][j]="#"
            for d in directions:
                nr=i+d[0]
                nc=j+d[1]
                if (self.helperFunction(word,board,nr,nc,idx+1,directions,m,n)):
                    return True
            board[i][j]=word[idx]
        return False
        
