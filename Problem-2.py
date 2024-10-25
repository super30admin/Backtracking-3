#T.C = 3^n(m*n) S.C = O(1)
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = ((-1,0),(1,0),(0,1),(0,-1))
        self.flag = False

        for i in range(self.m):
            for j in range(self.n):
                if(not self.flag):
                    self.helper(board,i,j,word,0)
                else:
                    break
        return self.flag

    def helper(self,board,i,j,word,idx):
        if(idx == len(word)):
            self.flag = True
            return
        
        if(i<0 or j<0 or i==self.m or j==self.n or board[i][j]=="#"):
            return

        if(word[idx] == board[i][j]):
            board[i][j] = "#"
            for dir in self.dirs:
                r = dir[0] + i
                c = dir[1] + j
                if(not self.flag):
                    self.helper(board,r,c,word,idx+1)

            board[i][j] = word[idx]

        
        