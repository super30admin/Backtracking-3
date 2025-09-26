def exist(self, board: List[List[str]], word: str) -> bool:
    self.dirs=[[-1,0],[0,-1],[0,1],[1,0]]
    self.m=len(board)
    self.n=len(board[0])

    for i in range(self.m):
        for j in range(self.n):
            if self.dfs(board,i,j,word,0):
                return True
    return False

def dfs(self,board,i,j,word,idx):
    if idx==len(word):
        return True
    if i<0 or j<0 or i>=self.m or j>=self.n or board[i][j]=='#':
        return False
    if word[idx]!= board[i][j]:
        return False
    board[i][j]='#'

    for dir in self.dirs:
        r=dir[0]+i
        c=dir[1]+j

        if self.dfs(board,r,c,word,idx+1):
            return True
    board[i][j]=word[idx]
    return False
