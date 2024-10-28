#79 Word Search
class Solution(object):
    def exist(self, board, word): #T.C-> O(3^N) , S.C->O(N)
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.m = len(board)
        self.n = len(board[0])
        self.direction = [[-1,0],[1,0],[0,-1],[0,1]]
        self.flag = False
        for i in range(self.m):
            for j in range(self.n):
                if not self.flag:
                    self.dfs(board,i,j,word,0)
                else:
                    break
        return self.flag
    def dfs(self,board,i,j,word,idx):
        #base case
        if idx == len(word):
            self.flag = True
            return
        
        if i < 0 or j < 0 or i == self.m or j == self.n or board[i][j] == '*':
            return

        #logic
        if word[idx] == board[i][j]:
            #action
            board[i][j] = '*'
            #recursion
            for dir in self.direction:
                r = dir[0] + i
                c = dir[1] + j
                self.dfs(board,r,c,word,idx+1)
            #back-tracking
            board[i][j] = word[idx]
        