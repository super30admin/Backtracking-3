class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m=len(board)
        self.n=len(board[0])

        self.dirs=[[-1,0],[0,1],[1,0],[0,-1]]

        for r in range(self.m):
            for c  in range(self.n):
                if self.helper(board,r,c,word,0):
                    return True
        return False

    def helper(self,board,r,c,word,idx):
        #base
        if idx==len(word):
            return True
        if r<0 or c<0 or r==self.m or c==self.n or board[r][c]=='#':
            return False
        if board[r][c]!=word[idx]:
            return False

        board[r][c]='#'
        #action
        for dir in self.dirs:
            i=r+dir[0]
            j=c+dir[1]

            if self.helper(board,i,j,word,idx+1):
                return True
        board[r][c]=word[idx]

        return False