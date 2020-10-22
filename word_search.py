class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.board = board
        for i in range(0,self.m):
            for j in range(0,self.n):
                if self.backtrack(i,j,word):
                    return True
        return False
    
    def backtrack(self,i,j,word):
        if len(word)==0:
            return True
        
        if i<0 or i == self.m or j<0 or j==self.n or self.board[i][j]!=word[0]:
            return False
        self.board[i][j]='#'
        for i_,j_ in [(1,0),(0,1),(-1,0),(0,-1)]:
            if self.backtrack(i_+i,j_+j,word[1:]):
                return True
            
        self.board[i][j]=word[0]
        
        return False
            
        # tc o(nx3^k) because we have length of word k and each time we will have 3 direction to move because we can go back in the path.
        # sc o(k)
